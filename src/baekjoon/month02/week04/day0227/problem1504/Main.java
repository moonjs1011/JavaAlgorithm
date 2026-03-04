package baekjoon.month02.week04.day0227.problem1504;

import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<int[]>> adjList = new HashMap<>();
    static int N, E;
    static Long INF_VALUE = 200000 * 1000L;

    static Long[] dijkstra(int vid) {
        Long[] dict = new Long[N + 1];
        Arrays.fill(dict, INF_VALUE);
        dict[vid] = 0L;
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[1], o2[1])));
        q.offer(new int[]{vid, 0}); //O(1)
        while (!q.isEmpty()) { //O(V(1 + logE))
            int[] info = q.poll(); //O(1) + log(logE)
            int cv = info[0];
            int cw = info[1];
            if (cw > dict[cv]) continue;
            for (int[] edge : adjList.get(cv)) {
                int nv = edge[0];
                int nw = edge[1];
                if (dict[nv] > dict[cv] + nw) {
                    dict[nv] = dict[cv] + nw;
                    q.offer(new int[]{nv, Math.toIntExact(dict[nv])});//O(1+logE)
                }
            }
        }
        return dict;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // Map 초기화
        for (int vid = 1; vid <= N; vid++) {
            adjList.put(vid, new ArrayList<>());
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 간선 삽입
            adjList.get(a).add(new int[]{b, c});
            adjList.get(b).add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        Long[] dict1 = dijkstra(1);//1을 시작으로 모든 정점에 대한 최단 거리
        Long[] dictV1 = dijkstra(v1); //v1를 시작으로 모든 정점에 대한 최단 거리
        Long[] dictV2 = dijkstra(v2); //v2를 시작으로 모든 정점에 대한 최단 거리

        //1 -> v1 -> v2 -> N 의 최단거리
        Long dict1V1V2N = dict1[v1] + dictV1[v2] + dictV2[N];
        //1 -> v2 -> v1 -> N 의 최단거리
        Long dict1V2V1N = dict1[v2] + dictV2[v1] + dictV1[N];

        Long ans = Math.min(dict1V1V2N, dict1V2V1N);
        if (ans >= INF_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

}
