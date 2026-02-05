package swea.day0205.problem2115;

import java.io.*;
import java.util.*;

/*
 * N X N matrix
 * M :수평적으로 탐색가능한 범위
 * C : sum(matrix[y][x])의 max
 * sol. 구간을 조합으로 구현
 * 2차원 배열 2개 ex [[0,1,2,3,4],[5,6,7,8,9]]
 * worst case : 81개의 조합
 */
class Point{
	int y;
	int x;
}
public class Solution {
	static int N, M, C;
	static int[][] matrix;
	static int[][] maxProfitMap;
	static void calcaulateMax() {
		   for(int i=0;i<N;i++) {
			   for(int j=0;j<=N-M;j++) {
				   int[] honey = new int[M];
				   for(int k=0;k<M;k++) {
					   honey[k] = matrix[i][j+k];
				   }
				   maxProfitMap[i][j] = getMaxProfit(honey);
			   }
		   }
	}
	static int getMaxProfit(int[]honey) {
		return subset(honey,0,0,0);
	}
	static int subset(int[]honey,int index,int sum,int profit) {
		if(sum>C) return 0;
		if(index==M) return profit;
		int pick = subset(honey,index+1,sum+honey[index],profit + honey[index]*honey[index]);
		int skip = subset(honey,index+1,sum,profit);
		return Math.max(pick, skip);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			matrix = new int[N][N];
			maxProfitMap = new int[N][N];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					matrix[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			calcaulateMax();
			int max=0;
			for(int y1=0;y1<N;y1++) {
				for(int x1=0;x1<=N-M;x1++) {
					for(int y2=0;y2<N;y2++) {
						for(int x2=0;x2<=N-M;x2++) {
							if(y1==y2 && x1+M>x2) continue;
							max = Math.max(max, maxProfitMap[y1][x1]+maxProfitMap[y2][x2]);
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}

}
