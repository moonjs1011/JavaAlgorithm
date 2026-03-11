package swea.month03.week02.day0311.problem1251;

import java.io.*;
import java.util.*;

public class Solution {
    static Map<Integer, List<double[]>> G;
    static int N;

    static long Prim(int vid) {
        boolean[] visited = new boolean[N]; // 0부터 N-1까지 사용
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1[1], o2[1]));
        
        // 시작 노드 설정
        pq.offer(new double[] { vid, 0 });
        double mst = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            double[] info_edge = pq.poll();
            int dst = (int) info_edge[0];
            double weight = info_edge[1];

            if (visited[dst]) continue;

            visited[dst] = true;
            mst += weight;
            cnt += 1;

            if (cnt == N) return Math.round(mst); // 소수점 반올림 처리

            for (double[] edge : G.get(dst)) {
                int next = (int) edge[0];
                double nextWeight = edge[1];
                if (!visited[next]) {
                    pq.offer(new double[] { next, nextWeight });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        int T_str = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T_str; tc++) {
            N = Integer.parseInt(br.readLine());
            int[][] info = new int[N][2];
            G = new HashMap<>();
            
            for (int i = 0; i < N; i++) G.put(i, new ArrayList<>());

            // X 좌표 입력
            st = new StringTokenizer(br.readLine());
            for (int vid = 0; vid < N; vid++) info[vid][0] = Integer.parseInt(st.nextToken());

            // Y 좌표 입력
            st = new StringTokenizer(br.readLine());
            for (int vid = 0; vid < N; vid++) info[vid][1] = Integer.parseInt(st.nextToken());

            double E = Double.parseDouble(br.readLine());

            for (int v1 = 0; v1 < N; v1++) {
                for (int v2 = v1 + 1; v2 < N; v2++) {
                    long dx = info[v1][0] - info[v2][0];
                    long dy = info[v1][1] - info[v2][1];

                    // distance = L^2 (이미 제곱된 값이므로 다시 pow할 필요 없음)
                    long distanceSq = dx * dx + dy * dy;
                    double weight = E * distanceSq; // 비용 = E * L^2

                    G.get(v1).add(new double[] { v2, weight });
                    G.get(v2).add(new double[] { v1, weight });
                }
            }
            
            // 0번 섬부터 시작 (기존 Prim(1)도 가능하지만 0이 안전합니다)
            long minDist = Prim(0);
            sb.append("#").append(tc).append(" ").append(minDist).append("\n");
        }
        System.out.print(sb);
    }
}