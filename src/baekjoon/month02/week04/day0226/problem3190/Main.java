package baekjoon.month02.week04.day0226.problem3190;

import java.io.*;
import java.util.*;

/*
 * N 입력 받고 K사과수, L 커멘드 수
 * 시작 위치는 0,0 / 길이는 1/ 맨 처음 방향은 오른쪽
 * 
 */
class Info {
	int time;
	char cmd;

	public Info(int time, char cmd) {
		this.time = time;
		this.cmd = cmd;
	}
}
class Point{
	int y;
	int x;
	public Point(int y,int x) {
		this.y=y;
		this.x=x;
	}
}

public class Main {
	// 0 : 위 , 1 : 좌 , 2 : 하 : 3 :우
	//
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int N, K, L;
	static int[][] matrix;
	static Queue<Info> q = new ArrayDeque<>();
	static Deque<Point> dq = new ArrayDeque<>();
	static boolean[][] isSnake;
	
	static int game() {
		dq.offer(new Point(0,0));
		int dir =3;
		int curTime=0;
		isSnake[0][0] = true;
		
		Info info = q.poll();
		int time = info.time;
		char cmd = info.cmd;
		
		while(true) {
			curTime+=1;
			Point point = dq.peek();
			int cy = point.y;
			int cx = point.x;
			
			int ny = cy + dy[dir]; 
			int nx = cx + dx[dir];
			
			if(ny<0 || ny >=N || nx<0 || nx>=N ||isSnake[ny][nx]) {
				break;
			}
			
			dq.addFirst(new Point(ny,nx));
			isSnake[ny][nx]=true;
			if(matrix[ny][nx]==0) {
				Point p = dq.pollLast();
				int taily = p.y;
				int tailx = p.x;
				isSnake[taily][tailx]=false;
				
			}
			if(matrix[ny][nx]==1) {
				matrix[ny][nx]=0;
			}
			/*
			 * L:
			 * dir:0 ->1
			 * dir:1->2
			 * dir:2->3
			 */
			if(curTime == time) {
				if(cmd == 'L') dir = (dir+1)%4;
				else if(cmd =='D') dir= (dir+3)%4;
				
				if(!q.isEmpty()) {
				info = q.poll();
				time = info.time;
				cmd = info.cmd;
				}
			}
		}
		return curTime;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		isSnake = new boolean[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			matrix[y - 1][x - 1] = 1; // 값 보정
		}
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			q.offer(new Info(time, cmd));
		}
		System.out.println(game());

	}
}
