package baekjoon.month03.week01.day0305.problem17471;

import java.io.*;
import java.util.*;

/*
 * 두개의 지역구로 나눔 -> perm
 *
 */
public class Main {
    static int N;
    static int[] human;
    static int[] vid;
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static int minSum, maxSum;

    static boolean bfs(List<Integer> li) {
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;
        int firstVid = li.get(0);

        visited[firstVid] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(firstVid);
        while (!q.isEmpty()) {
            int cvId = q.poll();
            if(!li.contains(cvId)) continue;
            cnt+=1;
            for (int nvId : adjList.get(cvId)) {
                if (!visited[nvId]) {
                    visited[nvId] = true;
                    q.offer(nvId);
                }
            }
        }
        return cnt==li.size();
    }

    static void subs(int index, List<Integer> li1, List<Integer> li2) {
        if (index == N + 1) {
            if (!li1.isEmpty() && !li2.isEmpty()) {
                if (bfs(li1) && bfs(li2)) {
                    int sum1 = 0;
                    for (int e : li1) {
                        sum1 += human[e];
                    }
                    int sum2 = 0;
                    for (int e : li2) {
                        sum2 += human[e];
                    }
                    minSum = Math.min(minSum, Math.abs(sum1 - sum2));
                }
            }
            return;
        }
        li1.add(vid[index]);
        subs(index + 1, li1, li2);
        li1.remove(li1.size() - 1);
        li2.add(vid[index]);
        subs(index + 1, li1, li2);
        li2.remove(li2.size() - 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 인원의 수
        human = new int[N + 1];
        vid = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList.put(i, new ArrayList<>());
            vid[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            human[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int adjNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < adjNum; j++) {
                adjList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        minSum = Integer.MAX_VALUE;
        subs(1, new ArrayList<>(), new ArrayList<>());
        if(minSum==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minSum);
        // comb로 정점의 개수
    }
}
