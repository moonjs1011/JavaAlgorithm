package baekjoon.month04.week02.day0406.problem2383;

import java.io.*;
import java.util.*;

class Person {
    int y;
    int x;

    public Person(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "(" + this.y + ", " + this.x + ")";
    }
}

class Stair {
    int y;
    int x;
    int num;

    public Stair(int y, int x, int num) {
        this.y = y;
        this.x = x;
        this.num = num;
    }
}

public class Solution {
    static List<Person> persons;
    static List<Stair> stairs;
    static int minTime;

    static int simulate(List<Person> list, Stair stair) {
        PriorityQueue<Integer> waitQ = new PriorityQueue<>();//계단타기전에 대기하는 큐, 거리순으로 오름차순 정렬
        PriorityQueue<Integer> downQ = new PriorityQueue<>();//실제로 계단을 타는 큐, 끝나는 시간순으로 오름차순 정렬
        for (Person p : list)
            waitQ.offer(Math.abs(p.x - stair.x) + Math.abs(p.y - stair.y));

        int time = 0;
        while(!waitQ.isEmpty()){
            int arriveTime = waitQ.poll();
            // 계단에 있는 사람 중, 현재 사람이 도착했을 때 이미 다 내려간 사람은 제거
            while (!downQ.isEmpty() && downQ.peek() <= arriveTime) {
                downQ.poll();
            }

            if (downQ.size() < 3) {
                // 바로 진입 가능 도착 1분 후부터 가능하므로 arriveTime + 1 + K
                int finishTime = arriveTime + 1 + stair.num;
                downQ.offer(finishTime);
                time = Math.max(time, finishTime);
            } else {
                // 계단이 꽉 참 -> 가장 빨리 나가는 사람의 시간 뒤에 줄 서기
                int fastExit = downQ.poll();
                int finishTime = fastExit + stair.num; // 앞사람 나가자마자 바로 진입
                downQ.offer(finishTime);
                time = Math.max(time, finishTime);
            }
        }
        return time;
    }

    static void subs(int index, List<Person> list1, List<Person> list2) {
        if (index == persons.size()) {
            int time1 = simulate(list1, stairs.get(0));
            int time2 = simulate(list2, stairs.get(1));

            minTime = Math.min(minTime, Math.max(time1, time2));
            return;
        }

        list1.add(persons.get(index));
        subs(index + 1, list1, list2);
        list1.remove(list1.size() - 1);

        list2.add(persons.get(index));
        subs(index + 1, list1, list2);
        list2.remove(list2.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            persons = new ArrayList<>();
            stairs = new ArrayList<>();
            minTime = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) persons.add(new Person(i, j));
                    else if (num > 1) stairs.add(new Stair(i, j, num));
                }
            }
            subs(0, new ArrayList<Person>(), new ArrayList<Person>());
            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }
        System.out.println(sb);
    }
}
