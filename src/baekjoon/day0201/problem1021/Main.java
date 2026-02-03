package baekjoon.day0201.problem1021;
import java.io.*;
import java.util.*;
/*
 * 순형 큐, 빡구현
 *
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb =new StringBuilder();



        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] arr =new int[N];
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            arr[i] = i+1; // init
        }
        st = new StringTokenizer(br.readLine());
        int cnt=0;
        for(int i=0;i<M;i++){
            int pos = Integer.parseInt(st.nextToken());
            if(pos<N/2){

            }
        }

    }
}
