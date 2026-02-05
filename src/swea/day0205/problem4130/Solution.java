package swea.day0205.problem4130;
import java.io.*;
import java.util.*;
/*
 * Rotate은 한번에 진행한다.
 * Rotate를 할지 안할지를 재귀를 통하여 탐색한다.
 * 
 */
public class Solution {
	static final int MAGCNT=4;
	static final int BLADECNT=8;
	static int[][]arr;
	static int[]rotateInfo;

	static void seeLeft(int index,int direction) {
		if(index<=1) return;
		
		if(arr[index-1][2]!=arr[index][6]) {
			rotateInfo[index-1] = -direction;
			seeLeft(index-1,-direction);
		}
	}

	static void seeRight(int index,int direction) {
		if(index>=4) return;
		
		if(arr[index][2]!=arr[index+1][6]) {
			rotateInfo[index+1] = -direction;
			seeRight(index+1,-direction);
		}
	}
	static void rotateLeft(int index) {
		int temp = arr[index][0];
		for(int i=0;i<BLADECNT-1;i++)
			arr[index][i] = arr[index][i+1];
		arr[index][BLADECNT-1] = temp;
	}
	static void rotateRight(int index) {
		int temp = arr[index][BLADECNT-1];
		for(int i = BLADECNT-1;i>0;i--) {
			arr[index][i] = arr[index][i-1];
		}
		arr[index][0] = temp;
	}
	static void rotate() {
		for(int i=1;i<=MAGCNT;i++) {
			if(rotateInfo[i]==1) rotateRight(i);
			else if(rotateInfo[i]==-1) rotateLeft(i);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			//톱니바퀴 정보 입력
			arr = new int[MAGCNT+1][BLADECNT]; // index를 맞춰주기 위해 MAGCNT+1
			for(int i=1;i<=MAGCNT;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<BLADECNT;j++) {
					 arr[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<K;i++) {
				rotateInfo = new int[MAGCNT+1];
				st = new StringTokenizer(br.readLine());
				int magIdx = Integer.parseInt(st.nextToken()); //자석 index
				int direction = Integer.parseInt(st.nextToken()); //회전 방향
				rotateInfo[magIdx] = direction;
				seeLeft(magIdx,direction);
				seeRight(magIdx,direction);
				rotate();
			}
			int sum=0;
			for(int i=1;i<=MAGCNT;i++) {
				sum+= Math.pow(2, i-1) * arr[i][0];
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
	}
}
