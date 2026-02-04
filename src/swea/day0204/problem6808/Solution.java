package swea.day0204.problem6808;
import java.io.*;
import java.util.*;
/*
 * 강사님이 알려주신 풀이법으로 풀었다.
 */
public class Solution {
	static int []A ;
	static int []B;
	static int []target;
	static boolean []visited;
	static int winA=0;
	static int factorial(int n) {
		if(n==1)
			return 1;
		return n * factorial(n-1);
	}
	static void perm(int depth) {
		if(depth==9) {
			int sumA=0;
			int sumB=0;
			for(int i=0;i<9;i++) {
				if(A[i]>target[i])
					sumA+= A[i] + target[i];
				else sumB+= A[i] +target[i];
			}
			if(sumA>sumB)
				winA+=1;
			return;
		}
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				target[depth] = B[i];
				perm(depth+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int totalRound = factorial(9);
		for(int tc=1;tc<=T;tc++) {
			st =new StringTokenizer(br.readLine());
			
			A = new int[9];
			B = new int[9];
			target = new int[9];
			visited = new boolean[9];
			winA=0;
			
			for(int i=0;i<9;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			int size=0;
			for(int i=1;i<19;i++) {
				boolean flag = true;
				for(int j=0;j<9;j++) {
					if(A[j]==i) flag = false; //A가 해당 카드를 가지고 있을떄
				}
				if(flag) B[size++] = i;
			}
			perm(0);
			sb.append("#").append(tc).append(" ")
			.append(winA).append(" ")
			.append(totalRound-winA)
			.append("\n");
		}
		System.out.println(sb);
	}
}
