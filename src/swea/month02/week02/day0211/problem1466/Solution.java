package swea.month02.week02.day0211.problem1466;

import java.io.*;
import java.util.*;

public class Solution {
	static int N,B;
	static int[] height;
	static int ans;
	static void subs(int index,int sum) {
		if(index==N) {
			if(sum>=B)
				ans = Math.min(ans, sum-B);
			return;
		}
		subs(index+1,sum);
		subs(index+1,sum+height[index]);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			subs(0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
