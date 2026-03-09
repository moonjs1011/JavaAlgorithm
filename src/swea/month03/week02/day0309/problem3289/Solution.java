package swea.month03.week02.day0309.problem3289;

import java.io.*;
import java.util.*;
public class Solution {
	static int[] parent;
	static int find(int v1) {
		if(v1 == parent[v1]) return v1;
		return parent[v1] = find(parent[v1]);
	}
	static void union(int v1,int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if(p1!=p2) parent[p1] = p2;
		return;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for(int i=1;i<=N;i++) parent[i]=i;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int option = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(option==0) {
					union(a,b);
				}
				else {
					int p1 = find(a);
					int p2 = find(b);
					if(p1==p2) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
