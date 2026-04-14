package swea.month04.week03.day0414.problem1263;

import java.io.*;
import java.util.*;
/*
 * 제한 시간 20초
 * N의 최대값 1000
 * 플로이드 와샬 -> O(N^3) ~= 10초(10억) -> 가능
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());

			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(i!=j)//자기 자신은 무조건 0
						dist[i][j] = ((num == 1) ? 1 : Integer.MAX_VALUE); 
				}
			}
			
			//플로이드와샬
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(dist[i][k]!= Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE)
						dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
					}
				}
			}
			
			//CC값 중에서 최소값 구하기
			int minCC=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				int CC=0;
				for(int j=0;j<N;j++) {
					CC+= dist[i][j]; // i번째 사람의 CC값 누적 계산
				}
				minCC = Math.min(minCC, CC); //최소값 갱신
			}
			sb.append("#").append(tc).append(" ").append(minCC).append("\n");
		}
		System.out.println(sb);
	}
}
