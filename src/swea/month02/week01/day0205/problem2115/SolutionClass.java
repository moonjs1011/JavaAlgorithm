package swea.month02.week01.day0205.problem2115;

import java.io.*;
import java.util.*;

public class SolutionClass {
	static int N, M, C;
	static int[][] map;
	static int[][] maxMap;

	static int getMaxBenefit() {
		makeMaxMap();
		int maxBenefit=0;
		for(int i1=0;i1<N;i1++) {
			for(int j1=0;j1<=N-M;j1++) {
				
				for(int i2=i1;i2<N;i2++) {
					int start = (i1==i2)?j1+M:0;
					for(int j2=start;j2<=N-M;j2++) {
						int sum=maxMap[i1][j1]+maxMap[i2][j2];
						maxBenefit = Math.max(maxBenefit, sum);
					}
				}
			}
		}
		return maxBenefit;
	}

	static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
					subset(i,j,0,0,0);
			}
		}
	}

	private static void subset(int i,int j,int cnt,int sum,int powSum) {
		if(sum>C)
			return;
		if(cnt==M) {
			maxMap[i][j-M] = Math.max(maxMap[i][j-M], powSum);
			return;
		}
		subset(i,j+1,cnt+1,sum+map[i][j],powSum + map[i][j]*map[i][j]);
		subset(i,j+1,cnt+1,sum,powSum);
	}

	static int processCombination() {
		return 0;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			maxMap = new int[N][N - M + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(tc).append(" ").append(getMaxBenefit()).append("\n");
		}
		System.out.println(sb);
	}

}
