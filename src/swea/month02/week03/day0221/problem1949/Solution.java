package swea.month02.week03.day0221.problem1949;

import java.io.*;
import java.util.*;

/*
 *  N by N 입력 받기
   ① 등산로는 가장 높은 봉우리에서 시작해야 한다.
   -> 가장 높은 지점을 저장해야함 -> 여러개 나올 수 있음, List로 관리
   ② 등산로는 산으로 올라갈 수 있도록 반드시 높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결이 되어야 한다.
       즉, 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능하다.
    -> 반드시 높은 지점에서 낮은 곳으로만 갈 수 있다.
   ③ 긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.

N * N 크기의 지도가 주어지고, 최대 공사 가능 깊이 K가 주어진다.

이때 만들 수 있는 가장 긴 등산로를 찾아 그 길이를 출력하는 프로그램을 작성하라.
 */
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Solution {
    static int[] dy ={-1,0,1,0};
    static int[] dx = {0,-1,0,1};
    static int N, K;
    static int[][] matrix;
    static List<Point> peek;//높은 지점 저장
    static int maxDepth;
    static void bfs(int y,int x){
        int[][] dict =new int[N][N];
        dict[y][x]=1;

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(y,x));
        while(!q.isEmpty()){
            Point point = q.poll();
            int cy = point.y;
            int cx = point.x;
            maxDepth = Math.max(maxDepth,dict[cy][cx]); //maxDepth도 bfs 로직안에서 갱신
            for(int i=0;i<4;i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny>=0 && ny<N && nx>=0 && nx<N
                        && matrix[cy][cx]>matrix[ny][nx]
                        &&dict[ny][nx]<dict[cy][cx]+1){
                    dict[ny][nx] = dict[cy][cx]+1;
                    q.offer(new Point(ny,nx));
                }
            }
        }


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            matrix = new int[N][N];
            peek = new ArrayList<>();
            int maxHeight =0;
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());

                    //입력과 동시에 peek점 찾는 로직 추가
                    if(matrix[i][j]==maxHeight){
                        peek.add(new Point(i,j));
                    }
                    else if(matrix[i][j]>maxHeight){
                        peek.clear();//밀어버리고, 다시 넣기
                        peek.add(new Point(i,j));
                        maxHeight = matrix[i][j];
                    }
                }
            }
            maxDepth=0;
            for(int i1=0;i1<N;i1++){
                for(int j1=0;j1<N;j1++){
                    for(int dk=0;dk<K;dk++){ //1씩 줄여가며 bfs 수행
                        matrix[i1][j1]-=1;
                        for(Point p : peek){
                            bfs(p.y,p.x);
                        }
                    }
                    matrix[i1][j1] += K; //복원
                }
            }
            sb.append("#").append(tc).append(" ").append(maxDepth).append("\n");
        }
        System.out.print(sb);
    }
}
