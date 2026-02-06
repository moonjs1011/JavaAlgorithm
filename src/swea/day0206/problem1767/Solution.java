package swea.day0206.problem1767;
import java.io.*;
import java.util.*;
/*
 * 전선은 직선으로만 설치 가능
 * 
 */
public class Solution {
	static int N;
	static int[][]matrix;
	static List<int[]> posInfo;
	static List<int[]> targetInfo; //좌표들의 순열을 저장하는 List;
	static boolean[] visited;
	static int minCnt=Integer.MAX_VALUE;
	static int cnt=0;
	static void go(int y,int x,int index) {
		if(index==N)
			return;
		goLeft(y,x,index);
		goRight(y,x,index);
		goUp(y,x,index);
		goDown(y,x,index);
		minCnt = Math.min(minCnt, cnt);
	}
	static void goLeft(int y,int x,int index) {
		if(matrix[y][x]!=0) 
			return;
		if(x==0) {
			if(index==posInfo.size()-1)
				return;
			go(posInfo.get(index+1)[0],posInfo.get(index)[1],index+1);
			return;
		}
		cnt+=1;
		matrix[y][x]=1;
		goLeft(y,x-1,index);
		matrix[y][x]=0;
	}
	static void goRight(int y,int x,int index) {
		if(matrix[y][x]!=0) 
			return;
		if(x==N-1) {
			if(index==posInfo.size()-1)
				return;
			go(posInfo.get(index+1)[0],posInfo.get(index)[1],index+1);
			return;
		}
		cnt+=1;
		matrix[y][x]=1;
		goRight(y,x+1,index);
		matrix[y][x]=0;
	}
	static void goUp(int y,int x,int index) {
		if(matrix[y][x]!=0) 
			return;
		if(y==0) {
			if(index==posInfo.size()-1)
				return;
			go(posInfo.get(index+1)[0],posInfo.get(index)[1],index+1);
			return;
		}
		cnt+=1;
		matrix[y][x]=1;
		goUp(y-1,x,index);
		matrix[y][x]=0;
	}
	static void goDown(int y,int x,int index) {
		if(matrix[y][x]!=0) 
			return;
		if(y==N-1) {
			if(index==posInfo.size()-1)
				return;
			go(posInfo.get(index+1)[0],posInfo.get(index)[1],index+1);
			return;
		}
		cnt+=1;
		matrix[y][x]=1;
		goDown(y+1,x,index);
		matrix[y][x]=0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=T;tc++) {
			st =new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			matrix = new int[N][N];
			posInfo = new ArrayList<>();
			targetInfo = new ArrayList<>();
			visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				st =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					matrix[i][j] =Integer.parseInt(st.nextToken());
					if(i!=0 && i!=N-1 && j!=0 && j!=N-1 &&matrix[i][j]==1) { //가장 자리를 제외한 core의 좌표 저장
						posInfo.add(new int[] {i,j});
					}
				}
			}	
				minCnt=0;
				go(posInfo.get(0)[0],posInfo.get(0)[1],0);
				System.out.println(minCnt);
		}
		

	}

}
