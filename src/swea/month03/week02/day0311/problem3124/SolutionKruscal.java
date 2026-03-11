package swea.month03.week02.day0311.problem3124;

import java.io.*;
import java.util.*;

public class SolutionKruscal {
	static int[] parent;

	static int find(int vid) {
		if (parent[vid] == vid)
			return vid;
		return parent[vid] = find(parent[vid]);
	}

	static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (p1 == p2)
			return;
		parent[p2] = p1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				pq.offer(new int[] { v1, v2, weight });
			}

			long mst = 0;
			int cnt = 0;
			while (!pq.isEmpty()) {
				int[] info = pq.poll();
				int v1 = info[0];
				int v2 = info[1];
				int weight = info[2];
				if ( find(v1)!=find(v2)) {
					union(v1, v2);
					mst += weight;
					if (cnt++ == N-1)
						break;
				}
			}
			System.out.println("#"+tc+" "+mst);
		}
	}
}
