package baekjoon.month02.week02.day0211.problem15666;

import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static List<Integer> nums;
	static int[] target;
	static boolean[] visited;
	static StringBuilder sb =new StringBuilder();
	static void comb(int start, int depth) {
		 if(depth == M){
			 for(int ele : target)
				 sb.append(ele).append(" ");
			 sb.append("\n");
			 return;
		 }
		 for(int i = start;i<nums.size();i++) {
		
			 target[depth] = nums.get(i);
			 comb(i,depth+1);
			 
		 }
	}
	public static void main(String[] args) throws IOException{
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st =new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			nums = new ArrayList<>();
			target = new int[M];
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int input = Integer.parseInt(st.nextToken());
				if(!nums.contains(input))
				nums.add(input);
			}
			Collections.sort(nums);
			visited = new boolean[nums.size()];
			comb(0,0);
			System.out.println(sb);
	}
}
