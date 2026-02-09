package baekjoon.month02.week01.day0203.problem2470;
import java.io.*;

import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int s=0;
		int e=N-1;
		int minSum = Integer.MAX_VALUE;
		int[]res =new int[2];
		while(s!=e) {
			int sum = arr[s] + arr[e];
		
			if(Math.abs(sum)<minSum) {
				minSum = Math.abs(sum);
				res[0] = arr[s];
				res[1] = arr[e];
			}
			
			if(sum>0)
				e--;
			else s++;
		}
		System.out.println(res[0]+" "+res[1]);
	}

}
