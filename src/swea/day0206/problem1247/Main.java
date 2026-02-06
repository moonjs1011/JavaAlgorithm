package swea.day0206.problem1247;

import java.io.*;
import java.util.*;

/*
 * vector<vector<pair<int,pair<int,int>>>> v
 */
class Node {
	int y;
	int x;
	int distance;

	public Node(int y, int x, int distnace) {
		this.y = y;
		this.x = x;
		this.distance = distnace;
	}
}

public class Main {
	static int[][] customerInfo;

	static List<List<Node>> adjList;
	static List<Node> nodeList;
	static void dij(int y,int x) {
		PriorityQueue<int[]> pq = new PriorityQueue<>();
		pq.offer(new int[] {y,x});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curY = cur[0], curX = cur[1];
			for(int i=)
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int workY = Integer.parseInt(st.nextToken());
			int workX = Integer.parseInt(st.nextToken());

			int homeY = Integer.parseInt(st.nextToken());
			int homeX = Integer.parseInt(st.nextToken());

			customerInfo = new int[N - 2][3];
			for (int i = 1; i <= N - 2; i++) {
				int customerY = Integer.parseInt(st.nextToken());
				int customerX = Integer.parseInt(st.nextToken());
				int weight = Math.abs(customerY-workY) + Math.abs(customerX-workX);
				adjList.get(0).add(new Node(customerY,customerX,weight));
				weight = Math.abs(homeY-workY) + Math.abs(homeX-workX);
				adjList.get(adjList.size()-1).add(new Node(homeY,homeX,weight));
			}
			for()
		}

	}

}
