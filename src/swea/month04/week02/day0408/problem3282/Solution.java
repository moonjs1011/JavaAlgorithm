package swea.month04.week02.day0408.problem3282;
import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] v = new int[N+1];
			int[] c = new int[N+1];
			int[][] dp = new int[N+1][K+1];
			for(int i=1;i<=N;i++) {
				st =new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<=N;i++) {
				for(int w=1;w<=K;w++) {
					if(v[i]>w) dp[i][w] = dp[i-1][w];
					else dp[i][w] = Math.max(c[i] + dp[i-1][w-v[i]], dp[i-1][w]); 
				}
			}
			System.out.println("#"+tc+" "+dp[N][K]);
		}
	}
}
