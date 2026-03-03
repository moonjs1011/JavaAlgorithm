package baekjoon.month03.week01.day0304.problem14889;

import java.io.*;
import java.util.*;
public class Main {
	static int[][] matrix;
	static int[] targetArr,indexArr;
	static boolean[] visited2;
	static boolean[] visited4;
	static int N;
	
	static int minSum=Integer.MAX_VALUE;
	static void comb(int startIndex,int depth) {
		if(depth==N/2) {
			
			int[] link = new int[N/2];
			int idx=0;
			for(int i=0;i<N;i++) {
				boolean flag =true;
				for(int j=0;j<N/2;j++) {
					if(targetArr[j]==i) {
						flag=false;
					}
				}
				if(flag) link[idx++] = i;
			}
//			System.out.println(Arrays.toString(targetArr));
//			System.out.println(Arrays.toString(link));
			
			int startSum=0;
			int linkSum=0;
			for(int i=0;i<N/2;i++) {
				for(int j=i+1;j<N/2;j++) {
					startSum+=matrix[targetArr[i]][targetArr[j]]+matrix[targetArr[j]][targetArr[i]];
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=i+1;j<N/2;j++) {
					linkSum+=matrix[link[i]][link[j]]+matrix[link[j]][link[i]];
				}
			}
			minSum=Math.min(minSum, Math.abs(startSum-linkSum));
			return;
		}
		for(int i=startIndex;i<N;i++) {
				targetArr[depth] = indexArr[i]; 
				comb(i+1,depth+1);
			}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		indexArr = new int[N];
		targetArr = new int[N/2];
		visited4 = new boolean[N];
		for(int i=0;i<N;i++) {
			indexArr[i]=i;
		}
		comb(0,0);
		sb.append(minSum);
		System.out.println(sb);
	}

}
