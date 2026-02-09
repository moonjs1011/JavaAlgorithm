package swea.month02.week02.day0209.problem4008;

import java.io.*;
import java.util.*;

public class Solution {
	static Map<Character, Integer> opMap;
	static int[] nums;
	static int maxSum, minSum;

	static void dfs(int depth, int sum) {
		if (depth == nums.length) {
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			return;
		}
		if (opMap.get('+') != 0) {
			opMap.put('+', opMap.get('+') - 1);
			dfs(depth + 1, sum + nums[depth]);
			opMap.put('+', opMap.get('+') + 1);
		}
		if (opMap.get('-') != 0) {
			opMap.put('-', opMap.get('-') - 1);
			dfs(depth + 1, sum - nums[depth]);
			opMap.put('-', opMap.get('-') + 1);
		}
		if (opMap.get('*') != 0) {
			opMap.put('*', opMap.get('*') - 1);
			dfs(depth + 1, sum * nums[depth]);
			opMap.put('*', opMap.get('*') + 1);
		}
		if (opMap.get('/') != 0) {
			opMap.put('/', opMap.get('/') - 1);
			dfs(depth + 1, sum / nums[depth]);
			opMap.put('/', opMap.get('/') + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			// static 변수들 초기화
			opMap = new HashMap<>();
			nums = new int[N];
			maxSum = Integer.MIN_VALUE;
			minSum = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			// 연산자가 몇번 사용될 수 있는지 기록
			int plus = Integer.parseInt(st.nextToken());
			opMap.put('+', plus);
			int minus = Integer.parseInt(st.nextToken());
			opMap.put('-', minus);
			int mul = Integer.parseInt(st.nextToken());
			opMap.put('*', mul);
			int div = Integer.parseInt(st.nextToken());
			opMap.put('/', div);

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			dfs(1, nums[0]);
			sb.append("#").append(tc).append(" ").append(maxSum - minSum).append("\n");
		}
		System.out.println(sb);
	}
}
