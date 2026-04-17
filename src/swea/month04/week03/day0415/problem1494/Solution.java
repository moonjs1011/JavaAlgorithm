package swea.month04.week03.day0415.problem1494;

import java.io.*;
import java.util.*;

/*
2개의 지렁이를 선택-> vector
 |V| = (x,y) -> x*x + y*y
 subs
 */
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}

public class Solution {
    static Point[] points;
    static boolean[] visited;
    static long tx,ty;
    static int N;
    static long minVec;
    static void subs(int idx, int cnt, long sx, long sy) {
        if (cnt == N / 2) {
            long vx = 2 * sx - tx;
            long vy = 2 * sy - ty;
            long dist = vx * vx + vy * vy;
            minVec = Math.min(minVec, dist);
            return;
        }

        if (idx == N) return;

        if (N - idx < (N / 2 - cnt)) return;

        subs(idx + 1, cnt + 1, sx + points[idx].x, sy + points[idx].y);
        subs(idx + 1, cnt, sx, sy);
    }

    static int calulateVector(Point p1, Point p2) {
        int diffX = p1.x - p2.x;
        int diffY = p1.y - p2.y;

        return diffX * diffX + diffY * diffY;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            points = new Point[N];
            visited =new boolean[N];
            minVec = Long.MAX_VALUE;
            tx=0;
            ty=0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
                tx+=x;
                ty+=y;
            }
            subs(0,0,0,0);
            System.out.println("#"+tc+" "+minVec);
        }

    }
}
