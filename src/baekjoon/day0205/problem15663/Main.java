package baekjoon.day0205.problem15663;

import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr,target;
	static boolean[] visited;
	static Set<String> s = new HashSet<>();
	static StringBuilder sb =new StringBuilder();
	static void perm(int depth) {
		if(depth==M) {
			if(s.contains(Arrays.toString(target)))
				return;
			else {
				s.add(Arrays.toString(target));
				for(int ele : target) sb.append(ele+" ");
				sb.append("\n");
				return;
			}
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				target[depth] = arr[i];
				perm(depth+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];
		target = new int[M];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		perm(0);
		
		System.out.println(sb);
		
	}

}
