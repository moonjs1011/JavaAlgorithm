package swea.month02.week02.day0212.problem1861;
import java.io.*;
import java.util.*;
public class SolutionAgain {
    static int[] dy ={-1,0,1,0};
    static int[] dx ={0,-1,0,1};
    static int [][]matrix;
    static boolean [][]visited;
    static int N,maxDepth,roomId;
    static void dfs(int starty,int startx,int y,int x,int depth){
        if(maxDepth<depth){
            maxDepth = depth;
            roomId = matrix[starty][startx];
        }
        else if(maxDepth==depth){
            roomId = Math.min(roomId,matrix[starty][startx]);
        }
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny>=0 && ny<N && nx>=0 && nx<N && matrix[y][x]+1 == matrix[ny][nx]){
                dfs(starty,startx,ny,nx,depth+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());

            matrix = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            roomId=-1;
            maxDepth=1;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dfs(i,j,i,j,1);
                }
            }
            String format = String.format("#%d %d %d \n", tc,roomId,maxDepth);
            sb.append(format);
        }
        System.out.println(sb);
    }
}
