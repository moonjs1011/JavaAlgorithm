package baekjoon.month02.week02.day0210.problem15654;
import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb =new StringBuilder();
	static int[] nums,target;
	static boolean[] visited;
	static int N,M;
	static void perm(int depth) {
		if(depth==M) {
			for(int ele : target)
				sb.append(ele+" ");
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true ;
				target[depth] = nums[i];
				perm(depth+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		nums = new int[N];
		target = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		perm(0);
		System.out.println(sb);
	}

}
