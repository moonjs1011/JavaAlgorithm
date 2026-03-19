package baekjoon.month03.week03.day0319.problem1788;

import java.io.*;
import java.util.*;

/*
 * F(n) = F(n-1) + F(n-2);
 * F(n-2) = F(n) - F(n-1)
 * F(n) = F(n+2) - F(N+1)
 */
public class Main {
	static long N;
	static long MOD_NUM = 1000000000;

	static long postiveFibo(long N) {
		long nn = 0;
		long c = 0;
		long n = 1;
		for (long i = 2; i <= N; i++) {
			nn = (c + n) % MOD_NUM;
			c = n;
			n = nn;
		}
		return n;
	}

	static long negativeFibo(long N) {
		long pp = 1;
		long p = 1;
		long c = 0;
		for (long i = 0; i >= N; i--) {
			c = (pp - p) % MOD_NUM;
			pp = p;
			p = c;
		}
		return c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		//0처리
		if(N==0) {
			System.out.println(0+"\n"+0);
			return;		
		}
		
		long res;
		if (N > 0)
			res = postiveFibo(N);
		else
			res = negativeFibo(N);

		if (res > 0)
			System.out.println(1);
		else
			System.out.println(-1);
		System.out.println(Math.abs(res));

	}
}
