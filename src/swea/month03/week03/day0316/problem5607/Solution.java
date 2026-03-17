package swea.month03.week03.day0316.problem5607;

import java.io.*;
import java.util.*;

public class Solution {
	static long MOD = 1234567891L;
	static long[] fact;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 팩토리얼 최대값까지 미리 계산 (N의 범위가 1,000,000인 경우)
		fact = new long[1000001];
		fact[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			fact[i] = (fact[i - 1] * i) % MOD;
		}

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			// 조합 공식: N! / (R! * (N-R)!)
			// => N! * ((R! * (N-R)!)^(MOD-2)) % MOD
			long child = fact[N];
			long parent = (fact[R] * fact[N - R]) % MOD;

			long result = (child * power(parent, MOD - 2)) % MOD;

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	// 분할 정복을 이용한 거듭제곱 (O(log N))
	static long power(long base, long exp) {
		long res = 1;
		base %= MOD;
		while (exp > 0) {
			if (exp % 2 == 1)
				res = (res * base) % MOD;
			base = (base * base) % MOD;
			exp /= 2;
		}
		return res;
	}
}