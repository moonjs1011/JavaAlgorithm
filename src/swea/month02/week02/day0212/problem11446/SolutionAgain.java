package swea.month02.week02.day0212.problem11446;

import java.io.*;
import java.util.*;

public class SolutionAgain {
    static long[] candy;
    static long calculate(long K){
        long sum = 0;
        for (long c : candy) sum += c / K;
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            candy = new long[N];
            st = new StringTokenizer(br.readLine());
            long maxValue = 0;
            for (int i = 0; i < N; i++) {
                candy[i] = Long.parseLong(st.nextToken());
                maxValue = Math.max(maxValue, candy[i]);
            }
            long s = 1;
            long l = maxValue;
            long ans = 0;
            while(s<=l){
                long K = (s+l)/2;
                if(K==0) break;

                long sum = calculate(K);
                if(sum>=M) {
                    s = K + 1;
                    ans = K;
                }
                else
                    l = K-1;

            }
            String format = String.format("#%d %d\n",tc,ans);
            sb.append(format);
        }
        System.out.println(sb);


    }
}
