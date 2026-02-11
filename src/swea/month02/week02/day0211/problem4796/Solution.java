package swea.month02.week02.day0211.problem4796;

import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static long[] height;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			height = new long[N];
			for (int i = 0; i < N; i++) {
				height[i] = sc.nextLong();
			}
			long up = 0;
			long cnt = 0;
			boolean isUp = false;
			for (int i = 0; i < N - 1; i++) {
				if (height[i] < height[i + 1]) {
					if (!isUp)
						up = 0;
					isUp = true;
					up += 1;

				} else if (height[i] > height[i + 1]) {
					if (up > 0) {
						isUp = false;
						cnt += up;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt + "\n");
		}
	}

}
