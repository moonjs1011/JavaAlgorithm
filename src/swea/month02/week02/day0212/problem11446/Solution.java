package swea.month02.week02.day0212.problem11446;
import java.io.*;
import java.util.*;
/*
 * N개의 종류의 사탕
 * 가방 안에는 정확히 M개의 사탕이 배분되어야함
 * 사탕 종류의 구성이 같아야한다.
 */
public class Solution {
	static long[] candy;
	static long cal(long K) {
		long sum=0;
		for(int i=0;i<candy.length;i++) {
			sum+=candy[i]/K;
		}
		return sum;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			candy = new long[N];
			
			st =new StringTokenizer(br.readLine());
			long maxVal=0;
			for(int i=0;i<N;i++) {
				candy[i] = Long.parseLong(st.nextToken());
				maxVal = Math.max(maxVal, candy[i]);
			}
			long s =1;
			long l = maxVal;
			long ans=0;
			while(s<=l) {
				long K = (s+l)/2;
				if(K==0) {
					l=1;
					continue;
				}
				long sum = cal(K);
				if(sum<M) {
					l = K-1;
				}
				else {
					s = K+1;
					ans = K;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
}
