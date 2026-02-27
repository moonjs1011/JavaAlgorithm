package baekjoon.month02.week04.day0226.problem17142;

import java.io.*;
import java.util.*;

/*
 * 모든 바이러스는 비활성 상태 ->Boolean
 * 4방 탐색
 * M개를 활성 상태로 변경
 * 0 = 빈컨 | 1 = 벽 | 2 바이러스 위치 
 * 바이러스의 조합을 구하고, [50*2^10] 
 */
public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int N, M, minDays;
	static int[][] matrix;
	static int[][] dict;
	static List<int[]> virus;
	static int zeroCnt;

	static void subs(int index, List<int[]> target) {
		if (index == virus.size()) {
			if (target.size() == M) {
				bfs(target);
			}
			return;
		}
		target.add(virus.get(index));
		subs(index + 1, target);
		target.remove(target.size() - 1);
		subs(index + 1, target);
	}

	static void bfs(List<int[]> target) {
		for (int i = 0; i < N; i++) {
			Arrays.fill(dict[i], Integer.MAX_VALUE);
		}
		Queue<int[]> q = new ArrayDeque<>();
		for (int[] ele : target) {
			q.offer(ele);
			dict[ele[0]][ele[1]] = 0;
		}
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && matrix[ny][nx] != 1 && dict[ny][nx] > dict[cy][cx] + 1) {
					dict[ny][nx] = dict[cy][cx] + 1;
					q.offer(new int[] { ny, nx });
				}
			}
		}
		int days = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0) {
					if (dict[i][j] == Integer.MAX_VALUE) {
						return;
					} else
						days = Math.max(days, dict[i][j]);
				}
			}

		}

		if (days == -1)
			return;
		minDays = Math.min(minDays, days);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 초기 화int [][]dict =new int[N][N];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new int[N][N];
		dict = new int[N][N];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j] == 0)
					zeroCnt += 1;
				if (matrix[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		minDays = Integer.MAX_VALUE;
		if (zeroCnt == 0)
			minDays = 0;
		else
			subs(0, new ArrayList<>());
		if (minDays == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minDays);
	}
}
