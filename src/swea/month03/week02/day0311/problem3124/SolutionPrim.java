package swea.month03.week02.day0311.problem3124;

import java.io.*;
import java.util.*;
public class SolutionPrim {
	static Map<Integer,List<int[]>> G;
	static int N,M;
	static long Prim(int vid) {
		long mst =0;
		int cnt=0;
		boolean[] visited = new boolean[N+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
		for(int[] info : G.get(vid)) {
			int dst = info[0];
			int weight = info[1];
			pq.offer(new int[] {dst,weight});
		}
		visited[vid]=true;
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int dst = info[0];
			int weight = info[1];
			if(visited[dst]) continue;
			visited[dst]=true;
			mst+=weight;
			cnt+=1;
			if(cnt==N-1) return mst;
			for(int[] edge : G.get(dst)) {
				int next = edge[0];
				int nextWeight = edge[1];
				if(!visited[next]) {
					pq.offer(new int[] {next,nextWeight});
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st= null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			G = new HashMap<>();
			for(int i=1;i<=N;i++) G.put(i, new ArrayList<>());
			for(int i=0;i<M;i++) {
				st= new StringTokenizer(br.readLine());
				int A  = Integer.parseInt(st.nextToken());
				int B  = Integer.parseInt(st.nextToken());
				int C  = Integer.parseInt(st.nextToken());
				
				G.get(A).add(new int[] {B,C});
				G.get(B).add(new int[] {A,C});
			}
			sb.append("#").append(tc).append(" ").append(Prim(1)).append("\n");
		}
		System.out.println(sb);
	}
}
