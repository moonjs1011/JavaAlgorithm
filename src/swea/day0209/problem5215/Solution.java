package swea.day0209.problem5215;

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] info;
	static int N,L,maxScore;
	static void subs(int depth,int sumScore,int sumCalories) {
		if(sumCalories>L)
			return;
		if(depth == N) {
			maxScore = Math.max(maxScore, sumScore);
			return;
		}
		subs(depth+1,sumScore+info[depth][0], sumCalories+info[depth][1]);
		subs(depth+1,sumScore, sumCalories);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
				
			info = new int[N][2];
			maxScore=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}
			subs(0,0,0);
			String format = String.format("#%d %d\n",tc,maxScore);
			sb.append(format);
		}
		System.out.println(sb);
	}
}
