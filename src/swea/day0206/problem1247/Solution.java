package swea.day0206.problem1247;

import java.io.*;
import java.util.*;


public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[] work = new int[2],home = new int[2];
	static boolean[] visited;
	static int[][] matrix;
	static int[][] target;
	static int minDistance;
	static void perm(int depth){
		if(depth == matrix.length){
			int workY = work[0];
			int workX = work[1];
			int sum = Math.abs(workY-target[0][0]) + Math.abs(workX-target[0][1]);
			for(int i=0;i< target.length-1;i++){
				sum += Math.abs(target[i][0]-target[i+1][0]) + Math.abs(target[i][1]-target[i+1][1]);
			}
			int homeY = home[0];
			int homeX=home[1];
			sum += Math.abs(homeY-target[target.length-1][0]) + Math.abs(homeX-target[target.length-1][1]);
			minDistance = Math.min(minDistance,sum);
			return;
		}
		for(int i=0;i< matrix.length;i++){
			if(!visited[i]){
				visited[i] = true;
				target[depth] = matrix[i];
				perm(depth+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T =Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			matrix = new int[N][2];
			target = new int[N][2];
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			work[0] = Integer.parseInt(st.nextToken());
			work[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++){
				matrix[i][0] = Integer.parseInt(st.nextToken());
				matrix[i][1] = Integer.parseInt(st.nextToken());
			}
			minDistance = Integer.MAX_VALUE;
			perm(0);
			sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
		}
		System.out.println(sb);
	}

}
