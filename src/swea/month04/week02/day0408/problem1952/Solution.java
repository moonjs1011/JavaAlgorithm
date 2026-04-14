package swea.month04.week02.day0408.problem1952;

import java.io.*;
import java.util.*;

public class Solution {
	static int ticketNum = 4;
	static int monthNum = 12;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] ticket = new int[ticketNum];
			int[] day = new int[monthNum + 1];// 1월부터 시작하게 만들기 위함
			int[] dp = new int[monthNum + 1];// 1월부터 시작하게 만들기 위함

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < ticketNum; i++) {
				ticket[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= monthNum; i++) {
				day[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= monthNum; i++) {
				int c1 = dp[i - 1] + (ticket[0] * day[i]);
				int c2 = dp[i - 1] + ticket[1];
				int c3 = Integer.MAX_VALUE;
				if (i - 3 >= 0)
					c3 = dp[i - 3] + ticket[2];
				int c4 = Integer.MAX_VALUE;
				if (i - 12 >= 0)
					c4 = ticket[3];
				dp[i] = Math.min(c1, Math.min(c2, Math.min(c3, c4)));
			}
			sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
		}
		System.out.println(sb);
	}
}
