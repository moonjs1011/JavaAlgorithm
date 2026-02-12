package study;

import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]>[] G = new List[N];
		for (int i = 0; i < N; i++) G[i] = (new ArrayList<>());
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int C = sc.nextInt();
				if(C!=0) G[i].add(new int[] {j,C});
			}
		}
		boolean[] v = new boolean[N];
		int[] P = new int[N]; Arrays.fill(P, Integer.MAX_VALUE);
		int mst=0,cnt=0;
		P[0]=0;
		for(int i=0;i<N;i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j=0;j<N;j++) {
				if(!v[j] && min>P[j]) {
					min = P[j];
					minVertex = j;
				}
			}
			v[minVertex] =true;
			mst+=min;
			if(cnt++==N-1) break;
			for(int[] j : G[minVertex]) {
				if(!v[j[0]] && P[j[0]]>j[1]) {
					P[j[0]] = j[1];
				}
			}
		}
		System.out.println(mst);
	}

}
