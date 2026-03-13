package swea.month03.week02.day0312.problem2819;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {
	static int[][] grid;
	static int[]dy = {-1,0,1,0};
	static int[]dx = {0,-1,0,1};
	static int SIZE=4;
	static Map<String,Integer> map; 
	static void dfs(int y,int x, int depth,String str) {
		if(depth==7) {
			map.put(str, map.getOrDefault(str, 0)+1);
			return;
		}
		for(int d=0;d<SIZE;d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny>=0 && ny<SIZE&& nx>=0 &&nx<SIZE) {
				String temp = str;
				str+= grid[ny][nx];
				dfs(ny,nx,depth+1,str);
				str = temp;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			map = new HashMap<>();
			grid = new int[SIZE][SIZE];
			
			for (int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<SIZE;j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					dfs(i,j,0,"");
				}
			}
			Set<String> keys = map.keySet();
			System.out.println("#"+tc+" "+keys.size());
		}
	}
}
