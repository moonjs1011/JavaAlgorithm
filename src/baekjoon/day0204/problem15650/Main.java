package baekjoon.day0204.problem15650;

import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] target;
	static StringBuilder sb = new StringBuilder();

	static void comb(int index,int depth, int maxDepth) {
		if (depth == maxDepth) {
			for (int ele : target) {
				sb.append(ele).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = index; i < arr.length; i++) {
			target[depth] = arr[i];
			comb(i+1,depth + 1, maxDepth);
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		target = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		comb(0,0, M);

		System.out.println(sb);

	}

}
