package baekjoon.day0207.problem7523;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int sum = (N + M) * (M-N+1)/2;
        sb.append("Scenario #").append(tc).append(":\n").append(sum).append("\n\n");
        }
        System.out.println(sb);
    }
}
