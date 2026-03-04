package swea.month03.week01.day0304.problem2105;

import java.io.*;
import java.util.*;

public class Solution {
	// 0 : 좌하 1 : 우하 : 2 : 좌상 ,3 : 우상
	static int[] dy = {1,1,-1,-1}; 
	static int[] dx = {1,-1,-1,1};
	
	static int[][] matrix;
	static int[][] visited;
	static boolean[] desert;
	static int maxCnt,N;
	static void dfs(int starty,int startx,int y,int x, int dir,int sumCnt) {
		if(starty==y && startx==x && dir ==3) {
			maxCnt = Math.max(maxCnt, sumCnt);
			return;
		}
		if(dir==4) return;
		if(desert[matrix[y][x]]) return; //이미 방문한 디저트 카페임
		int ny = y+dy[dir];
		int nx = x+dx[dir];
		if(ny>=0 && ny<N &&nx>=0&&nx<N) {
			desert[matrix[y][x]]=true;
			dfs(starty,startx,ny,nx,dir,sumCnt+1);
			dfs(starty,startx,ny,nx,dir+1,sumCnt+1);
			desert[matrix[y][x]]=false;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			matrix= new int[N][N];
			desert = new boolean[101];
			maxCnt=-1;
			for(int i=0;i<N;i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());	
				for(int j=0;j<N;j++) 																														{
				matrix[i][j] = Integer.parseInt(st.nextToken());	
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dfs(i,j,i,j,0,0);
				}
			}
			sb.append("#").append(tc).append(" " ).append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}
}
