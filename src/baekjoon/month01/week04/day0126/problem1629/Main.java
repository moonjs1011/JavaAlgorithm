package baekjoon.month01.week04.day0126.problem1629;

import java.io.*;
import java.util.*;

/*
 2^3 
 2^1
 
 */
public class Main {
	static long c;

	static long pow(long a, long exp) {
		if (exp == 1)
			return a % c;

		long temp = pow(a, exp / 2);
		if (exp % 2 == 1)
			return ((temp % c) * (temp % c))%c * (a % c) % c;
		return ((temp % c) * (temp % c)) % c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		long res = pow(a, b);
		StringBuilder sb = new StringBuilder();
		sb.append(res);
		System.out.println(sb);
	}

}
