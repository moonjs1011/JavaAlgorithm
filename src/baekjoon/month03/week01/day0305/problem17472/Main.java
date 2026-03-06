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
        static int minimumSpanningTree() {
            int mst = 0;
            int numOfIslands = maxVid - 1; // 실제 섬의 개수
            
            int[] minEdge = new int[maxVid]; 
            Arrays.fill(minEdge, Integer.MAX_VALUE);
            boolean[] visited = new boolean[maxVid];
           
            
            
       
            //
            // 1번 섬부터 탐색 시작
            minEdge[1] = 0;

            for (int i = 0; i < numOfIslands; i++) {
                int minVertex = -1;
                int minVal = Integer.MAX_VALUE;

                // 1. 아직 방문하지 않은 섬 중에서 가장 짧은 다리로 연결할 수 있는 섬 찾기
                for (int j = 1; j < maxVid; j++) {
                    if (!visited[j] && minEdge[j] < minVal) {
                        minVal = minEdge[j];
                        minVertex = j;
                    }
                }

                // 2. 만약 더 이상 연결할 섬이 없는데 반복문이 끝나지 않았다면 (고립된 섬이 존재)
                if (minVertex == -1) {
                    return Integer.MAX_VALUE;
                }

                // 3. 해당 섬 방문 처리 및 총 다리 길이에 누적
                visited[minVertex] = true;
                mst += minVal;

                // 4. 방금 연결한 섬을 기준으로, 다른 섬들로 가는 최소 다리 길이 갱신
                for (int j = 1; j < maxVid; j++) {
                    if (!visited[j] && dist[minVertex][j] != Integer.MAX_VALUE) {
                        if (dist[minVertex][j] < minEdge[j]) {
                            minEdge[j] = dist[minVertex][j];
                        }
                    }
                }
            }
            return mst;
        }
        static void dfs(int y, int x, int vid, int dir, int bridgeLength) {
            if (matrix[y][x] != 0 && matrix[y][x]!=vid) {
            	if(bridgeLength>=3)
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
