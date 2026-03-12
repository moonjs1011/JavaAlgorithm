package baekjoon.month03.week02.day0311.problem9251;

import java.io.*;
import java.util.*;
public class Main {
    static int[][] cached;
    static boolean[][] isCached;
    static int N,M;
    static String str1,str2;
    static int LCS(int i,int j){
        if(i==N||j==M)
            return 0;

        if(!isCached[i][j]){
            isCached[i][j]=true;
            if(str1.charAt(i)==str2.charAt(j)){
                cached[i][j]=1 + LCS(i+1,j+1);
            }
            else {
                cached[i][j] = Math.max(LCS(i + 1, j), LCS(i, j + 1));
            }
        }
        return cached[i][j];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        str1 = st.nextToken();
        st =new StringTokenizer(br.readLine());
        str2 = st.nextToken();

        N = str1.length();
        M = str2.length();

        isCached = new boolean[N+1][M+1];
        cached = new int[N+1][M+1];
        System.out.println(LCS(0,0));
    }
}
