package swea.month02.week02.day0209.problem7733;

import java.io.*;
import java.util.*;

public class Solution {
	static int[]dy = {-1,0,1,0};
	static int[]dx = {0,-1,0,1};
	static int N;
	static int[][] matrix;
	static boolean[][] visited;
	static void bfs(int y,int x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		visited[y][x] =true;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for(int i=0;i<4;i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny>=0 && ny<N && nx>=0 &&nx<N && matrix[ny][nx]!=0 && !visited[ny][nx] ) {
						visited[ny][nx] =true;
						q.offer(new int[] {ny,nx});
				}
			}
		}
	}
	static void dfs(int y,int x) {
		if(visited[y][x]) return;
		visited[y][x] = true;
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny>=0 && ny<N && nx>=0 &&nx<N && matrix[ny][nx]!=0 && !visited[ny][nx] ) {
					dfs(ny,nx);
			}
		}
			
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st =new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			int maxDay = 1;
			for(int i=0;i<N;i++) {
				st =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, matrix[i][j]); //maxDay 최신화
				}
			}
			int maxCnt=1; //0으로 하면 한개의 히든 tc에 오답나옴 
			for(int day=1;day<=maxDay;day++) {
				visited = new boolean[N][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						//matrix[i][j] 값이 0이면 갉아먹혔다고 치부
						//문제에서 값이 1부터 100사이의 숫자로 주어진다고 했으므로 안전.
						if(matrix[i][j]==day) matrix[i][j]=0; 
					}
				}
				int cnt=0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(matrix[i][j]!=0&&!visited[i][j]) {
							//dfs(i,j);
							bfs(i,j);
							cnt++;
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}
}
