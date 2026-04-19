package swea.month04.week03.day0418.problem1288;

import java.io.*;

public class Solution {
    static boolean check(boolean[] visited){
        for(int i=0;i<visited.length;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    static int count(int N){
        boolean [] visited  = new boolean[10]; // 0~9;
        String str = String.valueOf(N);
        int cnt=0;
        int di = 1;
        while(!check(visited)){
//            System.out.println(str);
            for(int i=0;i<str.length();i++){
                visited[str.charAt(i)-'0'] = true;
            }

            str  = String.valueOf(N*di);
            di+=1;
            cnt+=1;
        }
        return Integer.parseInt(str)-N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            int N = Integer.parseInt(br.readLine());
            System.out.println("#"+tc+" "+count(N));
        }

    }
}
