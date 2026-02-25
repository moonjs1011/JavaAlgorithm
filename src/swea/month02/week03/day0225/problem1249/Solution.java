package swea.month02.week03.day0225.problem1249;

import java.io.*;
import java.util.*;

public class Solution {
	static int[] dy= {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static int[][]matrix;
	static int N;
	static int dijk(int y,int x) {
		int [][]dict = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(dict[i], Integer.MAX_VALUE);
		}
		dict[y][x]=0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cy = info[0];
			int cx = info[1];
			int cCost = dict[cy][cx];
			for(int i=0;i<4;i++) {
				int ny = cy+dy[i];
				int nx = cx +dx[i];
				if(ny>=0 && ny<N && nx>=0 && nx<N && dict[ny][nx]>dict[cy][cx]+matrix[cy][cx]) {
					dict[ny][nx] = dict[cy][cx]+matrix[cy][cx];
					q.offer(new int[] {ny,nx});
				}
			}
		}
		return dict[N-1][N-1];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			for(int i=0;i<N;i++) {
				String line = br.readLine();
				for(int j=0;j<N;j++) {
					matrix[i][j] = line.charAt(j)-'0';
				}
			}
			System.out.printf("#%d %d\n",tc,dijk(0, 0));
		}
	}
}
