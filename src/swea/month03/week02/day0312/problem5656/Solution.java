package swea.month03.week02.day0312.problem5656;

import java.io.*;
import java.util.*;

/*
 * 구슬을 던진다 (0이 아님 i,j 좌표)
 *  터트리기전 임시 상태를 저장함
 *  i,j 좌표의 cell의 cell-1 값 만큼 4방으로 0으로 바꾼다(터트림) -> 연쇄적으로
 *  
 *  board를 순회하면
 */

public class Solution {
	static int N, W, H;
	static int[][] board, temp;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[][]info,target;
	static boolean[] visited;
	static int minCnt;
	static void gravity() {
		for(int x=0;x<W;x++) {
			int targetY=H-1;
			for(int y=H-1;y>=0;y--) {
				if(board[y][x]!=0) {
					int temp = board[y][x];
					board[y][x]=0;
					board[targetY][x]=temp;
					targetY--;
				}
			}
		}
	}
	static void explode(int y,int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x,board[y][x]-1});
		board[y][x]=0;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			int range = info[2];
			for(int d=0;d<4;d++) {
				int ny = cy;
				int nx = cx;
				for(int i=0;i<range;i++) {
					ny+=dy[d];
					nx+=dx[d];
					if(ny>=0 && ny<H && nx>=0 && nx<W) {
						if(board[ny][nx]!=0) {
							q.offer(new int[] {ny,nx,board[ny][nx]-1});
							board[ny][nx]=0;
						}
						
					}
				}
			}
		}
	}
	static void findFirst(int y,int x) {
		if(y>=H) return; //터질께 없는 경우
		if(board[y][x]!=0) {
			explode(y,x);
			gravity();
			return;
		}
		
		findFirst(y+1,x);
	}
	static void H(int depth) {//중복 순열
		if(depth==N) {
			temp =  copy(board);
//			for(int[] e : target) System.out.println(Arrays.toString(e));
//			System.out.println();
			for(int [] ele : target) {
				findFirst(ele[0],ele[1]);
			}

			int cnt=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(board[i][j]!=0) cnt+=1;
				}
			}
			minCnt = Math.min(minCnt, cnt);
			board = temp;
			return;
		}
		for(int i=0;i<W;i++) {
			target[depth] = info[i];
			H(depth+1);
		}
	}
	static int[][] copy(int[][] src) {
        int[][] dest = new int[H][W];
        for (int i = 0; i < H; i++) {
            dest[i] = src[i].clone(); 
        }
        return dest;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());// 구슬 던지는 횟수
			W = Integer.parseInt(st.nextToken());// 너비
			H = Integer.parseInt(st.nextToken());// 높이

			board = new int[H][W];
			temp = new int[H][W];
		
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			info = new int[W][2];
			target = new int[N][2];
			
			for(int i=0;i<W;i++) {
				info[i] = new int[] {0,i};
			}
			minCnt = Integer.MAX_VALUE;
			H(0);
			sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
		}
		System.out.println(sb);

	}

}
