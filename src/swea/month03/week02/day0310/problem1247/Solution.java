package swea.month03.week02.day0310.problem1247;

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
	static Point[] info, target;
	static Point work, home;
	static boolean[] visited;
	static int N, minDistance;

	static int calculate() {
		int distance = 0;
		distance += Math.abs(work.x - target[0].x) + Math.abs(work.y - target[0].y); // work과 순열의 첫번째 고객의 집 사이의 거리
		for (int i = 0; i < N - 1; i++) {
			distance += Math.abs(target[i].x - target[i + 1].x) + Math.abs(target[i].y - target[i + 1].y); //고객의 집들 사이의 거리
		}
		distance += Math.abs(target[N - 1].x - home.x) + Math.abs(target[N - 1].y - home.y); //순열의 마지막 고객의 집과 home 사의의 거리
		return distance; 
	}

	static void perm(int depth) {
		if (depth == N) {
			int distance = calculate(); //거리 리턴
			minDistance = Math.min(minDistance, distance);//최소 거리 갱신
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				target[depth] = info[i];
				perm(depth + 1);
				visited[i] = false;
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

			st = new StringTokenizer(br.readLine());
			int workx = Integer.parseInt(st.nextToken());//입력의 첫번째
			int worky = Integer.parseInt(st.nextToken());//입력의 두번째

			int homex = Integer.parseInt(st.nextToken());//입력의 세번째
			int homey = Integer.parseInt(st.nextToken());//입력의 네번째

			work = new Point(workx, worky);//Point객체에 저장
			home = new Point(homex, homey);//Point객체에 저장

			info = new Point[N];//원본 정보 저장
			target = new Point[N];//순열 정보 저장
			visited = new boolean[N];//방문 체크
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				info[i] = new Point(x, y);//원본 정보 저장
			}
			minDistance = Integer.MAX_VALUE;
			perm(0);
			sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
		}
		System.out.print(sb);

	}
}
