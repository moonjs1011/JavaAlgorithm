package swea.day0202.problem2001;

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			
			for(int y=0;y<N;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0;x<N;x++) {
					matrix[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			int maxSum = Integer.MIN_VALUE;
			for(int y=0;y<=N-M;y++) {
				for(int x=0;x<=N-M;x++) {
					int sum =0;
					for(int dy=0;dy<M;dy++) {
						for(int dx=0;dx<M;dx++) {
							sum+=matrix[y+dy][x+dx];
						}
					}
					maxSum = Math.max(maxSum, sum);
				}
			}
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb);
	}
}
