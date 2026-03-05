    package baekjoon.month03.week01.day0305.problem17472;

    import java.io.*;
    import java.util.*;

    public class Main {
        static int[] dy = {-1, 0, 1, 0};
        static int[] dx = {0, -1, 0, 1};
        static int N, M;
        static int[][] matrix;
        static boolean[][] visited;
        static int[][] dist;
        static boolean[] check;
        static int maxVid,minBridgeLen;
        static int minimumSpanningTree(){
            int mst =0;
            int cnt=0;
            int[]P = new int[maxVid]; Arrays.fill(P,Integer.MAX_VALUE);
            boolean[]v = new boolean[maxVid];
            for(int i= 1; i<=maxVid;i++) {
                int minVertex=-1;
                int minVal = Integer.MAX_VALUE;
                for(int j=1;j<=maxVid;j++){
                    if(i!=j && !v[j]&&dist[i][j]!=Integer.MAX_VALUE && P[j]>dist[i][j]){
                        minVertex = j;
                        minVal = dist[i][j];
                    }
                }
                mst+=minVal;
                v[minVertex]=true;
                if(cnt++==maxVid) return mst;
                for(int j=1;j<=maxVid;j++){
                    if(dist[minVertex][j]!=Integer.MAX_VALUE && !v[j] && P[j]>dist[minVertex][j]){
                        P[j]=dist[minVertex][j];
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        static void dfs(int y, int x, int vid, int dir, int bridgeLength) {
            if (matrix[y][x] != 0 && matrix[y][x] != vid &&bridgeLength>=3) {
                dist[vid][matrix[y][x]] = Math.min(dist[vid][matrix[y][x]], bridgeLength-1);//현재 점은 길이에서 빼줌
                return;
            }
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M||matrix[ny][nx]==vid) return;
            dfs(ny, nx, vid, dir, bridgeLength + 1);
        }

        static void tansMatrix(int y, int x, int id) {
            visited[y][x] = true;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{y, x});
            while (!q.isEmpty()) {
                int[] info = q.poll();
                int cy = info[0];
                int cx = info[1];
                matrix[cy][cx] = id;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = cy + dy[dir];
                    int nx = cx + dx[dir];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && matrix[ny][nx] != 0) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N][M];
            int vid = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && matrix[i][j] != 0) {
                        tansMatrix(i, j, vid);
                        vid += 1;
                    }
                }
            }
            maxVid = vid;
            dist = new int[maxVid][maxVid];
            for(int i=1;i<maxVid;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] != 0) {
                        for (int dir = 0; dir < 4; dir++) {
                            dfs(i, j, matrix[i][j], dir, 0);
                        }
                    }

                }
            }
            minBridgeLen=minimumSpanningTree();
            check = new boolean[maxVid+1];

            if(minBridgeLen==Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(minBridgeLen);
        }
    }
