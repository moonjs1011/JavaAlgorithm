package baekjoon.month02.week02.day0212.problem12865;
import java.io.*;
import java.util.*;
public class Main {
	static int N,K;
	static int[][] kg;
	static int maxValue;
	static void subs(int index,int sumWeight,int sumValue) {
		if(index==N) {
			if(sumWeight<=K) maxValue = Math.max(sumValue, maxValue);
			return;
		}
		subs(index+1,sumWeight,sumValue);
		subs(index+1,sumWeight+kg[index][0],sumValue+kg[index][1]);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		kg = new int[N][2];
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine());
			kg[i][0] = Integer.parseInt(st.nextToken());
			kg[i][1] = Integer.parseInt(st.nextToken());
		}
		maxValue = Integer.MIN_VALUE;
		subs(0,0,0);
		System.out.println(maxValue);
//		for(int []e : kg)
//			System.out.println(Arrays.toString(e));
	}
}
