package baekjoon.month03.week03.day0320.problem2293;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins= new int[N]; 
		int[] dp = new int[K+1];
		
		for(int i=0;i<N;i++) {
			coins[i] =Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		for(int i=0;i<N;i++) {//동전 배열의 인덱스
			for(int j=coins[i];j<=K;j++) {// 금액
				dp[j] += dp[j-coins[i]]; 
			}
		}
		System.out.println(dp[K]);
		
	}
}	
