package baekjoon.month02.week02.day0208.problem23350;
import java.io.*;
import java.util.*;
public class Main {
    static ArrayDeque<int[]> belt = new ArrayDeque<>();//컨베이어 벨트
    static ArrayDeque<int[]> stackSpace = new ArrayDeque<>();//컨테이너 적재용

    static Map<Integer,Integer> pMap = new HashMap<>();//우선순위를 기록할 Map
    static int cost=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            //map에 기록  O(1) time
            if(pMap.get(P)==null) 
                pMap.put(P,1);
            else pMap.put(P,pMap.get(P)+1);
            
            //O(1) time
            belt.offer(new int[]{P,W});
        }
        while(!belt.isEmpty()){// <- O(N) time
        	// O(1) time
            int[]front = belt.poll();
            int frontP= front[0];
            int frontW = front[1];
            boolean canPut = true; //적재 공간에 적재할 수 있나?
            
            // O(N) time
            for(int i=frontP+1;i<=M;i++){
                if(pMap.get(i)!=null){//컨베이어 벨트에 지금 바라보고 있는 컨테이너보다 우선순위가 낮은게 존재할때
                    belt.offer(new int[]{frontP,frontW});
                    cost+=frontW;
                    canPut = false;
                    break;
                }
            }
            if(!canPut){
                continue;
            }
            else{
               ArrayDeque<int[]>tempSpace = new ArrayDeque<>();
               // O(1) time
               if(pMap.get(frontP)==1)
                   pMap.remove(frontP);
               else pMap.put(frontP, pMap.get(frontP)-1);

               while(!stackSpace.isEmpty()){ //O(N)
                   int []top = stackSpace.peek();
                   if(top[0]>frontP) break;
                   if(top[0]==frontP && top[1]>=frontW) break;
                   stackSpace.pop();
                   cost+=top[1];
                   tempSpace.push(top);
               }
               stackSpace.push(new int[]{frontP,frontW});
               cost +=frontW;
               while(!tempSpace.isEmpty()) { // O(N) time
                   int[] temp = tempSpace.pop();
                   cost+=temp[1];
                   stackSpace.push(temp);
               }
            }
        }
        // Total : OuterLoop : O(N) x innerLoop's Max Time Complexity : O(N)
        // -> O(N^2)
        System.out.println(cost);

    }
}
