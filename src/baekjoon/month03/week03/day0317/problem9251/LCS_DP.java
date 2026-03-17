package baekjoon.month03.week03.day0317.problem9251;

import java.io.*;
import java.util.*;
public class LCS_DP {
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
	static boolean isCached[][];
	static int cachedValue[][];
	
	static int LCS(int i,int j) {
		if(i == str1.length() || j == str2.length()) return 0;
		
		if(!isCached[i][j]) {
			isCached[i][j] =true;
			if(str1.charAt(i) == str2.charAt(j)) {
				cachedValue[i][j] = 1+ LCS(i+1,j+1);
			}
			else {
				cachedValue[i][j] = Math.max(LCS(i+1,j), LCS(i,j+1));
			}
		}
		return cachedValue[i][j];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(str1);
		System.out.println(str2);
		isCached= new boolean[str1.length()][str2.length()];
		cachedValue = new int[str1.length()][str2.length()];
		long start = System.currentTimeMillis();
		int len = LCS(0, 0);
		System.out.println(len);
		long end = System.currentTimeMillis();
		System.out.println("memorization 있는 풀이 시간 : "+(end-start)+"ms");
	}

}

