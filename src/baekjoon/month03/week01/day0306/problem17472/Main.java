package baekjoon.month03.week01.day0306.problem17472;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix, dist;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int N, M, maxVid;

	static int Prim() {
		boolean[] visited = new boolean[maxVid+1];
		visited[1] =true;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		for(int i=2;i<=maxVid;i++) {
			if(dist[1][i]!=Integer.MAX_VALUE)
				pq.offer(new int[] {i,dist[1][i]});				
		}
		int cnt=0;
		int mst=0;
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int curDst = info[0];
			int curDist = info[1];
			if(visited[curDst]) continue;
			visited[curDst] = true;
			mst+=curDist;
			cnt++;
			if(cnt==maxVid-1) return mst;
			for(int vid =1;vid<=maxVid;vid++) {
				if(!visited[vid] && dist[curDst][vid]!=Integer.MAX_VALUE) {
					pq.offer(new int[] {vid,dist[curDst][vid]});
				}
			}
		}
		return -1;
	}

	static void dfs(int y, int x, int dir, int vid, int length) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return;
//		if (matrix[ny][nx] == vid)
//			return;
		if ((matrix[ny][nx] != 0 && matrix[ny][nx] != vid)||(matrix[ny][nx] == vid)) {
			if (length >= 2) {
				dist[vid][matrix[ny][nx]] = Math.min(dist[vid][matrix[ny][nx]], length);
			}
			return;
		}

		dfs(ny, nx, dir, vid, length + 1);
	}

	static void transMatrix(int y, int x, int value) {
		matrix[y][x] = value;
		visited[y][x] = true;

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { y, x });

		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for (int dir = 0; dir < 4; dir++) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && matrix[ny][nx] != 0) {
					matrix[ny][nx] = value;
					visited[ny][nx] = true;
					q.offer(new int[] { ny, nx });
				}
			}
		}
	}

	static void log() {
		for (int[] e : matrix) {
			System.out.println(Arrays.toString(e));
		}
		for (int i = 1; i <= maxVid; i++) {
			for (int j = 1; j <= maxVid; j++) {
				if (dist[i][j] == Integer.MAX_VALUE)
					System.out.print(0 + " ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];
		int vid = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && matrix[i][j] != 0) {
					transMatrix(i, j, vid);
					vid += 1;
				}
			}
		}
		maxVid = vid - 1;
		dist = new int[maxVid + 1][maxVid + 1];
		for (int i = 1; i <= maxVid; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] != 0) {
					for (int dir = 0; dir < 4; dir++) {
						dfs(i, j, dir, matrix[i][j], 0);
					}
				}
			}
		}
//		log();
		int ans = Prim();
		System.out.println(ans);

	}
}
