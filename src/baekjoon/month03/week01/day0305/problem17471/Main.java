package baekjoon.month03.week01.day0305.problem17471;

import java.io.*;
import java.util.*;

/*
 * 두개의 지역구로 나눔 -> perm
 * 
 */
public class Main {
	static int N;
	static int[] human;
	static int[] vid;
	static Map<Integer, List<Integer>> adjList = new HashMap<>();
	static void bfs(List<Integer> li,int vid) {
		boolean[] visited = new boolean[N+1];
		int vId = li.get(0);
		visited[vid] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(vid);
		while(!q.isEmpty()) {
			int cvId = q.poll();
			for(Integer nvId : adjList.get(cvId)) {
				if(!visited[nvId]) {
					visited[nvId]= true;
					q.offer(nvId);
				}
			}
		}
		
	}
	static void subs(int index, List<Integer> li1, List<Integer> li2) {
		if (index == N + 1) {
			if (!li1.isEmpty() && !li2.isEmpty()) {
				System.out.println(li1.toString());
				System.out.println(li2.toString());
			}
			return;
		}
		li1.add(vid[index]);
		subs(index + 1, li1, li2);
		li1.remove(li1.size() - 1);
		li2.add(vid[index]);
		subs(index + 1, li1, li2);
		li2.remove(li2.size() - 1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 인원의 수
		human = new int[N + 1];
		vid = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList.put(i, new ArrayList<>());
			vid[i] = i;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			human[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int adjNum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < adjNum; j++) {
				adjList.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		subs(1, new ArrayList<>(), new ArrayList<>());
		// comb로 정점의 개수
	}
}
