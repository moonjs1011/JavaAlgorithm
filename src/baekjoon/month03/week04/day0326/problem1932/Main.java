package baekjoon.month03.week04.day0326.problem1932;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] grid;
	static boolean[][] available;
	static int[] dy = { 1, 1 };
	static int[] dx = { -1, 1 };
	static int N,maxDist;

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
				if (ny >= 0 && ny < N && nx >= 0 && nx < 2*N-1 && available[ny][nx] && dict[ny][nx] < dict[cy][cx] + grid[ny][nx]) {
					dict[ny][nx] = dict[cy][cx] + grid[ny][nx];
					q.offer(new int[] { ny, nx });
				}
			}
		}
		return dict;
	}
	static void dfs(int y,int x,int depth,int sum) {
		if(depth==N-1) {
			maxDist = Math.max(sum, maxDist);
			return;
		}
		int maxValue=0;
		for(int i=0;i<2;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < N && nx >= 0 && nx < 2*N-1 && available[ny][nx]) {
				dfs(ny,nx,depth+1,sum+grid[ny][nx]);
			}
		}
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
		int[][] dist = dijkstra(0,N-1);
		for(int j=0;j<2*N-1;j++) {
			if(available[N-1][j])
				maxDist = Math.max(maxDist,dist[N-1][j]);
		}
		System.out.println(maxDist);
//		dfs(0,N-1,0,grid[0][N-1]); <- 시간 초과
		
//		for(int i=N-1;i>0; i--) {
//			for(int j=0;j<2*N-3;j++) {
//				if(available[i][j]) {
//					grid[i-1][j+1]+=Math.max(grid[i][j], grid[i][j+2]);
//				}
//			}
//		}
//		
//		System.out.println(grid[0][N-1]);
	}
}
