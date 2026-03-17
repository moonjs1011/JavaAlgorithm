package baekjoon.month03.week03.day0317.problem11053;

import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	static boolean[] isCached;
	static int[] cached;
	static int LSS(int index) {
		if(index == arr.length) return 0;
		
		if(!isCached[index]) {
			isCached[index]=true;
			if(arr[index-1]<arr[index]) cached[index]= 1 + LSS(index+1);
			else cached[index]=LSS(index+1);
		}
		return cached[index];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		isCached =new boolean[N];
		cached =new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int res = LSS(1);
		System.out.println(res+1);
	}
}
