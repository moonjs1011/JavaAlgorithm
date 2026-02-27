package baekjoon.month02.week04.day0227.problem1504;

import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, List<int[]>> adjList = new HashMap<>();
	static int N, E;

	static Long[] dijkstra(int vid) {
		Long[] dict = new Long[N + 1];
		Arrays.fill(dict, Long.MAX_VALUE);
		dict[vid] = 0L;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(vid);
		while (!q.isEmpty()) {
			int cv = q.poll();
			for (int[] edge : adjList.get(cv)) {
				int nv = edge[0];
				int nw = edge[1];
				if (dict[nv] > dict[cv] + nw) {
					dict[nv] = dict[cv] + nw;
					q.offer(nv);
				}
			}
		}
		return dict;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// Map 초기화
		for (int vid = 1; vid <= N; vid++) {
			adjList.put(vid, new ArrayList<>());
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 간선 삽입
			adjList.get(a).add(new int[] { b, c });
			adjList.get(b).add(new int[] { a, c });
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		Long[] dict1 = dijkstra(1);
		Long[] dictV1 = dijkstra(v1);
		Long[] dictV2 = dijkstra(v2);
//		System.out.println(dictV1[v2]);
//		System.out.println(dictV2[v1]);

		Long dict1V1V2N = dict1[v1] + dictV1[v2] + dictV2[N];
		Long dict1V2V1N = dict1[v2] + dictV2[v1] + dictV1[N];

		if(dict1V1V2N<1) System.out.println(dict1V2V1N);
		else if(dict1V2V1N<1) System.out.println(dict1V1V2N);
		else System.out.println(Math.min(dict1V1V2N, dict1V2V1N));

		// 2->

	}

}
