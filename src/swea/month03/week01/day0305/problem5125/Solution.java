package swea.month03.week01.day0305.problem5125;

import java.io.*;
import java.util.*;
public class Solution {
	static int N,L;
	static int[][] info;
	static int maxScore;
	static void subs(int index,int sumScore,int sumCalory) {
		if(index==N) {
			if(sumCalory<=L)
				maxScore = Math.max(maxScore, sumScore);
			return;
		}
		subs(index+1,sumScore+info[index][0],sumCalory+info[index][1]);
		subs(index+1,sumScore,sumCalory);
	}
	public static void main(String[] args) throws  IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			maxScore=0;
			info = new int[N][2];
			for(int i=0;i<N;i++) {
				 st = new StringTokenizer(br.readLine());
				 info[i][0] = Integer.parseInt(st.nextToken());
				 info[i][1] = Integer.parseInt(st.nextToken());
			}
			subs(0,0,0);
			sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
		}
		System.out.println(sb);
	}
}
