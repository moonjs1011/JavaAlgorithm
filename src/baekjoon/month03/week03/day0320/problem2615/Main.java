package baekjoon.month03.week03.day0320.problem2615;

import java.io.*;
import java.util.*;

public class Main {
	static int MAX_SIZE = 19;
	static int winCondition = 5;
	static int[][] grid = new int[MAX_SIZE][MAX_SIZE];
	static boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static int[] td = { 0, 1, 4, 5 };

	/*
	 * 최상단 혹은 가장 왼쪽의 점을 찾으면 dir+4 방향으로 카운팅을 해야한다. (-1, 0 ) + 4 -> ( 1, 0 ) (-1,-1 )
	 * + 4 -> ( 1, 1 ) ( 0,-1 ) + 4 -> ( 0, 1 ) ( 1,-1 ) + 4 -> (-1, 1 )
	 */
	static int[] findStart(int player, int y, int x, int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= MAX_SIZE || nx < 0 || nx >= MAX_SIZE || grid[ny][nx] != player)
			return new int[] { y, x };
		return findStart(player, ny, nx, dir);
	}

	static int findCnt(int player, int y, int x, int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= MAX_SIZE || nx < 0 || nx >= MAX_SIZE || grid[ny][nx] != player)
			return 0;
		return 1 + findCnt(player, ny, nx, dir);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 0; i < MAX_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < MAX_SIZE; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < MAX_SIZE; i++) {
			for (int j = 0; j < MAX_SIZE; j++) {
				if (grid[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						int[] startP = findStart(grid[i][j], i, j, d);
						int startY = startP[0];
						int startX = startP[1];
						int cnt = findCnt(grid[startY][startX], startY, startX, d+4);
						if (cnt + 1 == 5) {
							System.out.println(grid[i][j]);
							System.out.println((startY + 1) + " " + (startX + 1));
							return;
						}

					}
				}
			}
		}
		System.out.println(0);
	}
}
