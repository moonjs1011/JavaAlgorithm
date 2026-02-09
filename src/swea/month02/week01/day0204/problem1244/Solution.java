package swea.month02.week01.day0204.problem1244;

import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr;
	static int maxDepth;
	static int maxSum = 0;
	static boolean[][] visited;

	static int toDecimal() {
		int di = 1;
		int sum = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			sum += arr[i] * di;
			di *= 10;
		}
		return sum;
	}

	static void swap(int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	static void dfs(int depth) {
		int sum = toDecimal();
		if (visited[depth][sum])
			return;
		visited[depth][sum] = true;

		if (depth == maxDepth) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j);
				dfs(depth + 1);
				swap(i, j);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			String seq = st.nextToken();
			maxDepth = Integer.parseInt(st.nextToken());

			arr = new int[seq.length()];
			visited = new boolean[maxDepth+1][9999999 + 1];
			maxSum = 0;
			for (int i = 0; i < seq.length(); i++) {
				arr[i] = seq.charAt(i) - '0';
			}
			dfs(0);
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb);
	}
}
