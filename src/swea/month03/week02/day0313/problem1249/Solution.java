package swea.month03.week02.day0313.problem1249;
import java.io.*;
import java.util.*;

public class Solution {
	static int[][] grid;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int N;

	static int[][] dijkstra(int y, int x) {
		int[][] dict = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dict[i], Integer.MAX_VALUE);
		dict[y][x] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for (int dir = 0; dir < 4; dir++) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N &&  dict[ny][nx] > dict[cy][cx] + grid[cy][cx]) {
					dict[ny][nx] = dict[cy][cx] + grid[cy][cx];
					q.offer(new int[] { ny, nx });
				}
			}
		}
		return dict;
	}
	static int[][] dijkstra() {
		int[][] dict = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dict[i], Integer.MAX_VALUE);
	
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
		dict[0][0]=0;
		q.offer(new int[] {0,0,0});
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			int cost = info[2];
			if(dict[cy][cx]<cost) continue;
			dict[cy][cx]=cost;
			for (int dir = 0; dir < 4; dir++) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N &&cost+grid[ny][nx]<dict[ny][nx]) {
					dict[ny][nx] = cost + grid[ny][nx];
					q.offer(new int[] {ny,nx,dict[ny][nx]});
				}
			}
		}
		return dict;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					grid[i][j] = line.charAt(j)-'0';
				}
			}
			int[][] dict = dijkstra();
			sb.append("#").append(tc).append(" ").append(dict[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
