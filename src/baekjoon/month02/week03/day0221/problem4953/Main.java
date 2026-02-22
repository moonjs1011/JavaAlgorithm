package baekjoon.month02.week03.day0221.problem4953;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int w,h;
    static int[][]matrix;
    static boolean[][]visited;

    static void bfs(int y,int x){
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x]=true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[] info = q.poll();
            int cy = info[0];
            int cx = info[1];
            for(int i=0;i<8;i++){
                int ny = cy+dy[i];
                int nx = cx+dx[i];
                if(ny>=0 && ny<h && nx>=0 && nx<w && matrix[ny][nx]==1&&!visited[ny][nx]){
                    visited[ny][nx]=true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        while(w!=0 && h!=0){
            matrix = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0;i<h;i++){
                st =new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int islandCnt=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(matrix[i][j]==1 && !visited[i][j]){
                        bfs(i,j);
                        islandCnt+=1;
                    }
                }
            }
            sb.append(islandCnt).append("\n");

            st =new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
}
