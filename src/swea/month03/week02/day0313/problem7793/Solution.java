package swea.month03.week02.day0313.problem7793;

/*
 * src S
 * dst D
 * 돌 X
 * 악마 *
 * S를 한칸 움직임
 */
import java.io.*;
import java.util.*;

class Point {
	char ch;
	boolean isPolluate;

	public Point(char ch) {
		this.ch = ch;
		this.isPolluate = false;
	}
}

public class Solution {
	static Point[][] grid;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static int N, M;
	static int startY, startX, dstY, dstX, demonY, demonX;

	static boolean rangeCheck(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static int[][] bfs() {
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[startY][startX] = 0;
		Queue<int[]> q1 = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();
		q1.offer(new int[] { startY, startX });// {y,x, option(공주인지 악마인지)
		q2.offer(new int[] { demonY, demonX });
		while (!q1.isEmpty()) {
			int[] info = q1.poll();
			int cy = info[0];
			int cx = info[1];
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (rangeCheck(ny, nx) && grid[ny][nx].ch == '.' && !grid[ny][nx].isPolluate
						&& dist[ny][nx] > dist[cy][cx] + 1) {
					// 공주 이동	
					grid[cy][cx].ch = '.';
					grid[ny][nx].ch = 'S';
					// 거리 갱신
					dist[ny][nx] = dist[cy][cx] + 1;
					// 큐 삽입
					q1.offer(new int[] { ny, nx });
				}
			}
			info = q2.poll();
			cy = info[0];
			cx = info[1];
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (rangeCheck(ny, nx) && grid[ny][nx].ch == '.') {
					grid[ny][nx].ch = '*';
					grid[ny][nx].isPolluate = true;
					q2.offer(new int[] { ny, nx });
				}
			}

		}

		return dist;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grid = new Point[N][M];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					grid[i][j] = new Point(line.charAt(j));
					if (grid[i][j].ch == 'S') {
						startY = i;
						startX = j;
					} else if (grid[i][j].ch == 'D') {
						dstY = i;
						dstX = j;
					} else if (grid[i][j].ch == '*') {
						demonY = i;
						demonX = j;
					}
				}
			}
			for (Point[] P : grid) {
				for (Point p : P) {
					System.out.print(p.ch);
				}
				System.out.println();
			}
			int dist[][] = bfs();
			System.out.println(dist[dstY][dstX]);
		}

	}
}
