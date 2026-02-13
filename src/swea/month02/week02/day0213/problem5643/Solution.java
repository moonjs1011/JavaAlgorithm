package swea.month02.week02.day0213.problem5643;

import java.io.*;
import java.util.*;

/*
 * 크기가 작은순으로 한개, 큰순으로 한개 총 두개의 그래프를 구성
 * 두개의 그래프에 같은 정점으로 시작으로 순회를 수행
 * 모든 정점에 방문했으면 그 정점이 정답.
 */
public class Solution {
	static int N, M;

	static Map<Integer, Boolean> visited;

	static void dfs(int vid, Map<Integer, List<Integer>> G) {
		visited.put(vid, true);
		for (int nextVid : G.get(vid)) {
			if (!visited.getOrDefault(nextVid, false)) {
				dfs(nextVid, G);
			}
		}

	}
	static boolean check() { // dfs가 끝난 시작점이 정답인가 check
		for(int vid=1;vid<=N;vid++) {
			if(!visited.getOrDefault(vid,false)) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			Map<Integer, List<Integer>> adsentG, desentG; // 작은순, 큰순 그래프 선언
			adsentG = new HashMap<>();
			desentG = new HashMap<>();
			for (int i = 1; i <= N; i++) {
				adsentG.put(i, new ArrayList<>());
				desentG.put(i, new ArrayList<>());
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adsentG.get(a).add(b);
				desentG.get(b).add(a);
			}
			int ans=0;
			for(int i=1;i<=N;i++) {
				visited = new HashMap<>(); 
				dfs(i,adsentG);
				dfs(i,desentG);
				if(check()) ans+=1;
			}
			String format = String.format("#%d %d\n",tc,ans);
			sb.append(format);
		}
		System.out.println(sb);
	}
}
