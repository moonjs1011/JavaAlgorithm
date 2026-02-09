package baekjoon.month01.week04.day0126.problem17623;
import java.util.*;
import java.io.*;
public class Main {
	/*
	 * F(N) = F(N-1) 
	 * DP
	 * for i to [0..N]:
	 * 		dp[i] = dp[i-1]+1; 
	 * 		if(
	 */
	public static void main(String[] args) throws Throwable{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int [] dp = new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j*j<=i;j++) {
				dp[i] = Math.min(dp[i],dp[i-j*j]+1);
			}
		}
		sb.append(dp[n]);
		System.out.println(sb);
	}

}