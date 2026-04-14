package swea.month04.week02.day0407.problem2117;

/*
 * 운영 비용 K^2 + (K-1)^2
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static int[][] grid;
	static boolean[][] visited;

	static int N, M, ans;

	static void bfs(int y, int x) {
		// 레벨을 나눠서 진행
		for (int k = 1; k <= 2*N; k++) {
			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][N];
			int homeCnt = 0;

			q.offer(new int[] { y, x, 1 });
			visited[y][x] = true;
			while (!q.isEmpty()) {
				int[] info = q.poll();
				int cy = info[0];
				int cx = info[1];
				int ck = info[2];
				if (grid[cy][cx] == 1)
					homeCnt += 1;
				if (ck >= k)
					continue;
				for (int i = 0; i < 4; i++) {
					int ny = cy + dy[i];
					int nx = cx + dx[i];
					if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.offer(new int[] { ny, nx, ck + 1 });
					}
				}
			}
			
			int profit = (homeCnt * M) - (k * k + (k - 1) * (k - 1));
			if(profit>=0) {
//				System.out.println("level "+k+" "+"["+y+", "+x+"] : homeCnt :"+homeCnt +" | profit : "+profit);
				ans = Math.max(ans, homeCnt);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}
}
