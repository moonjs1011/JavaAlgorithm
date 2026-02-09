package baekjoon.month02.week02.day0208.problem23350;
import java.io.*;
import java.util.*;

public class MainAgain {
    static Map<Integer,Integer> pMap = new HashMap<>();//컨테이너들의 개수를 확인하는 Map
    static Queue<int[]> belt = new ArrayDeque<>(); //컨베이어 벨트
    static Stack<int[]> stackSpace = new Stack<>();

    static int cost=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            pMap.put(P,pMap.getOrDefault(P,0)+1);
            belt.offer(new int[]{P,W});
        }
        while(!belt.isEmpty()) {
            int[] frontQ = belt.poll();
            int frontQP = frontQ[0];
            int frontQW = frontQ[1];

            //현재 벨트위에 자신보다 우선순위가 낮은게 존재하는지 검사
            boolean canStack = true;
            for (int i = frontQP + 1; i <= M; i++) {
                if (pMap.get(i) != null) {
                    canStack = false;
                    break;
                }
            }
            //적재 공간에 적재가 불가능하면 해당 컨테이너를 벨트의 맨 뒤에 삽입
            if (!canStack) {
                belt.offer(frontQ);
                cost += frontQW;
                continue;
            }
            //적재 공간에 넣을 준비
            Stack<int[]> tempSpace = new Stack<>();
            while (!stackSpace.isEmpty()) {
                int[] top = stackSpace.peek();
                int topP = top[0];
                int topW = top[1];
                //적재 공간의 top의 우선순위가 현재 넣고자하는 컨테이너의 우선순위보다 낮을 때, break
                if (topP > frontQP)
                    break;
                //적재 공간의 top의 우선순위가 현재 넣고자하는 컨테이너의 우선순위와 같고, 무게가 더 높을 때, break
                if (topP == frontQP && topW >= frontQW)
                    break;
                //임시 공간으로 적재공간의 컨테이너들을 옮김
                stackSpace.pop();
                cost += topW;
                tempSpace.push(top);
            }
            //map관리
            if (pMap.get(frontQP) == 1)
                pMap.remove(frontQP);
            else pMap.put(frontQP, pMap.get(frontQP) - 1);

            stackSpace.push(frontQ);
            cost += frontQW;
            //임시 공간에 있는 컨테이너를 적재 공간으로 다시 이동
            while (!tempSpace.isEmpty()) {
                int[] top = tempSpace.pop();
                int topW = top[1];
                cost += topW;
                stackSpace.push(top);
            }
        }
        System.out.println(cost);
    }
}
