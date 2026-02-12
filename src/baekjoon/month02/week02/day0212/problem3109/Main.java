package baekjoon.month02.week02.day0212.problem3109;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = { -1, 0, 1 };
	static int[] dx = { 1, 1, 1 };
	static char[][] board;
	static boolean[][] visited;
	static int R, C;
	static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
		System.out.println("-----------------------");
	}
	static void dfs(int y,int x) {
		if(x==C-1) return;
		if(visited[y][x]) return;
		visited[y][x] = true;
		for(int i=0;i<3;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(0<=ny && ny<R && 0<=nx &&nx<C && board[ny][nx]=='.') {
				print();
				board[ny][nx]='x';
				dfs(ny,nx);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		for(int i=0;i<R;i++) {
			dfs(i,0);
		}
		int cnt=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
		for (int i = 0; i < R; i++) {
			if(board[i][C-1]=='x') cnt+=1;
		}
		System.out.println(cnt);
		
	}

}
