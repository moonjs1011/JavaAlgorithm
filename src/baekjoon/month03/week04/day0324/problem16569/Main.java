package baekjoon.month03.week04.day0324.problem16569;

import java.io.*;
import java.util.*;

/*
 * 한번 움직임 -> 화산재로 덮음 until 못움직일때까지
 * dict배열에서 값이 기록이된 값의 grid배열을 리턴 
 */
public class Main {
	static int M, N, V;
	static int[][] grid;
	static PriorityQueue<int[]> valQ = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));//용암 정보 
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	
	static int[][] valDist;
	static int[][] humanDist;
	
	static int maxHeight,minTime=Integer.MAX_VALUE;
	static void updateAnswer(int x,int y,int time) {
		if(maxHeight<grid[x][y]) {
			maxHeight = grid[x][y];
			minTime = time;
		}
		else if(maxHeight==grid[x][y]) {
			minTime = Math.min(minTime, time);
		}
	}
	static void bfs() {//화산용 bfs
		while(!valQ.isEmpty()) {
			int[] info = valQ.poll();
			int cx = info[0];
			int cy = info[1];
			for(int i=0;i<4;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx>=0 && nx<M && ny>=0 && ny<N && valDist[nx][ny]>valDist[cx][cy]+1) {
					valDist[nx][ny]= valDist[cx][cy]+1;
					valQ.offer(new int[] {nx,ny,valDist[nx][ny]});
				}
			}
		}
	}
	static void bfs(int X,int Y) {//사람용 bfs
		int[][]humanDist = new int[M][N];
		for(int i=0;i<M;i++) 
			Arrays.fill(humanDist[i],Integer.MAX_VALUE);
		humanDist[X][Y]=0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {X,Y});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cx = info[0];
			int cy = info[1];
			updateAnswer(cx,cy,humanDist[cx][cy]);
			for(int i=0;i<4;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(0<valDist[X][Y]&&nx>=0 && nx<M && ny>=0 && ny<N && humanDist[cx][cy]+1<valDist[nx][ny]&&humanDist[nx][ny]>humanDist[cx][cy]+1) {
					humanDist[nx][ny]= humanDist[cx][cy]+1;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken())-1;
		int Y = Integer.parseInt(st.nextToken())-1;
		grid = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());// 고도를 저장
			}
		}
		
		
		valDist = new int[M][N];
		for(int i=0;i<M;i++)
			Arrays.fill(valDist[i],Integer.MAX_VALUE);
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			valDist[x][y]=t;
			valQ.offer(new int[] {x,y,t});
		}
		bfs();
		bfs(X,Y);
		
		System.out.println(maxHeight+" "+minTime);
	}
}
