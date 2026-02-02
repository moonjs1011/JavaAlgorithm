package swea.day0202.problem1226;
import java.io.*;
import java.util.*;
/*
 * 입력은 16 x 16 고정
 * start point = 1,1
 * end point = 13,3
 */
public class Solution {
	static int[]dy = {-1,0,1,0};
	static int[]dx = {0,-1,0,1};
	
	static int[][] matrix;
	static boolean[][] visited;
	
	static byte ans =0;
	
	static void dfs(int y,int x) {
		if(visited[y][x])
			return;
		
		if(matrix[y][x]==3) {
			ans=1;
			return;
		}
		visited[y][x]=true;
		for(int i=0;i<4;i++) {
			int ny = y+ dy[i];
			int nx = x+ dx[i];
			if(ny>=0 && ny<16 && nx>=0 && nx<16) {
				if(!visited[ny][nx]&&matrix[ny][nx]!=1) {
					dfs(ny,nx);
				
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()); //dummy input
			
			matrix = new int[16][16]; //init
			visited = new boolean[16][16]; // init
			ans=0;

			for(int i=0;i<16;i++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for(int j=0;j<16;j++) {
					matrix[i][j] = line.charAt(j)-'0';
				}
			}
		
			dfs(1,1);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}

}
