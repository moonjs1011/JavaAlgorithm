package swea.day0206.problem9229;

import java.io.*;
import java.util.*;
public class SolutionIter {
	static int N; 
	static long M;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T= Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Long.parseLong(st.nextToken());
			
			arr = new long[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			long maxSum=-1;
			for(int i=0;i<N;i++) {
				long sum =arr[i];
				for(int j=i+1;j<N;j++) {
					sum+=arr[j];
					if(sum<=M) maxSum = Math.max(maxSum,sum);
					sum-=arr[j];
				}
			}
			String str = String.format("#%d %d\n",tc,maxSum);
			sb.append(str);
		}
		System.out.println(sb);
	}

}
