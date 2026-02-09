package swea.month02.week01.day0204.problem6808;

import java.util.*;
import java.io.*;

public class SolutionMine {
	static int[] A; // 규영이
	static int[] B; // 인영이
	static int winA;

	static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	static void swap(int idx1, int idx2) {
		int temp = B[idx1];
		B[idx1] = B[idx2];
		B[idx2] = temp;
	}

	static void perm(int depth) {
		if (depth == 9) {
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < 9; i++) {
				if (A[i] > B[i])
					sumA += A[i] + B[i];
				else
					sumB += A[i] + B[i];

			}
			if (sumA > sumB)
				winA += 1;
			return;
		}
		for (int i = depth; i < 9; i++) {
			swap(depth, i);
			perm(depth + 1);
			swap(depth, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int totalRound = factorial(9);
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			A = new int[9];
			B = new int[9];
			winA = 0;

			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			int size = 0;
			for (int i = 1; i < 19; i++) {
				boolean flag = true;
				for (int j = 0; j < 9; j++) {
					if (A[j] == i)
						flag = false; // A가 해당 카드를 가지고 있을떄
				}
				if (flag)
					B[size++] = i;
			}
			perm(0);
			sb.append("#").append(tc).append(" ").append(winA).append(" ").append(totalRound - winA).append("\n");
		}
		System.out.println(sb);
	}

}
