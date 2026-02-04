package baekjoon.day0204.problem15649;

import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] target;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static void perm(int depth, int maxDepth) {
		if (depth == maxDepth) {
			for (int ele : target) {
				sb.append(ele).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				target[depth] = arr[i];
				perm(depth + 1, maxDepth);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		target = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		perm(0, M);

		System.out.println(sb);

	}

}
