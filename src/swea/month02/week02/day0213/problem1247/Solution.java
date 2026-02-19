package swea.month02.week02.day0213.problem1247;

import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N;
	static Point[] customer, target;
	static Point work,home;
	static boolean[] visited;
	static int minDist;//출력할 정답

	static int calculate() {
		//회사와 고객들의 집 리스트 중 첫번째 좌표의 거리를 계산
		int dist = Math.abs(work.x- target[0].x) + Math.abs(work.y - target[0].y);
		for (int i = 0; i < N - 1; i++) {
			dist += Math.abs(target[i].x - target[i + 1].x) + Math.abs(target[i].y - target[i + 1].y);
		}
		//집과 고객들의 집 리스트 중 마지막 좌표의 거리를 계산
		dist += Math.abs(target[N - 1].x - home.x) + Math.abs(target[N - 1].y - home.y);
		return dist;
	}

	static void perm(int depth) {
		if (depth == N) {
			int dist = calculate(); 
			minDist = Math.min(minDist, dist);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				target[depth] = customer[i];
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			minDist = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine());
			customer = new Point[N];
			target = new Point[N];
			visited =new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//회사 좌표 입력
			int workX = Integer.parseInt(st.nextToken());
			int workY = Integer.parseInt(st.nextToken());
			//집 좌표 입력
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			
			work= new Point(workX,workY);
			home = new Point(homeX,homeY);
			
			for (int i = 0; i < N; i++) {
				//들려야하는 집들의 좌표 입력
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				customer[i] = new Point(x, y);
			}
			perm(0);
			String format = String.format("#%d %d\n", tc, minDist);
			sb.append(format);
		}
		System.out.println(sb);
	}
}
