package baekjoon.month02.week01.day0202.problem2559;

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		StringBuilder sb =new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int []arr =new int[N];
		st= new StringTokenizer(br.readLine());
		int maxSum = Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<K;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		maxSum = Math.max(maxSum, sum);
		for(int i=K;i<N;i++) {
			sum-=arr[i-K];
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
			maxSum = Math.max(maxSum,sum);
		}
		sb.append(maxSum);
		System.out.println(sb);
	}

}
