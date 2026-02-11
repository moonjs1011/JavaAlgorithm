package swea.month02.week02.day0211.problem14510;

import java.io.*;
import java.util.*;

/*
 * [ 10 5 3 4 12]
 * [ 2 7 9 8 0 ]
 * 
 * 
 * 2씩 자라는날 물을 줘야하는 횟수 1 + 3 + 4 + 4 -> 12
 * 1씩 자라는날 물을  줘야하는 횟수 2 
 *  day : 1 2 3 4 5 6 7 8 9 10 11 12  13 14 15 16 17 18 19 20 21 22 23 24[ x : 2씩 자람, o : 1씩 자람]
 *  	  o	x o x   x   x   x     x       x    x     x     x     x     x
 *  아무것도 안하는 날이 많음[홀수날을 너무 많이 건너뜀]
 *  2을 1 + 1로 분배하자 최대한
 *  2씩 자라는 날 물을 줘야하는 횟수 : cnt2
 *  1씩 자라는 날 물을 줘야하는 횟수 : cnt1
 *  cnt2 = 12, cnt1 =2
 *  cnt2 = 11, cnt1 =4
 *  cnt =  10, cnt1 =6
 *  cnt2 =  9, cnt1 =8 
 *  day : 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24[ x : 2씩 자람, o : 1씩 자람]
 *  	  o	x o x o x o x o  x o  x  o  x  o  x  o  x  
 *  2번 주는날이 더 많아야 이득
 *  최소 18일만에.
 */
public class Solution {
	static int[] tree;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(tree);
			int maxHeight = tree[N - 1];
			int ans = Integer.MAX_VALUE;

			int cnt1 = 0;
			int cnt2 = 0;
			for (int ele : tree) {
				cnt1 += (maxHeight - ele) % 2;
				cnt2 += (maxHeight - ele) / 2;
			}
			while (cnt2 > cnt1 + 1) {
				cnt2 -= 1;
				cnt1 += 2;
			}
			int days = 0;
			if (cnt1 > cnt2)
				days = cnt1 * 2 - 1;
			else
				days = cnt2 * 2;
			sb.append("#").append(tc).append(" ").append(days).append("\n");
		}
		System.out.println(sb);
	}
}
