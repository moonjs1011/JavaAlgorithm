package swea.month03.week01.day0305.problem7733;

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] matrix;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static boolean[][] visited, cheese;
	static int N;

	static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { y, x });
		visited[y][x] = true;
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for (int dir = 0; dir < 4; dir++) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && matrix[ny][nx] == matrix[cy][cx]) {
					visited[ny][nx] = true;
					q.offer(new int[] { ny, nx });
				}
			}
		}
	}

	static void dfs(int y, int x) {
		if (cheese[y][x])
			return;
		cheese[y][x] = true;
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny >= 0 && ny < N && nx >= 0 && nx < N)
				dfs(ny, nx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxCnt = 1;
			for (int day = 1; day <= 100; day++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && matrix[i][j] == day) {
							bfs(i, j);
						}
					}
				}
//				System.out.println("day :"+day);
//				for(boolean[]e : visited) {
//					System.out.println(Arrays.toString(e));
//				}
				cheese = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						cheese[i][j] = visited[i][j];
					}
				}
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!cheese[i][j]) {
							dfs(i, j);
							cnt += 1;
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}
}
