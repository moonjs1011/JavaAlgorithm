package swea.month02.week03.day0218.problem1486;

import java.io.*;
import java.util.*;

public class Solution {
    static int N, B, minHeight;
    static int[] height;

    static void subs(int index, int sumHeight) {
        if (index == N) {
            if (sumHeight >= B) {
                minHeight = Math.min(minHeight, sumHeight);
            }
            return;
        }
        subs(index + 1, sumHeight + height[index]);
        subs(index + 1, sumHeight);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            minHeight = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            height = new int[N];
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            subs(0,0);
            String format = String.format("#%d %d\n",tc,minHeight-B);
            sb.append(format);
        }
        System.out.println(sb);

    }
}
