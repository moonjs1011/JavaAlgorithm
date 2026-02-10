package swea.month02.week02.day0210.problem1767;

import java.io.*;
import java.util.*;

/* 최대한 많은 Core에 전원을 연결했을 경우 <- core의 개수가 우선순위가 높다.
 * max core 연결했을 경우 전선길이의 최소 합!  
 * 1.연결해야하는 코어 리스트 찾기
 * 	-비 가장자리 코어 리스트 생성
 * 
 * 2.완탐이 가능할까?
 * 코어 1개만 선택, <- nC1
 * 코어 2개만 선택, <- nC2
 * 코어 3개만 선택, <- nC3...
 * 부분집합
 * N<=12니까 할만한데? 2^n * n 정도
 * 3. 코어에 전선을 놓는다. 
 *  -4방향 시도, 코어비선택  -> 5^n -> 2.4억
 *  가지치기 시도 교차하는 순간.
 *  
 *  장애물이 되는 요소 : 벽, 기존에 설치된 코어들, 알고리즘을 수행하며 놓은 전선들
 */
public class Solution {
	static int N, max, totalCnt, min;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0, };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<int[]> list; // {r1,c1},{r2,c2}..

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;// 가장자리가 아닌 코어수.
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;// 가장 자리 코어들
					if (map[i][j] == 1)// 가장 자리가 아닌 코어들
						list.add(new int[] { i, j });
				}
			}
			totalCnt = list.size();
			setPower(0,0,0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	/*
	 * @param : 코어의 index
	 * 
	 * @param : 현재까지 누적 된 coreCnt
	 * @param : 현재까지 누적 된 lineCnt
	 */
	static void setPower(int index,int coreCnt,int lineCnt) {
		if(index == totalCnt) {
			if(max<coreCnt) {
				max = coreCnt;//core
				min = lineCnt;//line
			}
			else if(max == coreCnt) {
				min = Math.min(min, lineCnt);
			}
			return;
		}
		// 해당 코어를 4방향으로 전선 놓기 시도
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		for (int d = 0; d < 4; d++) {
			// 해당 코어를 d방향으로 놓는것이 가능한지 체크
			if (!isAvailable(r, c, d))
				continue;

			// 해당 코어를 d방향으로 전선 놓기
			int cnt = setStatus(r,c,d,2); //전선 놓기;
			// 다음 코어 넘어가기
			setPower(index+1,coreCnt+1,lineCnt+cnt);	
			// 해당 코어를 d방향으로 전선 지우기
			setStatus(r,c,d,0);//전선 지우기 

		}
		
		// 해당 코어를 전선놓기 하지 않기
		setPower(index+1,coreCnt,lineCnt);
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr=r,nc=c;
		while(true) {
			nr += dr[d];
			nc +=dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			if(map[nr][nc]>=1) return false; //진행 불가
		}
		return true;
	}
	private static int setStatus(int r,int c,int d,int opt) {
		int nr=r,nc=c,cnt=0;
		while(true) {
			nr += dr[d];
			nc +=dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			map[nr][nc]=opt; //지금 타고간게 전선의 길이
			cnt+=1; //전선의 길이는 마지막에 2인개수 카운트해도 되지만, 효율적으로
		}
		return cnt;
	}
}
