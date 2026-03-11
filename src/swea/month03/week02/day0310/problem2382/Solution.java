package swea.month03.week02.day0310.problem2382;

import java.io.*;
import java.util.*;

class Point {
    int y;
    int x;
    int micro;
    int dir;

    public Point(int y, int x, int micro, int dir) {
        this.y = y;
        this.x = x;
        this.micro = micro;
        this.dir = dir;
    }
}

class CellInfo {
    int sum;       // 해당 칸에 모인 전체 미생물 수
    int maxMicro;  // 합쳐지기 전 가장 큰 군집 수
    int dir;       // 가장 큰 군집의 방향

    public CellInfo(int sum, int maxMicro, int dir) {
        this.sum = sum;
        this.maxMicro = maxMicro;
        this.dir = dir;
    }
}

public class Solution {
    static int N, M, K;

    // 상:0, 하:1, 좌:2, 우:3
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int reverseDir(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            List<Point> list = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int micro = Integer.parseInt(st.nextToken());
                int inputDir = Integer.parseInt(st.nextToken());

                int dir = 0;
                if (inputDir == 1) dir = 0;      // 상
                else if (inputDir == 2) dir = 1; // 하
                else if (inputDir == 3) dir = 2; // 좌
                else if (inputDir == 4) dir = 3; // 우

                list.add(new Point(y, x, micro, dir));
            }

            for (int time = 0; time < M; time++) {
                Map<Integer, CellInfo> map = new HashMap<>();

                for (Point p : list) {
                    int ny = p.y + dy[p.dir];
                    int nx = p.x + dx[p.dir];
                    int nMicro = p.micro;
                    int nDir = p.dir;

                    // 약품 칸(테두리) 도착 시
                    if (ny == 0 || ny == N - 1 || nx == 0 || nx == N - 1) {
                        nMicro /= 2;
                        nDir = reverseDir(nDir);
                    }

                    if (nMicro == 0) continue;

                    int key = ny * N + nx;

                    if (!map.containsKey(key)) {
                        map.put(key, new CellInfo(nMicro, nMicro, nDir));
                    } else {
                        CellInfo info = map.get(key);
                        info.sum += nMicro;
                        if (nMicro > info.maxMicro) {
                            info.maxMicro = nMicro;
                            info.dir = nDir;
                        }
                    }
                }

                List<Point> nextList = new ArrayList<>();
                for (Map.Entry<Integer, CellInfo> entry : map.entrySet()) {
                    int key = entry.getKey();
                    int y = key / N;
                    int x = key % N;
                    CellInfo info = entry.getValue();

                    nextList.add(new Point(y, x, info.sum, info.dir));
                }

                list = nextList;
            }

            int answer = 0;
            for (Point p : list) {
                answer += p.micro;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}