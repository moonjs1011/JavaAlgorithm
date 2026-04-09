package swea.month04.week02.day0408.problem4193;

import java.io.*;
import java.util.*;

/*
 * N x N
 * 지나갈수 없는 장애물(고정,[1]),
 * 주기적으로 사라졌다 나타나는 소용돌이<- 장애물 [2], 2초동안 유지되다가 1초동안 잠잠해짐
 * 단, 한번 통과한 소용돌이 위에서는 머물러 있을 수 있음.
 * 소용돌이를 지나게 된다. bfs
 */
public class Solution {
    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] grid;

    static int dijkstra(int startY, int startX, int endY, int endX) {
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[startY][startX] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[2], o2[2])));
        pq.offer(new int[]{startY, startX, 0}); //{y,x,dist}
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int cy = info[0];
            int cx = info[1];
            int cDist = info[2];
            if (dist[cy][cx] < cDist) continue;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || grid[ny][nx] == 1) continue;

                int nextDist = cDist + 1; // 기본적으로 1초 소요
                if (grid[ny][nx] == 2) {
                    // 소용돌이를 만났을 때만 대기 시간을 추가
                    int waitTime = (3 - (cDist % 3)) % 3;
                    nextDist += waitTime;
                }

                if (dist[ny][nx] > nextDist) {
                    dist[ny][nx] = nextDist;
                    pq.offer(new int[]{ny, nx, nextDist});
                }
            }
        }
        return dist[endY][endX];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            int ans = dijkstra(startY,startX,endY,endX);
            System.out.println(ans);
        }


    }
}
