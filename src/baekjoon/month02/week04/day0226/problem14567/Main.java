package baekjoon.month02.week04.day0226.problem14567;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N+1];
		
		Map<Integer,List<Integer>>adjList = new HashMap<>();
		for(int i=1;i<=N;i++) adjList.put(i, new ArrayList<>());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList.get(A).add(B);
			indegree[B]+=1;
		}
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) q.offer(new int[] {i,1}); //이게 킥임
		}
		
		int[] semester = new int[N+1];
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int curVid = info[0];
			int curSem = info[1];
			semester[curVid] = curSem;
			for(int nextVid : adjList.get(curVid)) {
				if(--indegree[nextVid] ==0) {
					q.offer(new int[] {nextVid,curSem+1});
				}
			}
		}
		for(int i=1;i<=N;i++) {
			sb.append(semester[i]).append(" ");
		}
		System.out.println(sb);
		                    
	}

}
