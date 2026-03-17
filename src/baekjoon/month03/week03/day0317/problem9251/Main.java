package baekjoon.month03.week03.day0317.problem9251;

import java.io.*;
import java.util.*;
public class Main {
	static String str1,str2;
	static boolean isCached[][];
	static int cachedValue[][];
	static int LCS(int i,int j) {//O(N X M)time
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
		str1 = br.readLine();
		str2 = br.readLine();
		
		//N = str1의 길이, M = str2의 길이
		isCached = new boolean[str1.length()][str2.length()];//O(N X M) space
		cachedValue = new int[str1.length()][str2.length()]; //O(N X M) space
		
		int len = LCS(0,0);
		System.out.println(len);
	}

}

