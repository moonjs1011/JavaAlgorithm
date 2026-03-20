package baekjoon.month03.week03.day0320.problem2048;

import java.io.*;
import java.util.*;

/*
 * 최대 5번 이동 -> 4^5 완전탐색 가능
 */
public class Main {
	static int MAX_MOVE = 5;
	static int[][] dyx = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int[][] board;
	static int N;
	static int maxNum;

	static int[] mergeLine(List<Integer> list) {
		int[] result = new int[N];
		int idx = 0;

		for (int i = 0; i < list.size(); i++) {
			if (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
				result[idx] = list.get(i) * 2;
				maxNum = Math.max(maxNum, result[idx]);
				idx++;
				i++; // 다음 칸은 이미 합쳐졌으므로 건너뜀
			} else {
				result[idx] = list.get(i);
				maxNum = Math.max(maxNum, result[idx]);
				idx++;
			}
		}

		return result;
	}

	static void slideBoard(int[][] move) {
		for (int i = 0; i < MAX_MOVE; i++) {
			int dy = move[i][0];
			int dx = move[i][1];

			// 위
			if (dy == -1 && dx == 0) {
				for (int x = 0; x < N; x++) {
					List<Integer> list = new ArrayList<>();
					for (int y = 0; y < N; y++) {
						if (board[y][x] != 0)
							list.add(board[y][x]);
					}

					int[] merged = mergeLine(list);

					for (int y = 0; y < N; y++) {
						board[y][x] = merged[y];
					}
				}
			}
			// 왼쪽
			else if (dy == 0 && dx == -1) {
				for (int y = 0; y < N; y++) {
					List<Integer> list = new ArrayList<>();
					for (int x = 0; x < N; x++) {
						if (board[y][x] != 0)
							list.add(board[y][x]);
					}

					int[] merged = mergeLine(list);

					for (int x = 0; x < N; x++) {
						board[y][x] = merged[x];
					}
				}
			}
			// 아래
			else if (dy == 1 && dx == 0) {
				for (int x = 0; x < N; x++) {
					List<Integer> list = new ArrayList<>();
					for (int y = N - 1; y >= 0; y--) {
						if (board[y][x] != 0)
							list.add(board[y][x]);
					}

					int[] merged = mergeLine(list);

					for (int y = N - 1, idx = 0; y >= 0; y--, idx++) {
						board[y][x] = merged[idx];
					}
				}
			}
			// 오른쪽
			else if (dy == 0 && dx == 1) {
				for (int y = 0; y < N; y++) {
					List<Integer> list = new ArrayList<>();
					for (int x = N - 1; x >= 0; x--) {
						if (board[y][x] != 0)
							list.add(board[y][x]);
					}

					int[] merged = mergeLine(list);

					for (int x = N - 1, idx = 0; x >= 0; x--, idx++) {
						board[y][x] = merged[idx];
					}
				}
			}
		}
	}

	static void perm(int[][] move, int depth) {
		if (depth == 5) {
			int[][] tempBoard = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempBoard[i][j] = board[i][j];
				}
			}

			slideBoard(move);

			board = tempBoard;
			return;
		}

		for (int i = 0; i < 4; i++) {
			move[depth] = dyx[i];
			perm(move, depth + 1);
		}
	}

	static void solution() {
		int[][] move = new int[MAX_MOVE][2];
		perm(move, 0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, board[i][j]); // 초기 최댓값 반영
			}
		}

		solution();
		System.out.println(maxNum);
	}
}