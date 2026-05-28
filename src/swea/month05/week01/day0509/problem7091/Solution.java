package swea.month05.week01.day0509.problem7091;

import java.io.*;
import java.util.*;

public class Solution {
    static int H,W,N,M;

    static char[][] gridE;
    static char[][] gridT;

    static int[] dy ={-1,0,1,0};
    static int[] dx ={0,-1,0,1};

    static boolean bfs(int y,int x){
        boolean[][] visited = new boolean[N][M];
        int hit=1;
        int totalHit = H*W;
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x]=true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]info = q.poll();
            int cy = info[0];
            int cx = info[1];
            if(totalHit==hit) return true;
            for(int i=0;i<4;i++){
                int ny = cy +dy[i];
                int nx = cx + dx[i];
                if(ny>=0 && ny<N && nx>=0 && nx<M && !visited[ny][nx] ){
                    if(gridE[ny][nx] == gridT[ny][nx]){
                        visited[ny][nx]= true;
                        q.offer(new int[]{ny,nx});
                        hit+=1;
                    }
                    else return false;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            String[] tokens = br.readLine().split(" ");

            H = Integer.parseInt(tokens[0]);
            W = Integer.parseInt(tokens[1]);
            N = Integer.parseInt(tokens[2]);
            M = Integer.parseInt(tokens[3]);

            gridE = new char[H][W];
            gridT = new char[N][M];
            for(int i=0;i<H;i++){
                String line = br.readLine();
                for(int j=0;j<W;j++){
                    gridE[i][j] = line.charAt(j);
                }
            }
            for(int i=0;i<N;i++){
                String line = br.readLine();
                for(int j=0;j<M;j++){
                    gridT[i][j] = line.charAt(j);
                }
            }

            int ans =0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(gridE[i][j]==gridT[i][j]){
                        if(bfs(i,j)) ans+=1;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
