package baekjoon.month03.week01.day0304.problem17406;

import java.io.*;
import java.util.*;
/*
 * 1. K개의 연산 순서를 부분 조합을 구할 것
 * 2. 1에서 구한 부분 조합으로 배열을 돌리고 최솟값을 구할 것
 */
public class Main {
	static int[][]matrix,tempMatrix;
	static int[][] op;
	static int N,M,K;
	static void shift(int r,int c,int s) {

			for(int depth=1;depth<=s;depth++) {
				int startY = r - depth;
				int startX = c - depth;
				for(int j=1;j<=depth;j++) {
					startX+=1;
					tempMatrix[startY][startX] = matrix[startY][startX-1];
				}
				for(int i=1;i<=depth;i++) {
					startY+=1;
					tempMatrix[startY][startX] = matrix[startY-1][startX];
				}
				for(int j=1;j<=depth;j++) {
					startX-=1;
					tempMatrix[startY][startX] = matrix[startY][startX+1];
				}
				for(int i=1;i<=depth;i++) {
					startY-=1;
					tempMatrix[startY][startX] = matrix[startY+1][startX];
				}
			}
			
	}
	
	//K가 max 6이라 O(2^6)time -> 시간적으로 괜찮음
	static void subs(int index,List<int[]> list) {
		if(index ==K) {
			for(int[] info : list) {
				System.out.println(Arrays.toString(info));
			}
			for(int[] info : list) {
				tempMatrix = new int[N][M];
				for(int i=0;i<N;i++)
				tempMatrix[i]= Arrays.copyOf(matrix[i],0);
				int r =info[0];
				int c = info[1];
				int s = info[2];
				shift(r, c, s);
			}
			for(int[] e : tempMatrix)
				System.out.println(Arrays.toString(e));
				System.out.println();
			return;
		}
		list.add(op[index]);
		subs(index+1,list);//op[index]연산을 리스트에 넣음
		list.remove(list.size()-1);
		subs(index+1,list);//op[index]의 연산을 건너뜀
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][M];
		op = new int[K][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			int s =Integer.parseInt(st.nextToken());
			op[i] = new int[] {r-1,c-1,s};
		}
		subs(0,new ArrayList<>());
		
	}
}
