package swea.day0206.problem9229;
/*
 * 2^n ->  시간초과
 */

import java.io.*;
import java.util.*;

public class SolutionRecur {
	static int N;
	static long M, maxSum = -1;
	static long[] arr;
	static boolean[] check;

	static void subs(int index,int cnt,long sum) {
		if(cnt==2 && sum<=M) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		if(index>=N) return;
		subs(index+1,cnt+1,sum+arr[index]);
		subs(index+1,cnt,sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Long.parseLong(st.nextToken());

			arr = new long[N];
			check = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			maxSum = -1;
			subs(0,0,0);
			String str = String.format("#%d %d\n", tc, maxSum);
			sb.append(str);
		}
		System.out.println(sb);
	}

}
