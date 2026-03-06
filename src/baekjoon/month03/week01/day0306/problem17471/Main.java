package baekjoon.month03.week01.day0306.problem17471;

import java.io.*;
import java.util.*;

public class Main {
	static int N,totalHuman;
	static Map<Integer,List<Integer>> G = new HashMap<>();
	static boolean[] check;
	static int[] human;
	static int minHuman;
	static boolean bfs(List<Integer>li) {
		boolean[] visited = new boolean[N+1];
		int vid = li.get(0);
		Queue<Integer> q = new ArrayDeque<>();
		visited[vid]=true;
		q.offer(vid);
		int cnt=0;
		while(!q.isEmpty()) {
			int curVid = q.poll();
			if(!li.contains(curVid)) continue;
			cnt+=1;
			for(int nextVid : G.get(curVid)) {
				if(!visited[nextVid]) {
					visited[nextVid]=true;
					q.offer(nextVid);
				}
			}
		}
		return cnt==li.size();
	}
	static void subs(int index,List<Integer>li1,List<Integer>li2) {
		if(index>N) {
			if(li1.size()>=1 && li2.size()>=1) {
				if(bfs(li1)&&bfs(li2)) {
					int sum1 = 0;
					int sum2 =0;
					for(int vid : li1) sum1+=human[vid];
					for(int vid : li2) sum2+=human[vid];
					minHuman = Math.min(minHuman, Math.abs(sum1-sum2));
				}
			}
			return;
		}
		li1.add(index);
		subs(index+1,li1,li2);
		li1.remove(li1.size()-1);
		li2.add(index);
		subs(index+1,li1,li2);
		li2.remove(li2.size()-1);
			
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		N = Integer.parseInt(br.readLine());
		
		check =new boolean[N+1];
		human = new int[N+1];
		for(int i=1;i<=N;i++)  G.put(i, new ArrayList<>());

		st =new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			human[i] = Integer.parseInt(st.nextToken());
			totalHuman+=human[i];
		}
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
		int adjCnt = Integer.parseInt(st.nextToken());
		for(int j=1;j<=adjCnt;j++) {
			G.get(i).add(Integer.parseInt(st.nextToken()));
		}	
		}
		minHuman = Integer.MAX_VALUE;
		subs(1,new ArrayList<>(),new ArrayList<>());
		if(minHuman== Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minHuman);
	}
}
