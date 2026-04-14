package baekjoon.month04.week02.day0407.problem11401;

import java.io.*;
import java.util.*;
/*
 * factorial 구하기
 * k!^(p-2)구하기 -> 분할 정복
 */
public class Main {
	static long mod =1000000007;
	static long pow(long base,long exp) {
		if(exp==0) return 1;
		
		long temp = pow(base,exp/2);
		if(exp%2==0) {
			return (temp * temp) % mod;
		}
		else {
			return ((temp*temp) % mod * base) % mod;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] factorial = new long[N+1];
		factorial[0]=1;

		for(int i=1;i<=N;i++) {
			factorial[i] = (factorial[i-1] * i) % mod;
		}
		System.out.println((factorial[N]*pow((factorial[K]*factorial[N-K]%mod),mod-2))%mod);
	}
}
