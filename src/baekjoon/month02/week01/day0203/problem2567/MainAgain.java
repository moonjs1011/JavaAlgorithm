package baekjoon.month02.week01.day0203.problem2567;

import java.io.*;
import java.util.*;

public class MainAgain {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int MAXSIZE = 101;
	static int[][] matrix = new int[MAXSIZE][MAXSIZE];
	static boolean[][] visited = new boolean[MAXSIZE][MAXSIZE];
	static int ans = 0;

	static void dfs(int y, int x) {
		visited[y][x] = true;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<0 || ny>=MAXSIZE || nx<0 || nx>=MAXSIZE || matrix[ny][nx]==0)
				ans++;
			else if(!visited[ny][nx] && matrix[ny][nx]==1)
				dfs(ny,nx);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					matrix[i][j] = 1; // masking
				}
			}
		
		}
		for(int i=0;i<MAXSIZE;i++) {
			for(int j=0;j<MAXSIZE;j++) {
				if(matrix[i][j]==1 &&!visited[i][j])
					dfs(i,j);
			}
		}
		System.out.println(ans);
	}
}
