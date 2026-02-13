package swea.month02.week02.day0213.problem7206;

import java.io.*;
import java.util.*;

public class SolutionAI {
	// 중복 계산 방지 (메모이제이션)
	static Map<Integer, Integer> memo = new HashMap<>();
         
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String num = br.readLine();
			memo.clear();

			// solve 함수가 결과를 리턴하도록 변경
			System.out.println("#" + tc + " " + solve(num));
		}
	}

	// void가 아니라 int(최대 턴 수)를 반환
	static int solve(String num) {
		int n = Integer.parseInt(num);
		if (n < 10)
			return 0; // 한 자리 수면 0턴
		if (memo.containsKey(n))
			return memo.get(n); // 이미 푼 문제면 정답 리턴

		int maxDepth = 0;

		// i는 '몇 개의 틈'을 선택할지 결정 (1개 ~ 길이-1개)
		// 예: "123" (길이3) -> 틈은 2개(1_2_3). 1개를 고르거나 2개를 고르거나.
		for (int i = 1; i < num.length(); i++) {
			boolean[] visited = new boolean[num.length() - 1]; // 틈의 개수만큼 생성
			// perm에게 maxDepth를 갱신해달라고 요청
			maxDepth = Math.max(maxDepth, perm(0, 0, i, num, visited));
		}

		memo.put(n, maxDepth);
		return maxDepth;
	}

	// perm 함수도 int(이 조합에서의 최대 턴 수)를 반환
	static int perm(int start, int depth, int maxDepth, String num, boolean[] visited) {
		// 원하는 개수만큼 자를 위치를 골랐다면 (기저 조건)
		if (depth == maxDepth) {
			int res = calNum(num, visited);

			// res(곱한 결과)로 solve를 호출하고, 그 결과에 +1(이번 턴)을 더함
			return solve(String.valueOf(res)) + 1;
		}

		int localMax = 0;
		for (int i = start; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				// 재귀 호출 결과 중 가장 큰 값을 선택
				localMax = Math.max(localMax, perm(i + 1, depth + 1, maxDepth, num, visited));
				visited[i] = false;
			}
		}
		return localMax;
	}

	// 숫자를 쪼개서 곱하는 함수 (단순 계산만 수행)
	static int calNum(String num, boolean[] visited) {
		int res = 1;
		int s = 0;
		// visited 길이(=틈의 개수)만큼 반복
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) { // i번째 틈에서 자른다면
				int e = i + 1;
				res *= Integer.parseInt(num.substring(s, e));
				s = e;
			}
		}
		// 마지막 조각 곱하기
		res *= Integer.parseInt(num.substring(s));
		return res;
	}
}