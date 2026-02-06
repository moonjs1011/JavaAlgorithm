package swea.day0206.problem1873;

import java.io.*;
import java.util.*;
/*
 * 문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)
 shoot(y,x):
 	바라 보고 있는 방향으로 직진
 	unitl * 벽 or # 강철. 
 	벽에 부딫히면 깨지면서 평지 . 로 변경
 	강철에 부딫이면 아무일도 안일어남 
 */

public class Solution {
	static char[][] matrix;
	static int H, W, cy, cx;
	static char direction;

	static void move(int y, int x) {
		int ny = y, nx = x;

		if (direction == '^')
			ny -= 1;
		else if (direction == '>')
			nx += 1;
		else if (direction == 'v')
			ny += 1;
		else if (direction == '<')
			nx -= 1;

		if (ny >= 0 && ny < H && nx >= 0 && nx < W && matrix[ny][nx] == '.') { // 움직일 때
			matrix[ny][nx] = direction;
			matrix[y][x] = '.';
			cy = ny;
			cx = nx;
		} else {
			matrix[y][x] = direction; // 못 움직일떄
		}

	}

	static void shot(int y, int x) {
		if (direction == '^') {
			for (int i = y; i >= 0; i--) {
				if (matrix[i][x] == '*') {
					matrix[i][x] = '.';
					return;
				} else if (matrix[i][x] == '#')
					return;
			}
		} 
		else if (direction == '>') {
			for (int i = x; i < W; i++) {
				if (matrix[y][i] == '*') {
					matrix[y][i] = '.';
					return;
				} else if (matrix[y][i] == '#')
					return;

			}
		}
		else if (direction == 'v') {
			for (int i = y; i < H; i++) {
				if (matrix[i][x] == '*') {
					matrix[i][x] = '.';
					return;
				} else if (matrix[i][x] == '#')
					return;
			}
		}
		else if (direction == '<') {
			for (int i = x; i >= 0; i--) {
				if (matrix[y][i] == '*') {
					matrix[y][i] = '.';
					return;
				} else if (matrix[y][i] == '#')
					return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());// 높이
			W = Integer.parseInt(st.nextToken());// 너비
			
			matrix = new char[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for (int j = 0; j < W; j++) {
					matrix[i][j] = line.charAt(j);
					// 방향을 저장해야함
					if (matrix[i][j] != '.' && matrix[i][j] != '*' && matrix[i][j] != '#' && matrix[i][j] != '-') {
						cy = i;
						cx = j;
						direction = matrix[i][j];
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 명령어의 개수
			
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int i = 0; i < N; i++) {
				char cmd = line.charAt(i);
				if (cmd == 'U') {
					direction = '^';
					move(cy, cx);
				}
				else if (cmd == 'D') {
					direction = 'v';
					move(cy, cx);
				} 
				else if (cmd == 'L') {
					direction = '<';
					move(cy, cx);
				} 
				else if (cmd == 'R') {
					direction = '>';
					move(cy, cx);
				}
				else if (cmd == 'S') {
					shot(cy, cx);
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(matrix[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}
}
