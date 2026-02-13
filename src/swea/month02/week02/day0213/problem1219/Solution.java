package swea.month02.week02.day0213.problem1219;

import java.io.*;
import java.util.*;

/*
 * 단방향 graph A = 0 , B =99
 */
public class Solution {
	static Map<Integer, List<Integer>> adjList;
	static Map<Integer, Boolean> visited;

	static boolean bfs(int vid) {
		Queue<Integer> q = new ArrayDeque<>();
		visited.put(vid, true);
		q.offer(vid);
		while (!q.isEmpty()) {
			int curVid = q.poll();
			if (curVid == 99) {
				return true;
			}
			for (int nextVid : adjList.get(curVid)) {
				if (!visited.getOrDefault(nextVid, false)) {
					visited.put(nextVid, true);
					q.offer(nextVid);
				}
			}

		}
		return false;
	}

	static void init() {
		adjList = new HashMap<>();
		visited = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			adjList.put(i, new ArrayList<>());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			init();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int _ = Integer.parseInt(st.nextToken()); // dummy input
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int src = Integer.parseInt(st.nextToken());
				int dst = Integer.parseInt(st.nextToken());
				adjList.get(src).add(dst);
			}
			boolean result = bfs(0);
			String format = String.format("#%d %d\n", tc, (result==true)?1:0);
			sb.append(format);
		}
		System.out.println(sb);

	}
}
