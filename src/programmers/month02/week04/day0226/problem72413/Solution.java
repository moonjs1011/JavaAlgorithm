package programmers.month02.week04.day0226.problem72413;

//다익스트라 풀이
import java.util.*;
class Solution {
    static  Map<Integer,List<int[]>> adjList = new HashMap<>();
    static int[] dijkstra(int vid,int n){
        //인접리스트 초기화
        
        int[] dict = new int[n+1];
        //거리배열 초기화
         Arrays.fill(dict,Integer.MAX_VALUE);
        dict[vid]=0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(vid);
        while(!q.isEmpty()){
            int curV = q.poll();            
            for(int [] edge : adjList.get(curV)){
                int nextV = edge[0];
                int nextD = dict[curV] + edge[1];
                if(dict[nextV]>nextD){
                    dict[nextV]= nextD;
                    q.offer(nextV);
                }
            }
        }
        return dict;
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        //인접리스트 초기화
        for(int i=1;i<=n;i++) adjList.put(i,new ArrayList<>());
        for(int []edge : fares){
            int v1= edge[0];
            int v2 = edge[1];
            int weight = edge[2];
            //인접리스트 간선 추가
            adjList.get(v1).add(new int[]{v2,weight});
            adjList.get(v2).add(new int[]{v1,weight});
        }
        int dictS[] = dijkstra(s,n); //s를 시작으로하는 최소거리 배열
        int dictA[] = dijkstra(a,n); //a를 시작으로하는 최소거리 배열
        int dictB[] = dijkstra(b,n); //b를 시작으로하는 최소거리 배열
        //s->a->b의 최소거리
        int distAtoB = dictS[a] + dictA[b];
        //s->b->a의 최소거리
        int distBtoA = dictS[b] + dictB[a];
        //s->middle->(middle->a) + (middle->b) <- middle까지 같이 같다가 찢어지는 경우
        int minDist = Integer.MAX_VALUE;
        for(int mid =1;mid<=n;mid++){
            // int[] dictMid = dijkstra(mid,n);
            // minDist = Math.min(minDist,dictS[mid]+dictMid[a]+dictMid[b]);<-시간 초과 코드.
            minDist = Math.min(minDist,dictS[mid]+dictA[mid]+dictB[mid]);
        }
        answer = Math.min(minDist,Math.min(distAtoB,distBtoA));
        return answer;
    }
}
