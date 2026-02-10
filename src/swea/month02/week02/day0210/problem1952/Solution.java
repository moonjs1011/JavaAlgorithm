package swea.month02.week02.day0210.problem1952;

import java.io.*;
import java.util.*;
public class Solution {
	static int[] prices,plan;
	static int minSum;
	static void subs(int index,int sum) {
		if(index>11) {
			minSum = Math.min(minSum, sum);
			return;
		}
		subs(index+1,sum+prices[0]*plan[index]);
		subs(index+1,sum+prices[1]);
		subs(index+3,sum+prices[2]);
		subs(index+13,sum+prices[3]);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			prices = new int[4];
			plan = new int[12];
			minSum=Integer.MAX_VALUE;
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			st =new StringTokenizer(br.readLine());
			for(int i=0;i<12;i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			subs(0,0);
			sb.append("#").append(tc).append(" ").append(minSum).append("\n");
		}
		System.out.println(sb);
	}
}
