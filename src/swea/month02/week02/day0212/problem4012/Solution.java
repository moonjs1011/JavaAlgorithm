package swea.month02.week02.day0212.problem4012;
import java.io.*;
import java.util.*;
/*
 * 1.음식 정보를 저장하는 테이블 생성
 * 2. (i1,j1) 고정 (i2,j2),(i3,j3)...
 * 3. (i2,j2) 고정 (i3,j3),(i4,j4)...
 */
public class Solution {
	static int[][] matrix;
	static boolean[] visited;
	static int N,minValue;
	static void comb(int start,int depth) {
		if(depth==N/2) {
			System.out.println(Arrays.toString(visited));
			calc();
			return;
		}
		for(int i=start;i<N;i++) {
			visited[i] =true;
			comb(i+1,depth+1);
			visited[i]=false;
		}
	}
	static void calc() {
		int valueA= 0;
		int valueB=0;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(visited[i]&&visited[j]) valueA+=matrix[i][j] +matrix[j][i];
				else if(!visited[i] &&!visited[j]) valueB+=matrix[i][j] +matrix[j][i];
			}
		}
		minValue = Math.min(minValue, Math.abs(valueA-valueB));
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minValue = Integer.MAX_VALUE;
			comb(0,0);
			sb.append("#").append(tc).append(" ").append(minValue).append("\n");
		}
		System.out.println(sb);
	}
}
