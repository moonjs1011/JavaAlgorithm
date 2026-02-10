package swea.month02.week02.day0210.problem2806;
import java.io.*;
import java.util.*;
public class Solution {
	static int[] col;
	static int N,totalCnt=0;
	static void setQueen(int row) {
		if(row>N) {
			totalCnt+=1;
			return;
		}
		for(int c=1;c<=N;c++) {
			col[row] = c;
			if(isAvailable(row)) {
				setQueen(row+1);
			}
				
		}
	}
	//(3,3)-> (2,2),(2,4),(4,2),(4,4)
	static boolean isAvailable(int r) {
		for(int i=1;i<r;i++) {
			if(col[i] == col[r]) return false;
			if(Math.abs(col[i]-col[r])==Math.abs(i-r)) 
				return false;
			
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			col = new int[N+1];
			totalCnt=0;
			setQueen(1);
			sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
		}
		System.out.println(sb);
		

	}

}
