package baekjoon.month03.week03.day0317.problem11053;

import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	static boolean[][] isCached;
	static int[][] cached;
	static int LSS(int i,int j) {
		if(i == arr.length||j==arr.length) return 0;
		
		if(!isCached[i][j]) {
			isCached[i][j]=true;
			if(arr[i]<arr[j]) cached[i][j]= 1 + LSS(i+1,j+1);
			else cached[i][j]=Math.max(LSS(i+1,j),LSS(i,j+1));
		}
		return cached[i][j];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		isCached =new boolean[N][N];
		cached =new int[N][N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int res = LSS(0,0);
		System.out.println(res);
	}
}
