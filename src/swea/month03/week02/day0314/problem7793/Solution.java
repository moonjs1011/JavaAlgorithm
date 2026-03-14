package swea.month03.week02.day0314.problem7793;
import java.io.*;
import java.util.*;

/*
 여신 큐와, 악마 큐를 분리
 여신 큐에 시작점 push
 악마 큐에 모든 악마 점 pust[여러개임]
 while q1.empty():
    현재 큐 사이즈만큼만 퍼져야함
    악마 큐 pop,push

    if q1.front == endPoint : return days;
    현재 큐 사이즈만큼만 퍼져야함
    여신 큐 pop, push

return -1;//fail case
 */
public class Solution {
    static char[][] grid;

    static int[] dy={-1,0,1,0};
    static int[] dx ={0,-1,0,1};

    static int N,M;
    static Queue<int[]> angleQ,demonQ;
    static boolean rangeCheck(int y,int x){
        return y>=0 && y<N && x>=0 &&x<M;
    }
    static int bfs(){
        int time=0;
        boolean[][] visited = new boolean[N][M];
        while(!angleQ.isEmpty()){
            time+=1;
            int demonQSize = demonQ.size();
            for(int i=0;i<demonQSize;i++){
                int[] info = demonQ.poll();
                int cy = info[0];
                int cx = info[1];
                for(int d=0;d<4;d++){
                    int ny = cy + dy[d];
                    int nx = cx + dx[d];
                    if(rangeCheck(ny,nx)&&(grid[ny][nx]=='.'||grid[ny][nx]=='S')){
                        grid[ny][nx] = '*';
                        demonQ.offer(new int[]{ny,nx});
                    }
                }

            }
            int angleQSize = angleQ.size();
            for(int i=0;i<angleQSize;i++){
                int[] info = angleQ.poll();
                int cy = info[0];
                int cx = info[1];
                if(grid[cy][cx]=='D') return time-1;
                visited[cy][cx]=true;
                for(int d=0;d<4;d++){
                    int ny = cy + dy[d];
                    int nx = cx + dx[d];
                    if(rangeCheck(ny,nx)&&!visited[ny][nx]&&(grid[ny][nx]=='.'||grid[ny][nx]=='D')){
                        visited[ny][nx]=true;
                        angleQ.offer(new int[]{ny,nx});
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= T; tc++) {
                sb.append("#").append(tc).append(" ");
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                grid = new char[N][M];
                angleQ = new ArrayDeque<>();
                demonQ = new ArrayDeque<>();

                for (int i = 0; i < N; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < M; j++) {
                        grid[i][j] = line.charAt(j);
                        if (grid[i][j] == 'S') angleQ.offer(new int[]{i, j});
                        else if (grid[i][j] == '*') demonQ.offer(new int[]{i, j});
                    }
                }
                int time = bfs();
                if (time == -1) sb.append("GAME OVER").append("\n");
                else sb.append(time).append("\n");
            }
            System.out.print(sb);
            br.close();
        }

    }

