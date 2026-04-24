package swea.month04.week01.day0408.problem3282;

import java.io.*;
import java.util.*;

/*
 * State 정의 : dp[i][w] = i번째 물건"까지" 담았을 때, 무게 한도가 "w"인 가방의 최적해(최대 가치)
 * 점화식 : dp[i][w] = {
 * 						dp[i-1][w] if, w_i > w
 * 						max(v_i + dp[i-1][w-w_i], dp[i-1][w]) if, w_i<=w
 * 					  }
 */
public class Again {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] weight = new int[N + 1];
			int[] value = new int[N + 1];
			int[][] dp = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= K; w++) {
					if(weight[i]>w) dp[i][w] = dp[i-1][w];
					else dp[i][w] = Math.max(value[i] + dp[i-1][w-weight[i]],dp[i-1][w]);
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[N][K]).append("\n");
		}
		System.out.println(sb);
	}
}
