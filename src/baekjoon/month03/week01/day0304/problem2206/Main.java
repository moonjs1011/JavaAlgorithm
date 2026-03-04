package baekjoon.month03.week01.day0304.problem2206;

// https://www.acmicpc.net/problem/2206
import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static int[][] matrix;

	static int N, M;

	static int[][][] bfs(int y,int x) {
		int[][][] dict = new int[2][N][M];
		for(int i=0;i<2;i++) {
			for(int j=0;j<N;j++)
			Arrays.fill(dict[i][j], Integer.MAX_VALUE);
		}
		dict[0][y][x]=1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,y,x});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int isBreak =info[0];
			int cy = info[1];
			int cx = info[2];
			for(int i=0;i<4;i++) {
				int ny = cy + dy[i];
				int nx = cx  +dx[i];
				if(ny>=0 && ny<N && nx>=0 && nx<M) {
					if (matrix[ny][nx] == 0) { // 갈 수 있는 길일 때
					    if (dict[isBreak][ny][nx] > dict[isBreak][cy][cx] + 1) {
					        dict[isBreak][ny][nx] = dict[isBreak][cy][cx] + 1;
					        q.offer(new int[] {isBreak, ny, nx});
					    }
					} else if (matrix[ny][nx] == 1 && isBreak == 0) { // 벽인데 아직 안 부쉈을 때
					    if (dict[1][ny][nx] > dict[0][cy][cx] + 1) {
					        dict[1][ny][nx] = dict[0][cy][cx] + 1;
					        q.offer(new int[] {1, ny, nx});
					    }
					}
				}
			}
		}
//		System.out.println(dict[N-1][M-1]);																																							
		return dict;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}
		int minDist = Integer.MAX_VALUE;
		int[][][] dict = bfs(0, 0);
		minDist = Math.min(dict[0][N - 1][M - 1], dict[1][N - 1][M - 1]);

		StringBuilder sb = new StringBuilder();
		if (minDist == Integer.MAX_VALUE)
			sb.append(-1);
		else
			sb.append(minDist);
		System.out.println(sb);
	}

}
