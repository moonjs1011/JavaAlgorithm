package baekjoon.month03.week04.day0324.problem6603;

import java.io.*;
import java.util.*;
public class Main {
	static int[] arr,target;
	static int K;
	static StringBuilder sb =new StringBuilder();
	static void comb(int index,int depth) {
		if(depth==6) {
			for(int ele : target) sb.append(ele+" ");
			sb.append("\n");
			return;
		}
		for(int i=index;i<K;i++) {
			target[depth] = arr[i];
			comb(i+1,depth+1);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		while(K!=0) {
			arr = new int[K];
			target = new int[6];
			for(int i=0;i<K;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			sb.append("\n");
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
}
