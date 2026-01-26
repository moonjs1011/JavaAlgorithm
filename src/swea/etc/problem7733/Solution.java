package swea.etc.problem7733;
import java.io.*;
import java.util.*;
/*
DFS?
day1에 따라 masking을 한다.
필요한 자료구조
map[][] : int 맛을 저장 먹었으면 0으로 바꿈
logic:
    for-loop으로 day를 늘려가면서 masking
    Dfs.
    다시 masking

 */
public class Solution {
    static int []dy ={-1,0,1,0};
    static int []dx ={0,-1,0,1};
    static int [][]map;
    static boolean [][]visited;
    static int maxPieces;

    static void dfs(int y,int x,int N){
        if(visited[y][x])
            return;
        visited[y][x]=true;
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx = x + dx[i];
            if(ny>=0 && ny<N && nx>=0 && nx<N && map[ny][nx]!=0){//rangeCheck
                dfs(ny,nx,N);
            }
        }
    }
    public static void main(String [] args) throws IOException{
        System.setIn(new FileInputStream("src/swea/problem7733/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            int  N = Integer.parseInt(st.nextToken());

            map = new int[N][N];//초기화
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxPieces = 1;
            //algorithm 수행
            for(int day=1;day<100;day++){
                visited = new boolean[N][N];//초기화
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(map[i][j]==day) map[i][j]=0; //먹음 표시
                    }
                }
                int pieces=0;
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(!visited[i][j]&&map[i][j]!=0) {
                            dfs(i,j,N);
                            pieces+=1;
                        }
                    }
                }
                maxPieces = Math.max(maxPieces,pieces);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(maxPieces);
            System.out.println(sb);
        }

    }
}
