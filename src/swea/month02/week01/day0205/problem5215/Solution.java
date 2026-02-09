package swea.month02.week01.day0205.problem5215;

import java.io.*;
import java.util.*;

public class Solution {
	static int N,L;
	static int subComb(int[][] arr, int index,int score,int calory) {
		if(calory>L) return 0;
		if(index == N)
			return score;
		int pick = subComb(arr,index+1,score+arr[index][0],calory+arr[index][1]);
		int skip = subComb(arr,index+1,score,calory);
		
		return Math.max(pick,skip);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][2]; // score, calory;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(tc).append(" ").append(subComb(arr,0,0,0)).append("\n");
			Arrays.sort(arr,Collections.reverseOrder());
		}
		System.out.println(sb);
	}

}
