package baekjoon.month02.week02.day0212.problem2630;

import java.io.*;
import java.util.*;

public class Main {
    static int N,whiteCnt,blueCnt;
    static boolean[][] board;

    static void divide(int y, int x, int size) {

        if(check(y,x,size)){
            if(board[y][x]) blueCnt+=1;
            else whiteCnt+=1;
            return;
        }
        int newSize = size/2;
        divide(y,x,newSize); //left-top
        divide(y,x+newSize,newSize); // right-top
        divide(y+newSize,x,newSize); // left-bottom
        divide(y+newSize,x+newSize,newSize); // right-bottom
    }

    static boolean check(int y,int x,int size) {
        int cnt = 0;
        boolean type = board[y][x];
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(type!=board[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken().equals("1");
            }
        }
        divide(0,0,N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }
}
