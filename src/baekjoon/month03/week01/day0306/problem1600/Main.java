package baekjoon.month03.week01.day0306.problem1600;

import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static int N, M;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dhy = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dhx = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static int[][] matrix;

	static int bfs(int y, int x) {
		int[][][] dist = new int[K+1][N][M];
		for (int i = 0; i <=K; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}
		dist[0][y][x] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, y, x });
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int ck= info[0];
			int cy = info[1];
			int cx = info[2];
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny>=0 && ny<N && nx>=0 && nx<M && matrix[ny][nx]==0 && dist[ck][ny][nx]>dist[ck][cy][cx]+1) {
					dist[ck][ny][nx] = dist[ck][cy][cx]+1;
					q.offer(new int[] {ck,ny,nx});
				}
			}
			if(ck<K) {
				for(int i=0;i<8;i++) {
					int ny = cy + dhy[i];
					int nx = cx + dhx[i];
					if(ny>=0 && ny<N && nx>=0 && nx<M && matrix[ny][nx]==0 && dist[ck+1][ny][nx]>dist[ck][cy][cx]+1) {
						dist[ck+1][ny][nx] = dist[ck][cy][cx]+1;
						q.offer(new int[] {ck+1,ny,nx});
					}
				}
			}
		}
		int minValue =Integer.MAX_VALUE;
		for(int i=0;i<=K;i++) {
			minValue = Math.min(minValue, dist[i][N-1][M-1]);
		}
		return minValue;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = bfs(0,0);
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);

	}
}
