package baekjoon.month02.week04.day0225.problem1865;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			Map<Integer, List<int[]>> adjList = new HashMap<>();
			for (int i = 1; i <= N; i++)
				adjList.put(i, new ArrayList<>());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				adjList.get(S).add(new int[] { E, T });
				adjList.get(E).add(new int[] { S, T });
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				adjList.get(S).add(new int[] { E, -T });
			}
			int[] dict = new int[N + 1];
			boolean flag=false;
			for(int j=1;j<=N;j++) {
			for (int i = 1; i <= N; i++) {
				if (!adjList.get(i).isEmpty()) {
					for (int[] v : adjList.get(i)) {
						// 거리 비교
						if(dict[v[0]]>dict[i]+v[1]) {
							System.out.printf("Hit, step : %d | (from) vid : %d | "
									+ "(to) vid : %d | dict[from](dict[%d]) : %d | "
									+ "dict[to](dict[%d] : %d | time : %d\n ",j,i,v[0],i,dict[i],v[0],dict[v[0]],v[1]);
							dict[v[0]] = dict[i]+v[1];
							if(j==N) {
								flag = true;
								break;
							}
						}
					}
				}
			}
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");

		}
	}
}
