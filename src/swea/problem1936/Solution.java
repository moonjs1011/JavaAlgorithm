package swea.problem1936;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if(A==1){
            if(B==2)
                System.out.println("A");
            else System.out.println("B");
        }
        if(A==2){
            if(B==1)
                System.out.println("B");
            else System.out.println("A");
        }
        if(A==3){
            if(B==1) System.out.println("B");
            else System.out.println("A");
        }

    }
}
