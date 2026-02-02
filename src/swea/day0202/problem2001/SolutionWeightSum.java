package swea.day0202.problem2001;

import java.io.*;
import java.util.*;

public class SolutionWeightSum {
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
			matrix = new int[N+1][N+1];
			
			for(int y=1;y<=N;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=1;x<=N;x++) {
					matrix[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					matrix[i][j] += matrix[i-1][j] + matrix[i][j-1]-matrix[i-1][j-1];
				}
			}
			int maxSum = Integer.MIN_VALUE;
			for(int y=M;y<=N;y++) {
				for(int x=M;x<=N;x++) {
					maxSum = Math.max(maxSum, matrix[y][x]-matrix[y-M][x]-matrix[y][x-M]+matrix[y-M][x-M]);
				}
			}
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb);
	}
}
