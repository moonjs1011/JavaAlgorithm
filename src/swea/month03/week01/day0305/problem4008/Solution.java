package swea.month03.week01.day0305.problem4008;

import java.io.*;
import java.util.*;

/*
 * 
 */
public class Solution {
	static int[] op;// 연산자의 갯수를 저장 + - * /
	static int[] nums;
	static int N, maxSum, minSum;

	static void subs(int index, int sum) {
		if (index == N) {
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			return;
		}
		if (op[0] > 0) {
			op[0] -= 1;
			subs(index + 1, sum + nums[index]);
			op[0] += 1;
		}
		if (op[1] > 0) {
			op[1] -= 1;
			subs(index + 1, sum - nums[index]);
			op[1] += 1;
		}
		if (op[2] > 0) {
			op[2] -= 1;
			subs(index + 1, sum * nums[index]);
			op[2] += 1;
		}
		if (op[3] > 0) {
			op[3] -= 1;
			subs(index + 1, sum / nums[index]);
			op[3] += 1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			nums = new int[N];
			op = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			maxSum = Integer.MIN_VALUE;
			minSum = Integer.MAX_VALUE;

			subs(1, nums[0]);
			System.out.println("#"+tc+" "+ (maxSum - minSum ));
		}
	}
}
