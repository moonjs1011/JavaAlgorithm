package baekjoon.month03.week01.day0302.problem21611;

import java.io.*;
import java.util.*;

/*
 * Req1 : 사방 탐색,상 1, 하 2, 좌 3, 우 4
 * Req2 : 방향 di, 거리 si, 상어는 di방향으로 거리가 si이하인 모든
 * 칸에 얼음 파편을 던져 구슬을 파괴, 파괴되면 그 칸을 빈칸, 벽은 파괴 안됌
 * Req3 : 4개 이상 연속하는 구슬이 있으면 폭발(1,1,1,1),(2,2,2,2,2)
 *   Req2.1 : 방향 di를 정함
 *   Req2.2 : 거리 si를 정함
 *   Req2.3  di방향으로 거리가 si이하인 모든 칸에 얼음파편을 던뎌 구슬 파괴
 *   Req2.4 : 빈칸이 없도록 구슬을 옮김
 *   Req3.1 : 연속하는 구슬의 수가 4개 이상인지 확인
 *   Req3.2 : 해당 구간을 폭발시킴
 *   Req3.3 : 빈칸이 없도록 구슬을 옮김
 *   jmp Req3.1 until 더이상 폭발 안할때까지
 *
 *
 *
 */
public class Main {
    //Req1 사방 탐색,상 1, 하 2, 좌 3, 우 4
    static int[]dy ={0,-1,1,0,0};
    static int[]dx ={0,0,0,-1,1};
    static int[][] matrix;
    //
    static void blizard(int di,int si,int N){
        int cy = N/2;
        int cx = N/2;
        int cs=0;
        //Req2.3
        while(cs<=si){
            int ny = cy + dy[di];
            int nx = cx + dx[di];
            cs++;
            if(ny>=N || nx>=N) break;
            matrix[ny][nx]=0;//
        }
    }
    //Req2.4
    static void move(int y,int x,int N){
        //왼쪽 + depth <-N/2
        //아래 + detph
        //오른쪽 + depth+1
        //오른쪽 + depth+1
        for(int depth = 1; depth<=N/2;depth++){
            for(int dx=1;dx<=depth;dx++){
                int nx = --x;
                if(matrix[y][x]==0){

                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken()); //Req2.1
            int si = Integer.parseInt(st.nextToken()); //Req2.2
        }




    }
}
