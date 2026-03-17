package baekjoon.month03.week03.day0317.problem9251;

import java.io.*;
import java.util.*;

public class LCS_Non_DP {
	static String str1="", str2="";
	
	static {
		Random random = new Random();
		for(int i=0;i<1000;i++) {
			int randomIndex = random.nextInt(26);
			char c= (char) ('A' + randomIndex);
			str1+=c;
		}
		for(int i=0;i<1000;i++) {
			int randomIndex = random.nextInt(26);
			char c= (char) ('A' + randomIndex);
			str2+=c;
		}
	}

	static int LCS(int i, int j) {
		if (i == str1.length() || j == str2.length())
			return 0;
		if (str1.charAt(i) == str2.charAt(j)) {
			return 1 + LCS(i + 1, j + 1);
		} else {
			return Math.max(LCS(i + 1, j), LCS(i, j + 1));
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(str1);
		System.out.println(str2);
		long start = System.currentTimeMillis();
		int len = LCS(0, 0);
		System.out.println(len);
		long end = System.currentTimeMillis();
		System.out.println("memorization 없는 풀이 시간 : "+(end-start)+"ms");
	}

}
