package swea.month02.week02.day0212.problem4012;

import java.io.*;
import java.util.*;
/*
 * 1. N개의 식재료 -> N/2 , N/2
 * 2. N개의 check배열을 만들어서 조합을 만들어냄
 * 2.1
 *  ex.  0  1   1   0   1   0
 *  A의 음식 재료 : 1번,2번,4번
 *  B의 음식 재료 : 0번 4번,6번
 */

public class SolutionAgain {
    static int[][] board;
    static boolean[] check;
    static int N,minDiff;

    static void comb(int start, int depth) {
        if (depth == N / 2) {
            calculate();
            return;
        }
        for (int i = start; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                comb(i + 1, depth + 1);
                check[i] = false;
            }
        }

    }

    static void calculate() {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (check[i] && check[j]) //A가 선택한 조합 중, 2개를 선택
                    sumA += board[i][j] + board[j][i];
                else if (!check[i] && !check[j])//B가 선택한 조합 중, 2개를 선택
                    sumB += board[i][j] + board[j][i];
            }
        }
        int diff = Math.abs(sumA-sumB);//현재 레시피의 계산값
        minDiff = Math.min(minDiff,diff);//갱신
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            check = new boolean[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            minDiff = Integer.MAX_VALUE;
            comb(0, 0);
            String format = String.format("#%d %d\n",tc,minDiff);
            sb.append(format);
        }
        System.out.println(sb);
    }
}
