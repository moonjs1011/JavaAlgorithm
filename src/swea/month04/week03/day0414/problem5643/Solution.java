package swea.month04.week03.day0414.problem5643;

import java.io.*;
import java.util.*;
public class Solution {
	static int N,M,cnt;
	static int[] in,out;
	static List<Integer>[] GIn,GOut;
	static void dfs(int vid, List<Integer>[] g, boolean[]visited) {
		if(visited[vid]) return;
		visited[vid]=true;
		cnt+=1;
		for(int nvid : g[vid]) {
			dfs(nvid,g,visited);
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			List<Integer>[] GIn=new List[N+1];
			List<Integer>[] GOut=new List[N+1];
			for(int i=1;i<=N;i++) {
				GIn[i] = new ArrayList<>();
				GOut[i]=new ArrayList<>();
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				GIn[v1].add(v2);
				GOut[v2].add(v1);
			}
			
			int ans=0;
			for(int vid=1;vid<=N;vid++) {
//				if(dfs(vid,GIn,new boolean[N+1],0)==dfs(vid,GOut,new boolean[N+1],0))
//					ans+=1;
				cnt =0;
				dfs(vid,GIn,new boolean[N+1]);
				int res1 = cnt;
				cnt=0;
				dfs(vid,GOut,new boolean[N+1]);
				int res2 = cnt;
				if(res1+res2-1==N) ans+=1;
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}
}
