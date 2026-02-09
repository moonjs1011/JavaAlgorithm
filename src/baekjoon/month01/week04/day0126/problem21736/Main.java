package baekjoon.month01.week04.day0126.problem21736;
import java.io.*;
import java.util.*;
public class Main {
	static char[][] matrix;
	static boolean[][]visited;
	static int []dy = {-1,0,1,0};
	static int []dx = {0,-1,0,1};
	static int N,M;
	static int iy,ix; //도연이의 좌표
	static int cnt=0;//cnt
	static void bfs(int y,int x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		visited[y][x]= true;
		while(!q.isEmpty()) {
			int[] cyx = q.poll();
			int cy = cyx[0];
			int cx = cyx[1];
			for(int i=0;i<4;i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny>=0 && ny<N &&nx>=0 && nx<M && !visited[ny][nx] && matrix[ny][nx]!='X') {
					visited[ny][nx]=true;
					q.offer(new int[]{ny,nx});
					if(matrix[ny][nx]=='P')
						cnt+=1;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new char[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<M;j++) {
				matrix[i][j] =str.charAt(j);
				if(matrix[i][j]=='I') {
					iy=i;
					ix=j;
				}
			}
		}
		bfs(iy,ix);
		StringBuilder sb = new StringBuilder();
		if(cnt==0) sb.append("TT");
		else sb.append(cnt);
		System.out.println(sb);
	}

}
