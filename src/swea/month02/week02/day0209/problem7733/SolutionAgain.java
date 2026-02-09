package swea.month02.week02.day0209.problem7733;

import java.io.*;
import java.util.*;

public class SolutionAgain {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int N;
	static int[][] matrix;
	static boolean[][] visited;

	static void bfs(int y, int x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.push(new int[] { y, x });
		visited[y][x] = true;
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && matrix[ny][nx] != 0) {
					visited[ny][nx] = true;
					q.offer(new int[] { ny, nx });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxCnt = 1;
			for (int day = 1; day <= 100; day++) {
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (matrix[y][x] == day)
							matrix[y][x] = 0;
					}
				}
				int cnt = 0;
				visited = new boolean[N][N];
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (!visited[y][x] && matrix[y][x] != 0) {
							bfs(y, x);
							cnt++;
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			String format = String.format("#%d %d\n", tc, maxCnt);
			sb.append(format);
		}
		System.out.println(sb);

	}

}
