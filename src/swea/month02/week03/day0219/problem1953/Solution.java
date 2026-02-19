package swea.month02.week03.day0219.problem1953;

import java.io.*;
import java.util.*;

/*
 * 
 * 상우하좌
 * 1번 십자가 : 1111
 * 2번 일자 : 1010
 * 3번 일자 : 0101
 * 4번 ㄴ자 : 1100
 * 5번 r자 : 0110
 * 6번 ㄱ자 : 0011
 * 7번 자 : 1001
 */

class Point {
	int y, x, day;

	public Point(int y, int x, int day) {
		this.y = y;
		this.x = x;
		this.day = day;
	}
}

public class Solution {
	static int N, M, R, C, L, ans;
	static int[]dy= {-1,0,1,0};
	static int[]dx = {0,-1,0,1};
	static int[][] matrix;
	static boolean[][] visited;

	static boolean rangeCheck(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M && matrix[y][x] != 0;
	}

	static void bfs(int y, int x) {
		visited[y][x] = true;
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(y, x, 1));
		while (!q.isEmpty()) {
			Point curP = q.poll();
			int cy = curP.y;
			int cx = curP.x;
			int cDay = curP.day;

			if (cDay == L)
				break;
			ans += 1;
			int curType = matrix[cy][cx];
			for(int i=0;i<4;i++) {
				
			}
		}
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			matrix = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			bfs(R, C);
			System.out.println("#" + tc + " " + ans);
		}
	}
}
