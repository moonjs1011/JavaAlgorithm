package baekjoon.month03.week05.day0303.problem1149;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] red = new int[N];
        int[] green = new int[N];
        int[] blue = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }
        int[] cost = new int[N+1];
        int[] color = new int[N];//0 : red , 1 : green , 2 : blue
        Arrays.fill(color,-1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (color[i]!=color[i+1]){

                }
            }
        }
    }
}
