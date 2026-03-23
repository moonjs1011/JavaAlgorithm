package baekjoon.month03.week04.day0323.problem19236;

import java.io.*;
import java.util.*;

class Fish {
    int y, x, dir;
    boolean alive;

    Fish(int y, int x, int dir, boolean alive) {
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.alive = alive;
    }

    Fish(Fish other) {
        this.y = other.y;
        this.x = other.x;
        this.dir = other.dir;
        this.alive = other.alive;
    }
}

public class Main {
    static final int SIZE = 4;
    static int maxSum = 0;

    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = { 0, -1, -1, -1, 0, 1, 1,  1};

    static int[][] copyBoard(int[][] board) {
        int[][] copied = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            copied[i] = board[i].clone();
        }
        return copied;
    }

    static Fish[] copyFishes(Fish[] fishes) {
        Fish[] copied = new Fish[17];
        for (int i = 1; i <= 16; i++) {
            if (fishes[i] != null) {
                copied[i] = new Fish(fishes[i]);
            }
        }
        return copied;
    }

    static void moveAllFish(int[][] board, Fish[] fishes, int sharkY, int sharkX) {
        for (int num = 1; num <= 16; num++) {
            Fish fish = fishes[num];
            if (!fish.alive) continue;

            int y = fish.y;
            int x = fish.x;
            int originalDir = fish.dir;

            for (int r = 0; r < 8; r++) {
                int nd = (originalDir + r) % 8;
                int ny = y + dy[nd];
                int nx = x + dx[nd];

                if (ny < 0 || ny >= SIZE || nx < 0 || nx >= SIZE) continue;
                if (ny == sharkY && nx == sharkX) continue; // 상어 칸은 못 감

                int targetFishNum = board[ny][nx];

                // 현재 칸 비우기
                board[y][x] = 0;

                if (targetFishNum != 0) {
                    // 다른 물고기와 자리 교환
                    Fish other = fishes[targetFishNum];
                    other.y = y;
                    other.x = x;
                    board[y][x] = targetFishNum;
                }

                // 이동한 물고기 정보 갱신
                fish.y = ny;
                fish.x = nx;
                fish.dir = nd;
                board[ny][nx] = num;

                break;
            }
        }
    }

    static void dfs(int[][] board, Fish[] fishes, int sharkY, int sharkX, int sharkDir, int sum) {
        maxSum = Math.max(maxSum, sum);

        // 1) 물고기 이동
        moveAllFish(board, fishes, sharkY, sharkX);

        // 2) 상어 이동 (1~3칸)
        for (int step = 1; step <= 3; step++) {
            int ny = sharkY + dy[sharkDir] * step;
            int nx = sharkX + dx[sharkDir] * step;

            if (ny < 0 || ny >= SIZE || nx < 0 || nx >= SIZE) break;
            if (board[ny][nx] == 0) continue; // 빈 칸이면 지나감

            int[][] nextBoard = copyBoard(board);
            Fish[] nextFishes = copyFishes(fishes);

            int eatenFishNum = nextBoard[ny][nx];
            Fish eatenFish = nextFishes[eatenFishNum];

            // 상어가 이동하기 전 위치는 빈 칸
            nextBoard[sharkY][sharkX] = 0;

            // 도착 칸의 물고기를 먹음
            eatenFish.alive = false;
            nextBoard[ny][nx] = 0;

            dfs(nextBoard, nextFishes, ny, nx, eatenFish.dir, sum + eatenFishNum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[SIZE][SIZE];
        Fish[] fishes = new Fish[17];

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                int fishNum = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                board[i][j] = fishNum;
                fishes[fishNum] = new Fish(i, j, dir, true);
            }
        }

        // 시작: (0,0) 물고기를 상어가 먹음
        int firstFishNum = board[0][0];
        int sharkDir = fishes[firstFishNum].dir;
        fishes[firstFishNum].alive = false;
        board[0][0] = 0;

        dfs(board, fishes, 0, 0, sharkDir, firstFishNum);

        System.out.println(maxSum);
    }
}