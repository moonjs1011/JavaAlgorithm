package swea.month03.week02.day0313.problem7793;

/*
 * src S
 * dst D
 * 돌 X
 * 악마 *
 * S를 한칸 움직임
 */
import java.io.*;
import java.util.*;

class Point {
	char ch;
	boolean isPolluate;

	public Point(char ch) {
		this.ch = ch;
		this.isPolluate = false;
	}
}

public class Solution {
	static Point[][] grid;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static int N, M;
	static int startY, startX, dstY, dstX;
	static Queue<int[]> q1,q2;

	static boolean rangeCheck(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			q1 = new ArrayDeque<>();
			q2 = new ArrayDeque<>();
			grid = new Point[N][M];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					grid[i][j] = new Point(line.charAt(j));
					if (grid[i][j].ch == 'S') {
						startY = i;
						startX = j;
					} else if (grid[i][j].ch == 'D') {
						dstY = i;
						dstX = j;
					} else if (grid[i][j].ch == '*') {
						q2.offer(new int[] {i,j});
					}
				}
			}
		
			int time = bfs();
			if(time!=-1)
				System.out.println("#"+tc+" "+time);
			else System.out.println("#"+tc+" GAME OVER");
		}
	
	}
	/*
	 * 최초 수연위치를 수연큐에 넣음
	 * 최초 악마위치를 악마큐에 넣음
	 * 악마큐에 있는 모든 정보를 하나씩 꺼내가면서 
	 * 1.grid를 *로 마스킹 후 다음 악마 좌표 악마큐에 삽입
	 * 수연 큐에 있는 정보를 하나꺼내서 1만큼이동
	 */
	static int bfs() {
		q1.offer(new int[] { startY, startX });// {y,x, option(공주인지 악마인지)
		boolean[][]visited = new boolean[N][M];
		visited[startY][startX]=true;
		int time=0;
		while (!q1.isEmpty()) {
			time+=1;
			int q2Size = q2.size();
			for(int iter =0; iter<q2Size;iter++) {
				int[]info = q2.poll();
				int cy = info[0];
				int cx = info[1];
				for(int i=0;i<4;i++) {
					int ny = cy + dy[i];
					int nx = cx + dx[i];
					if(rangeCheck(ny, nx)&&(grid[ny][nx].ch=='.'||grid[ny][nx].ch=='S')) {
						grid[ny][nx].ch = '*';
						q2.offer(new int[] {ny,nx});
					}
				}
			}
			int q1Size = q1.size();
			for(int iter =0; iter<q1Size;iter++) {
				int[]info = q1.poll();
				int cy = info[0];
				int cx = info[1];
				if(grid[cy][cx].ch=='D') return time-1;
				for(int i=0;i<4;i++) {
					int ny = cy + dy[i];
					int nx = cx + dx[i];
					if(rangeCheck(ny, nx)&&!visited[ny][nx]&&(grid[ny][nx].ch=='.'||grid[ny][nx].ch=='D')) {
						visited[ny][nx] =true;
						q1.offer(new int[] {ny,nx});
					}
				}
			}
		}

		return -1;

	}
}
