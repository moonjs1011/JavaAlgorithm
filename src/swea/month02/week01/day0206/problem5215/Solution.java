package swea.month02.week01.day0206.problem5215;

import java.io.*;
import java.util.*;

public class Solution {
	static int subseq(int[][]info,int L,int index,int score,int calory) {
		if(calory>L)
			return 0;
		if(index>=info.length) return score;
		int pick = subseq(info,L, index+1,score+info[index][0],calory+info[index][1]);
		int skip = subseq(info,L, index+1,score,calory);
		return Math.max(pick, skip);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] info = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}
			//String str = String.format("#%d %d\n" ,tc,subseq(info,L,0,0,0));
			sb.append("#").append(tc).append(" ").append(subseq(info,L,0,0,0)).append("\n");
		}
		System.out.println(sb);
	}

}
