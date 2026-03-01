package swea.month03.week01.day0301.problem1249;

import java.io.*;
import java.util.*;

public class Solution {
    static int[][] matrix;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int N;

    static int[][] dijkstra() {
        int[][] dict = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dict[i], Integer.MAX_VALUE/2);
        dict[0][0] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int cy = info[0];
            int cx = info[1];
            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N && dict[ny][nx]>dict[cy][cx]+matrix[ny][nx]) {
                    dict[ny][nx] = dict[cy][cx] + matrix[ny][nx];
                    q.offer(new int[]{ny,nx});
                }
            }
        }

        return dict;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = line.charAt(j) - '0';
                }
            }
            int[][] dict = dijkstra();
            int ans = dict[N-1][N-1];
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
