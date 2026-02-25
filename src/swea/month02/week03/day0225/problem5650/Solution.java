package swea.month02.week03.day0225.problem5650;
import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] matrix;
	static Map<Integer, List<int[]>> wormHole;
	static int maxCnt;
	// 상 : 0, 좌 : 1, 하 :2 ,우 :3
	static int reflectMap[][] = { {}, { 2, 0, 3, 1 }, { 3, 2, 0, 1 }, { 1, 3, 0, 2 }, { 2, 3, 1, 0 }, { 2, 3, 0, 1 } };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static void dfs(int starty, int startx, int y, int x, int dir, int cnt) {
		int limit = N * N * 4;
		while (true) {
			// 벽에 부딫히는 상황
			if(y<0 || y>=N ||x<0 || x>=N) {
				y = y - dy[dir];
				x = x -dx[dir];
				dir = reflectMap[5][dir];
				continue;
			}
			// 벽에 부딫히는 상황 끝
			// 기저 조건
			if ((starty == y && startx == x && cnt != 0) || (matrix[y][x] == -1)) {
				maxCnt = Math.max(maxCnt, cnt);
				break;
			}
			// 현재 위치의 셀이 무슨 종류인지 확인,
			// 1.1~5사이의 블록 이면 dir를 바꿔줌.
			if (matrix[y][x] >= 1 && matrix[y][x] <= 5) {
				dir = reflectMap[matrix[y][x]][dir];
				cnt += 1;
			}
			// 2. 6~10 웜홀이면 y,x를 바꿔줌.
			else if (matrix[y][x] >= 6 && matrix[y][x] <= 10) {
				List<int[]> info = wormHole.get(matrix[y][x]);
				for (int[] ele : info) {
					if (!(y == ele[0] && x == ele[1])) {
						y = ele[0];
						x = ele[1];
						break;
					}
				}
			}
			y = y + dy[dir];
			x = x + dx[dir];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			wormHole = new HashMap<>();
			for (int i = 6; i <= 10; i++)
				wormHole.put(i, new ArrayList<>());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if (matrix[i][j] >= 6) { // 웜홀
						wormHole.get(matrix[i][j]).add(new int[] { i, j });
					}
				}
			}
			maxCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int dir = 0; dir < 4; dir++) {
						if (matrix[i][j] == 0) {
							dfs(i, j, i, j, dir, 0);
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}
}