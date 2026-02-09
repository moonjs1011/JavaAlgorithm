package baekjoon.month02.week01.day0204.problem15655;

import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] arr,target;
    static StringBuilder sb = new StringBuilder();

    static void comb(int start,int depth){
        if(depth==M){
            for(int ele : target) sb.append(ele+" ");
            sb.append("\n");
            return;
        }
        for(int i=start;i<N;i++){
            target[depth] = arr[i];
            comb(i+1,depth+1);
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        target = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        comb(0,0);

        System.out.println(sb);
    }
}
