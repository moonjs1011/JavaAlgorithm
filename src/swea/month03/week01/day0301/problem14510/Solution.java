package swea.month03.week01.day0301.problem14510;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            int cnt1 = 0;
            int cnt2 = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int peek = arr[N-1];
            for(int i=0;i<N-1;i++){
               int diff = peek - arr[i];
               if(diff==0) continue;
               cnt1+=diff%2;
               cnt2+=diff/2;
            }
            while(cnt2>cnt1+1){
                cnt2-=1;
                cnt1+=2;
            }
            int ans = -1;
            if(cnt1>cnt2){
                ans = 2*cnt1-1;
            }
            else if(cnt2>cnt1){
                ans = 2*cnt2;
            }
            else{
                ans = cnt1+cnt2;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);

    }
}
