package swea.day0204.problem1210;

import java.io.*;
import java.util.*;

public class Solution {
	static final int SIZE = 100;
	static int[] dy = {0, 0 ,1};
	static int[] dx = { -1, 1,0 };
	static int[][] matrix;
	static boolean[][] visited;
	static int ans = -1;

	static void dfs(int sy, int sx, int y, int x) {
		if(ans!=-1) return;
		
		if (matrix[y][x] == 2) {
			ans = sx;
			return;
		}
		if(y==SIZE-1) return;
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE && !visited[ny][nx] && matrix[ny][nx] !=0) {
					visited[ny][nx]=true;
					dfs(sy,sx,ny,nx);
					visited[ny][nx]=false;
					break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());

			matrix = new int[SIZE][SIZE];
			visited = new boolean[SIZE][SIZE];
			ans =-1;
			for (int y = 0; y < SIZE; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < SIZE; x++) {
					matrix[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			for (int x = 0; x < SIZE; x++) {
				if (matrix[0][x] == 1)
					dfs(0, x, 0, x);
			}
			System.out.println();
			sb.append("#").append(T).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
