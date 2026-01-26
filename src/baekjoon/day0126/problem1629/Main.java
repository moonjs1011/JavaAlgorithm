package baekjoon.day0126.problem1629;

import java.io.*;
import java.util.*;
/*
 * 4 4 3
 * 4 2 3
 * 4 1 3
 * 4 
 * bottom-up
 */
public class Main {
	
	static long cal(int a, int b,int c) {
		if(b==1)
			return a;
		else if(b%2==0) {
			return cal(a%c,b/2%c,c) * cal(a%c,b/2%c,c);
		}
		else {
			return cal(a%c,b/2%c,c) * cal(a%c,b/2%c,c) * a%c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		int c =Integer.parseInt(st.nextToken());
		long res = cal(a,b,c);
		StringBuilder sb =new StringBuilder();
		sb.append(res);
		System.out.println(sb);
		
	}

}
