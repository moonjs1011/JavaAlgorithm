package swea.month02.week03.day0225.problem5650;

import java.io.*;
import java.util.*;

public class SolutionAns {
    static int N, maxCnt;
    static int[][] matrix;
    // 웜홀 저장: [번호6~10][쌍0~1][y=0, x=1]
//    static int[][][] wormHoles;
//    static int[] holeCnt;
    static Map<Integer,List<int[]>> worm;
    
    // 방향: 0:상, 1:좌, 2:하, 3:우
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    
    // 블록별 방향 전환 테이블 (상:0, 좌:1, 하:2, 우:3)
    static int[][] reflectMap = {
        {},
        {2, 0, 3, 1}, // 1번 블록
        {3, 2, 0, 1}, // 2번 블록
        {1, 3, 0, 2}, // 3번 블록
        {2, 3, 1, 0}, // 4번 블록
        {2, 3, 0, 1}  // 5번 블록 (벽과 동일)
    };

    static void simulate(int startY, int startX, int dir) {
        int y = startY;
        int x = startX;
        int d = dir;
        int score = 0;

        while (true) {
            y += dy[d];
            x += dx[d];

            // 1. 종료 조건: 시작점 귀환 또는 블랙홀(-1)
            if ((y == startY && x == startX) || matrix[y][x] == -1) {
                maxCnt = Math.max(maxCnt, score);
                return;
            }

            int val = matrix[y][x];

            // 2. 블록 충돌 (벽 패딩 덕분에 1~5만 체크하면 됨)
            if (val >= 1 && val <= 5) {
                d = reflectMap[val][d];
                score++;
            } 
            // 3. 웜홀 처리 (배열을 사용한 O(1) 점프)
            else if (val >= 6) {
//                int[][] pair = wormHoles[val];
//                if (y == pair[0][0] && x == pair[0][1]) {
//                    y = pair[1][0]; x = pair[1][1];
//                } else {
//                    y = pair[0][0]; x = pair[0][1];
//                }
            	List<int[]> list = worm.get(val);
            	for(int[] ele : list) {
            		if(!(y==ele[0]&&x==ele[1])) {
            			y=ele[0];
            			x=ele[1];
            			break;
            		}
            	}
            }
            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            while (line == null || line.trim().isEmpty()) line = br.readLine();
            N = Integer.parseInt(line.trim());

            // 맵 패딩: 상하좌우 테두리를 5번 블록으로 감쌈
            matrix = new int[N + 2][N + 2];
//            wormHoles = new int[11][2][2];
//            holeCnt = new int[11];
            worm = new HashMap<>();
           for(int i=6;i<=10;i++) worm.put(i,new ArrayList<>());
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (matrix[i][j] >= 6) {
//                        int num = matrix[i][j];
//                        wormHoles[num][holeCnt[num]][0] = i;
//                        wormHoles[num][holeCnt[num]][1] = j;
//                        holeCnt[num]++;
                        worm.get(matrix[i][j]).add(new int[] {i,j});
                    }
                }
            }

            // 테두리 5번 블록(벽)으로 채우기
            for (int i = 0; i < N + 2; i++) {
                matrix[i][0] = matrix[i][N + 1] = 5;
                matrix[0][i] = matrix[N + 1][i] = 5;
            }

            maxCnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (matrix[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            simulate(i, j, d);
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + maxCnt);
        }
    }
}