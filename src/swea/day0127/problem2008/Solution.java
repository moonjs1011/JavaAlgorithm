package swea.day0127.problem2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    /*
    1. -1.-1
    2. -1.0
    3. -1.1
    5  0 -1
    6 0 1
    7 1 0
    8 1 1
    9 1 -1
     */
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
    static char[][] matrix;
    static int maxHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            matrix = new char[N][N];
            maxHeight= Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = st.nextToken().charAt(0);
                }
            }
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (matrix[y][x] == 'G') { //검색하는 점이 G이면 pass
                        continue;
                    }
                    int height = 1;
                    boolean existGreen = false;
                    for (int d = 0; d < 8; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                            if (matrix[ny][nx] == 'G') {//주변에 G점이 존재하면 2로 고정, 탐색할 필요 없음
                                height = 2;
                                existGreen = true;
                                break;
                            }
                        }
                    }
                    if (!existGreen) {
                        for (int i = 0; i < N; i++) { //수직의 합
                            if (i != y && matrix[i][x]=='B') height +=1;
                        }
                        for (int i = 0; i < N; i++) { //수평의 합
                            if (i != x&&matrix[y][i]=='B') height += 1;
                        }
                    }
                    maxHeight = Math.max(maxHeight, height);
                }


            }
            sb.append("#").append(tc).append(" ").append(maxHeight).append("\n");

        }
        System.out.println(sb);
    }
}
