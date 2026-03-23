package baekjoon.month03.week04.day0323.problem12865;

import java.io.*;
import java.util.*;

class item {
	int w, v;

	public item(int w, int v) {
		this.w = w;
		this.v = v;
	}
}

public class Main {
	static int N, K;
	static item[] items;
	static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		items = new item[N+1];
		dp = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			st =new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			items[i] = new item(W,V);
		}
		
		for(int i=1;i<=N;i++) {
			int w = items[i].w;
			int v = items[i].v;
			for(int j=1;j<=K;j++) {
				if(j-w>=0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
				else dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[N][K]);
	}
}
