package swea.day0128.problem2805;

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] matrix;
	static int N;

	static int iterator() {
		int sum = 0;
		for (int y = 0; y < N; y++) {
			if (y < N / 2) { // 상반신
				for (int x = N / 2 - y; x <= N / 2 + y; x++) {
					sum += matrix[y][x];
				}
			} else if (y == N / 2) {
				for (int x = 0; x < N; x++) {
					sum += matrix[y][x];
				}
			} else if (y > N / 2) {
				for (int x = y - N / 2; x <= y + N / 2; x++) {
					sum += matrix[y][x];
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		// Input Phase
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			// -----------------Input Phase-------------//
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N 입력 받기
			matrix = new int[N][N]; // matrix 할당

			st = new StringTokenizer(br.readLine());
			String line = st.nextToken(); // 해당 문제는 공백 없이 입력을 받기 때문
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}
			// -----------Solution-------------//
			int result = iterator();
			sb.append("#").append(" ").append(tc).append("\n");
		}
		System.out.println(sb);
	}
}
