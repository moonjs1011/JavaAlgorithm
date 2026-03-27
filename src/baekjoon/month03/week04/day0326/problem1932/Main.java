package baekjoon.month03.week04.day0326.problem1932;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] grid;
	static boolean[][] available;
	static int[] dy = { 1, 1 };
	static int[] dx = { -1, 1 };
	static int N;

	static int[][] dijkstra(int y, int x) {
		int[][] dict = new int[N][2*N-1];
		for (int i = 0; i < N; i++)
			Arrays.fill(dict[i], Integer.MIN_VALUE);
		dict[y][x] = grid[y][x];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for (int i = 0; i < 2; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && available[ny][nx] && dict[ny][nx] < dict[cy][cx] + grid[ny][nx]) {
					dict[ny][nx] = dict[cy][cx] + grid[ny][nx];
					q.offer(new int[] { ny, nx });
				}
			}
		}
		return dict;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][2*N-1];
		available = new boolean[N][2*N-1];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			int j = (N-1) -  i;
			while (cnt <= i) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				available[i][j] = true;
				j+=2;
				cnt+=1;
			}
		}
//		for (int[] e : grid)
//			System.out.println(Arrays.toString(e));
		int maxDist =0;
		for (int i = 0; i < N; i++) {
			if (available[0][i]) {
				int[][] dict = dijkstra(0, i);
				
				for(int j=0;j<2*N-1;j++) {
					maxDist = Math.max(dict[N-1][j], maxDist);
				}
			}
		}
		System.out.println(maxDist);
	}
}
