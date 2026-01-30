package baekjoon.day0130.problem1189;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int R, C, K, cnt = 0;
	static char[][] matrix;
	static boolean[][] visited;

	static void dfs(int y, int x, int depth) {
		if (y == 0 && x == C - 1) {
			cnt++;
			return;
		}
		if (visited[y][x])
			return;
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[ny][nx] && matrix[ny][nx] == '.') {
				visited[ny][nx] = true;
				dfs(ny, nx, depth + 1);
				visited[ny][nx] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		matrix = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < C; j++) {
				matrix[i][j] = line.charAt(j);
			}
		}
		dfs(R-1,0, 0);

		sb.append(cnt);
		System.out.println(cnt);
	}

}
