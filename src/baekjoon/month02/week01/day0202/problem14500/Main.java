package baekjoon.month02.week01.day0202.problem14500;
import java.io.*;
import java.util.*;
public class Main {
    static int[]dy ={-1,0,1,0};
    static int[]dx ={0,-1,0,1};
    static int[][] matrix;
    static boolean[][] visited;
    static int N,M;
    static int maxSum = Integer.MIN_VALUE;
    static void dfs(int y,int x,int depth,int sum){
        if(depth==4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        visited[y][x]=true;
        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && ny<N && nx>=0 && nx<M){
                if(!visited[ny][nx]){
                    visited[ny][nx]=true;
                    dfs(ny,nx,depth+1,sum+matrix[ny][nx]);
                    visited[ny][nx]=false;
                }
            }
        }

    }
    static void checkT(int y,int x){
        int cnt=1;
        int minValue=Integer.MAX_VALUE;
        int sum=matrix[y][x];
        for(int i=0;i<4;i++){
            int ny = y +dy[i];
            int nx = x + dx[i];
            if(ny>=0 && ny<N && nx>=0 && nx<M){
                cnt+=1;
                sum+=matrix[ny][nx];
                minValue = Math.min(minValue,matrix[ny][nx]);
            }
        }
        if(cnt==5){ // + 모양일때
            sum -= minValue;
            maxSum = Math.max(maxSum,sum);
        }
        else if(cnt==4) {
            maxSum = Math.max(maxSum, sum);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j]=true;
                dfs(i,j,1,matrix[i][j]);
                visited[i][j]=false;
                checkT(i,j);
            }
        }
        sb.append(maxSum);
        System.out.println(sb);
    }
}
