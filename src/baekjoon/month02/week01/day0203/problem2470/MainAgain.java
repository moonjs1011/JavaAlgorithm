package baekjoon.month02.week01.day0203.problem2470;

import java.io.*;
import java.util.*;

public class MainAgain {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int s = 0; // 시작점 포인터
		int e = N - 1;// 끝점 포인터
		int minSum = Integer.MAX_VALUE;
		int[] res = new int[2]; // 정답 출력
		while (s != e) {
			int sum = arr[s] + arr[e];
			if (Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				res[0] = arr[s];
				res[1] = arr[e];
			}
			if (sum < 0)
				s++;
			else if (sum > 0)
				e--;
			else
				break;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(res[0] + " " + res[1]+"\n");
		System.out.println(sb);
	}

}
