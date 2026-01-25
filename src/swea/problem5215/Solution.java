package swea.problem5215;

import java.util.Scanner;

public class Solution {
    static int ans;
    static int N,L;
    static int [][]arr;
    static void combination(int index,int score,int calories){
        if(calories<=L)
            ans = Math.max(ans,score);
        else
            return;

        if(index==N)
            return;

        for(int i=index;i<arr.length;i++){
                combination(i+1, score+arr[i][0], calories+arr[i][1]);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            N = sc.nextInt();
            L = sc.nextInt();
            arr = new int[N][2];
            for(int i=0;i<N;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            ans = 0;
            for(int i=0;i<N;i++) {
                combination(i,0,0);
            }

            System.out.println("#"+test_case+" "+ans);

        }
    }
}
