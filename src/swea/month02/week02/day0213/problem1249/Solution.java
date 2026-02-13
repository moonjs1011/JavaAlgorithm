package swea.month02.week02.day0213.problem1249;

import java.io.*;
import java.util.*;
public class Solution {
	static int[] dy= {-1,0,1,0};
	static int[] dx= {0,-1,0,1};
	static int[][]matrix;
	static boolean[][]visited;
	static int  N;
	static int bfs(int y,int x) {
		int [][]dict =new int[N][N]; 
		for(int i=0;i<N;i++) Arrays.fill(dict[i],Integer.MAX_VALUE);
		dict[0][0]=0;
		
		ArrayDeque<int[]> pq = new ArrayDeque<>();
		visited[y][x]=true;
		pq.offer(new int[] {y,x});
		while(!pq.isEmpty()) {
			int[] cyx = pq.poll();
			int cy = cyx[0];
			int cx = cyx[1];
			int cCost = dict[cy][cx];
			for(int i=0;i<4;i++) {
				int ny =cy + dy[i];
				int nx = cx + dx[i];
				if(ny>=0 && ny<N && nx>=0 && nx<N&&dict[ny][nx]>cCost+matrix[ny][nx]) {
					dict[ny][nx] = cCost + matrix[ny][nx];
					pq.offer(new int[] {ny,nx});
				}
			}
		}

		return dict[N-1][N-1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N =Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for(int j=0;j<N;j++) {
					matrix[i][j] = line.charAt(j)-'0';
				}
			}
			String format = String.format("#%d %d\n",tc,bfs(0,0));
			sb.append(format);
		}
		System.out.println(sb);
	}
}
