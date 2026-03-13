package swea.month03.week02.day0312.problem5656;

import java.io.*;
import java.util.*;

public class SolutionAgain {
	static int[][] grid;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int N, H, W, minCnt;

	static int[][] copy(int[][] arr) {
		int[][] temp = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	static void gravity() {
		for (int x = 0; x < W; x++) {
			int targetY = H - 1;
			for (int y = H - 1; y >= 0; y--) {
				if (grid[y][x] != 0) {
					int temp = grid[y][x];
					grid[y][x] = 0;
					grid[targetY][x] = temp;
					targetY--;
				}
			}
		}
	}

	static void explode(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { y, x ,grid[y][x]-1});
		grid[y][x] = 0;
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			int range = info[2];

			for (int d = 0; d < 4; d++) {
				int ny = cy;
				int nx = cx;
				for (int i = 0; i < range; i++) {
					ny += dy[d];
					nx += dx[d];
					if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
						if (grid[ny][nx] != 0) {
							q.offer(new int[] { ny, nx,grid[ny][nx]-1 });
							grid[ny][nx] = 0;
						}
					}
				}
			}
		}
	}

	static void findFirst(int x) {
		for (int y = 0; y < H; y++) {
			if (grid[y][x] != 0) {
				explode(y, x);
				gravity();
				break;
			}
		}
	}

	static void nHr(int[][] target, int[][] info, int depth) {
		if (depth == N) {
			int[][] temp = copy(grid);
			for (int[] ele : target) {
				findFirst(ele[1]);
			}
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (grid[i][j] != 0)
						cnt += 1;
				}
			}
			minCnt = Math.min(minCnt, cnt);
			grid = temp;
			return;
		}
		for (int i = 0; i < W; i++) {
			target[depth] = info[i];
			nHr(target, info, depth + 1);
		}

	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("./src/swea/month03/week02/day0312/problem5656/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			grid = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] info = new int[W][2];
			int[][] target = new int[N][2];

			for (int i = 0; i < W; i++)
				info[i] = new int[] { 0, i };

			minCnt = Integer.MAX_VALUE;
			nHr(target, info, 0);
			sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
		}
		System.out.println(sb);

	}
}
