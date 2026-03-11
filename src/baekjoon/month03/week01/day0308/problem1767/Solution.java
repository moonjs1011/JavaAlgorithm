package baekjoon.month03.week01.day0308.problem1767;

import java.io.*;
import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

}

public class Solution {
    static int N;
    static int[][] board;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static List<Point> list;
    static int maxCore,minLine;

    static void setPower(int index,int lineSum,int coreCnt) {
        if (index == list.size()) {
            if(maxCore<coreCnt){
                maxCore = coreCnt;
                minLine = lineSum;
            }
            else if(maxCore==coreCnt){
                minLine = Math.min(minLine,lineSum);
            }
            return;
        }
        Point point = list.get(index);
        int y = point.y;
        int x = point.x;
        for (int dir = 0; dir < 4; dir++) {
            if (isAvailable(y, x, dir)) {
                int line = setLine(y, x, dir);
                setPower(index + 1,lineSum+line,coreCnt+1);
                unsetLine(y, x, dir);
            }
        }
        setPower(index + 1,lineSum,coreCnt);//그냥 연결 안하고 넘기기
    }

    static int setLine(int y, int x, int dir) {
        int ny = y;
        int nx = x;
        int cnt = 0;
        while (true) {
            ny += dy[dir];
            nx += dx[dir];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) return cnt;
            board[ny][nx] = 2;
            cnt += 1;
        }
    }

    static void unsetLine(int y, int x, int dir) {
        int ny = y;
        int nx = x;
        while (true) {
            ny += dy[dir];
            nx += dx[dir];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) return;
            board[ny][nx] = 0;
        }
    }

    static boolean isAvailable(int y, int x, int dir) {
        int ny = y;
        int nx = x;
        while (true) {
            ny += dy[dir];
            nx += dx[dir];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) break;
            if (board[ny][nx] >= 1) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    if ( board[i][j] == 1&&i != 0 && i != N - 1 && j != 0 && j != N - 1 ) {//가장 자리 아닐때
                        list.add(new Point(i, j));
                    }
                }
            }
            maxCore = 0;
            minLine = Integer.MAX_VALUE;
            setPower(0,0,0);
            sb.append("#").append(tc).append(" ").append(minLine).append("\n");
        }
        System.out.println(sb);
    }
}
