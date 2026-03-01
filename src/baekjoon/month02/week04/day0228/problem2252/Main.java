package baekjoon.month02.week04.day0228.problem2252;

import java.io.*;
import java.util.*;
/*
 * 위상 정렬
 * degreeIn 기록
 * edge 기록
 * degreeIn이 0인 정점을 전부 queue에 넣음
 * 차수를 하나씩 줄여가면서 degreeIn이 0인것을 또 queue에 넣음
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] degreeIn = new int[N+1];
        for(int i=1;i<=N;i++) graph.put(i,new ArrayList<>()); //graph 초기화

        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            degreeIn[B]+=1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(degreeIn[i]==0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cVid = q.poll();
            System.out.println(cVid);
            for(int nVid : graph.get(cVid)){
                if(--degreeIn[nVid]==0){
                    q.offer(nVid);
                }
            }
        }
    }
}
