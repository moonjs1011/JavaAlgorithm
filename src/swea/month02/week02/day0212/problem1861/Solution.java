package swea.month02.week02.day0212.problem1861;
import java.io.*;
import java.util.*;
public class Solution {
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static int[][] matrix;
	static boolean[][] visited;
	static int N,roomNo,maxDepth=0;
	static void dfs(int startY,int startX,int y,int x,int depth) {
		if(maxDepth<depth) {
			maxDepth = depth;	
			roomNo = matrix[startY][startX];
		}
		else if(maxDepth==depth) {
			roomNo = Math.min(roomNo, matrix[startY][startX]);
		}
	
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x +dx[i];
			if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx] && (matrix[y][x]+1)==matrix[ny][nx]) {
				visited[ny][nx] = true;
				dfs(startY,startX,ny,nx,depth+1);
				visited[ny][nx]=false;
			}
		}
	 	
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			 N = Integer.parseInt(br.readLine());
			
			matrix = new int[N][N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxDepth=0;
			roomNo = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				visited = new boolean[N][N];
				for(int j=0;j<N;j++) {
					dfs(i,j,i,j,1);
				}
			}
			sb.append("#").append(tc).append(" ").append(roomNo).append(" ").append(maxDepth).append("\n");
		}
		System.out.println(sb);
	}
}
