package swea.month03.week02.day0309.problem1868;

import java.io.*;
import java.util.*;

/*
 * 8방에 지뢰가 없는 점만을 클릭
 * 
 */
public class Solution {
	static int N;
	static char[][] charBoard;
	static int[][] board;
	static boolean[][] visited;
	// -1-1,-10,-11,0-1,00,01,1-1,10,11
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 1, 0, 1, -1, -1, 1, 0 };

	static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		visited[y][x]=true;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for(int i=0;i<8;i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny>=0 && ny<N && nx>=0 &&nx<N &&!visited[ny][nx]&&charBoard[ny][nx]=='.') {
					visited[ny][nx]=true;
					if(board[ny][nx]==0)
						q.offer(new int[] {ny,nx});
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			charBoard = new char[N][N];
			board = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for (int j = 0; j < N; j++) {
					charBoard[i][j] = line.charAt(j);

				}
			}
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (charBoard[y][x] == '.') {
							for (int dir = 0; dir < 8; dir++) {
								int ny = y + dy[dir];
								int nx = x + dx[dir];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N && charBoard[ny][nx] == '*') {
									board[y][x] += 1;
								}
							}
						}
					}
				}
				int cnt=0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(!visited[i][j]&&board[i][j]==0&&charBoard[i][j]=='.') {
							bfs(i,j);
							cnt+=1;
						}
					}
				}
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(!visited[i][j]&&charBoard[i][j]=='.') {
							cnt+=1;
						}
					}
				}
				System.out.println("#"+tc+" "+cnt);
				
			}
		}
	}

