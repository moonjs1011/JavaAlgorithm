package swea.month02.week01.day0203.problem1233;

import java.io.*;
import java.util.*;

public class Solution {
	static boolean isDecial(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) < '0' || s1.charAt(i) > '9')
				return false;
		}
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) < '0' || s2.charAt(i) > '9')
				return false;
		}
		return true;
	}

	static boolean isDecial(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			boolean flag = true;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String operator = st.nextToken();
				if("+-/*".contains(operator)) { // operator다
					if(st.countTokens()!=2) {
						flag=false; // 자식 노드가 2개가 아니면? 
					}
				}
				else {
					if(st.countTokens()!=0) {
						flag=false;
					}
				}
				if(!flag) {
					for(int node = i+1;node<=N;node++) br.readLine();
					break;
				}
				
			}
			if (flag)
				sb.append("#").append(tc).append(" ").append(1).append("\n");
			else 
				sb.append("#").append(tc).append(" ").append(0).append("\n");

		}
		System.out.println(sb);
	}

}
