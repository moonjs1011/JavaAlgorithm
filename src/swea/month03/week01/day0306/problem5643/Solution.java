package swea.month03.week01.day0306.problem5643;

import java.io.*;
import java.util.*;
public class Solution {
	static int N,M,cnt;
	static void dfs(int vid,Map<Integer,List<Integer>>G,boolean[]visited) {
		if(visited[vid]) return;
		visited[vid]=true;
		cnt+=1;
		for(int nextVid : G.get(vid)) {
			dfs(nextVid,G,visited);
		}
	}
	static boolean check(boolean[] v1, boolean[] v2) {
		for(int i=1;i<=N;i++) {
			if(!v1[i]&&!v2[i]) return false; 
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			//init
			Map<Integer,List<Integer>>GIn = new HashMap<>();
			Map<Integer,List<Integer>>GOut = new HashMap<>();
			for(int i=1;i<=N;i++) {
				GIn.put(i, new ArrayList<>());
				GOut.put(i, new ArrayList<>());
			}
		
			for(int i=0;i<M;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				GOut.get(a).add(b);
				GIn.get(b).add(a);
			}
			int ans=0;
			for(int i=1;i<=N;i++) {
				cnt=0;
				boolean[] visitedIn = new boolean[N+1];
				boolean[] visitedOut = new boolean[N+1];
				dfs(i,GIn,new boolean[N+1]);
				dfs(i,GOut,new boolean[N+1]);
				if(cnt-1==N) ans+=1;

				
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
