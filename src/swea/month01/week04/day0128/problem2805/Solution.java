package swea.month01.week04.day0128.problem2805;

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] matrix; // 공통 전역변수
	static int N; // 공통 전역 변수
	static int[] dy = { -1, 0, 1, 0 }; // BFS + DFS용 전역 변수
	static int[] dx = { 0, -1, 0, 1 }; // BFS + DFS용 전역 변수
	static boolean[][] visited; // BFS + DFS용 전역 변수
	static int sumDfs; // DFS용 전역 변수

	static int iterator() {
		int sum = 0;
		int middle = N / 2;
		for (int y = 0; y < N; y++) {
			if (y < middle) { // 상반부
				for (int x = middle - y; x <= middle + y; x++) {
					sum += matrix[y][x];
				}
			} else if (y == middle) {// 중단부
				for (int x = 0; x < N; x++) {
					sum += matrix[y][x];
				}
			} else if (y > middle) {// 하단부, x의 끝점은 대칭을 이용하여 N-1-(시작점)
				for (int x = y - middle; x <= N - 1 - (y - middle); x++) {
					sum += matrix[y][x];
				}
			}
		}
		return sum;
	}

	static int bfs() {
		// *********초기화 phase*********//
		int middle = N / 2;
		int sum = matrix[middle][middle];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		// ***************************//
		// *********BFS phase*********//
		visited[middle][middle] = true;
		q.offer(new int[] { middle, middle });
		for (int level = 0; level < middle; level++) {//중간으로부터 거리(계층)
			int size = q.size(); // 큐에 존재하는 노드의 개수만큼 반복문 수행
			for (int i = 0; i < size; i++) {
				int[] cyx = q.poll();
				int cy = cyx[0];
				int cx = cyx[1];
				for (int d = 0; d < 4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
						visited[ny][nx] = true;
						sum += matrix[ny][nx];
						q.offer(new int[] { ny, nx });
					}
				}
			}
		}
		// ******************//
		return sum; // 정답 리턴
	}

	static void dfs(int y, int x) {
		if (visited[y][x])
			return;
		visited[y][x] = true;
		sumDfs+= matrix[y][x];
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			int middle = N / 2;
			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				//다음 (y좌표 - 중심 좌표)의 절대값 + 다음 (x좌표 - 중심 좌표)의 절대값 <= 중심 좌표
				if (Math.abs(ny - middle) + Math.abs(nx - middle) <= middle) {
					dfs(ny, nx);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// Input Phase
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			// -----------------Input Phase-------------//
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N 입력 받기
			matrix = new int[N][N]; // matrix 초기화
			visited = new boolean[N][N];//visited 초기화

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); // 한개의 String으로 입력을 받음
				String line = st.nextToken();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line.charAt(j) - '0';
				}
			}
			// -----------Solution-------------//
			int result;
			
			result = iterator(); // 반복문 풀이법
			
			// result = bfs(); //BFS 풀이법
			
			//DFS 풀이
			
//			  sumDfs =0; 
//			  dfs(N/2,N/2); 
//			  result = sumDfs;
			
			// --------------------------------//
			// print
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
