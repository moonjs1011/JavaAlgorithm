package swea.month02.week01.day0206.problem1767;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    
    // Core의 위치 정보를 저장할 클래스
    static class Core {
        int r, c;
        public Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int[][] map;
    static ArrayList<Core> coreList; // 가장자리가 아닌 코어들만 저장
    static int maxCores; // 최대 연결 코어 수
    static int minLength; // 최소 전선 길이 합
    
    // 상, 하, 좌, 우 델타 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreList = new ArrayList<>();
            
            // 초기화
            maxCores = Integer.MIN_VALUE;
            minLength = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 1인 경우 Core
                    if (map[i][j] == 1) {
                        // 가장자리에 있는 Core는 이미 연결된 것으로 치고 리스트에 넣지 않음
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                            continue;
                        }
                        coreList.add(new Core(i, j));
                    }
                }
            }

            // DFS 탐색 시작 (인덱스 0부터 시작, 연결된 코어 0개, 전선 길이 0)
            dfs(0, 0, 0);

            System.out.println("#" + t + " " + minLength);
        }
    }

    // idx: 현재 처리할 코어의 인덱스
    // connected: 현재까지 연결된 코어의 수
    // len: 현재까지 사용한 전선의 길이 합
    static void dfs(int idx, int connected, int len) {
        
        // [가지치기]
        // 현재 연결된 개수 + 남은 코어 개수를 다 합쳐도 기존 최대값(maxCores)보다 작다면 가망 없음
        if (connected + (coreList.size() - idx) < maxCores) {
            return;
        }

        // [기저 조건] 모든 코어를 다 확인했을 때
        if (idx == coreList.size()) {
            if (connected > maxCores) {
                // 더 많은 코어를 연결했다면 갱신
                maxCores = connected;
                minLength = len;
            } else if (connected == maxCores) {
                // 코어 수는 같지만 전선 길이가 더 짧다면 갱신
                if (len < minLength) {
                    minLength = len;
                }
            }
            return;
        }

        Core current = coreList.get(idx);
        int r = current.r;
        int c = current.c;

        // 4방향(상하좌우)으로 전선 연결 시도
        for (int d = 0; d < 4; d++) {
            int wireLen = 0;
            int nr = r;
            int nc = c;
            boolean isPossible = true;
            
            // 해당 방향으로 쭉 뻗어보기
            while (true) {
                nr += dr[d];
                nc += dc[d];
                
                // 범위를 벗어나면(가장자리에 닿으면) 전원 연결 성공
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
                
                // 가다가 다른 코어(1)나 전선(2)을 만나면 실패
                if (map[nr][nc] != 0) {
                    isPossible = false;
                    break;
                }
                wireLen++;
            }

            if (isPossible) {
                // 전선 설치 (map에 2로 표시)
                fillMap(r, c, d, wireLen, 2);
                
                // 다음 코어로 이동 (연결 성공했으므로 connected + 1)
                dfs(idx + 1, connected + 1, len + wireLen);
                
                // 원상복구 (백트래킹) -> map을 다시 0으로
                fillMap(r, c, d, wireLen, 0);
            }
        }

        // 해당 코어를 연결하지 않고 건너뛰는 경우 
        dfs(idx + 1, connected, len);
    }

    // 맵에 전선을 그리거나 지우는 함수
    // value: 2(전선 설치), 0(전선 삭제)
    static void fillMap(int r, int c, int d, int len, int value) {
        int nr = r;
        int nc = c;
        for (int i = 0; i < len; i++) {
            nr += dr[d];
            nc += dc[d];
            map[nr][nc] = value;
        }
    }
}