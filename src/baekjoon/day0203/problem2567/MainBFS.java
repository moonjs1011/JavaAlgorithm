package baekjoon.day0203.problem2567;
import java.io.*;
import java.util.*;

public class MainBFS {
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static int MAXSIZE =101;
	static int[][] matrix= new int[MAXSIZE][MAXSIZE];
	static boolean[][] visited= new boolean[MAXSIZE][MAXSIZE];
	static int ans=0;
	
	static void bfs(int y,int x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[y][x]=true;
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int []c = q.poll();
			int cy = c[0]; int cx = c[1];
			for(int i=0;i<4;i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny<0 || ny>=MAXSIZE || nx<0 || nx>=MAXSIZE || matrix[ny][nx]==0)
					ans+=1;
				if(!visited[ny][nx] && matrix[ny][nx]==1) {
					visited[ny][nx]=true;
					q.offer(new int[] {ny,nx});
				}
					
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));	
	StringTokenizer st =new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken());
	while(N-->0) {
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		for(int i=y;i<y+10;i++) {
			for(int j=x;j<x+10;j++) {
				matrix[i][j]=1; //masking
			}
		}
	}
	for(int i=0;i<MAXSIZE;i++) {
		for(int j=0;j<MAXSIZE;j++) {
			if(!visited[i][j] && matrix[i][j] == 1) {
				bfs(i,j);
			}
		}
	}
	System.out.println(ans);

	}

}
