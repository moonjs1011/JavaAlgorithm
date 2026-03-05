package baekjoon.month03.week01.day0305.problem4485;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix;
	static int N;
	static int[]dy = {-1,0,1,0};
	static int[]dx = {0,-1,0,1};
	static int[][] dijkstra(int y,int x) {
		int[][] dict =new int[N][N];
		for(int i=0;i<N;i++) Arrays.fill(dict[i], Integer.MAX_VALUE);
		Queue<int[]> q = new ArrayDeque<>();
		dict[y][x] =0;
		q.offer(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for(int i=0;i<4;i++) {
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				if(ny>=0 && ny<N && nx>=0 && nx<N && dict[ny][nx]>dict[cy][cx]+matrix[cy][cx]) {
					dict[ny][nx] = dict[cy][cx] + matrix[cy][cx];
					q.offer(new int[] {ny,nx});
				}
			}
		}
		return dict;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int tc=1;
		while (N != 0) {
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dict = dijkstra(0, 0);
			sb.append("Problem ").append(tc).append(":").append(" ").append(dict[N-1][N-1]+matrix[N-1][N-1]).append("\n");
			tc+=1;
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
		

	}
}
