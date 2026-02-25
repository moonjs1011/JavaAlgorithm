package swea.month02.week03.day0225.problem3234;

/*
 * 최대 2^10 -> 부분집합 
 * 양팔 저울에 갑자기 문제가 생겨서 무게 추를 올릴 때 오른쪽 위에 올라가 있는 
 * 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr, target; // 추 저장
	static boolean[] visited;
	static int N, cnt;

	static void subs(int index, int sumLeft, int sumRight) {
		if (sumLeft < sumRight)
			return;
		if (index == N) {
			cnt += 1;
			return;
		}
		subs(index + 1, sumLeft + target[index], sumRight);
		subs(index + 1, sumLeft, sumRight + target[index]);
	}

	static void perm(int depth) {
		if (depth == N) {
			subs(0, 0, 0);
			return;

		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				target[depth] = arr[i];
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			target = new int[N];
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			perm(0);
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}
