package baekjoon.month02.week02.day0209.problem15652;

import java.util.*;

public class Main {
	static int[] nums;
	static int[] target;
	static int N, R;

	static void perm(int depth,int start) {
		if (depth == R) {
			for (int e : target) {
				System.out.print(e + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			target[depth] = nums[i];
			perm(depth + 1,i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		nums = new int[N];
		target = new int[R];
		for (int i = 0; i < N; i++)
			nums[i] = i + 1;
		perm(0,0);
	}

}
