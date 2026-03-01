package swea.month03.week01.day0301.problem5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1 {
    static int N, M;
    static int cnt;
    static void dfs(Map<Integer,List<Integer>> g, int vid,boolean[] visited) {
        if(visited[vid]) return ;
        visited[vid] = true;
        for(int nextVid : g.get(vid)){
            dfs(g,nextVid,visited);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            Map<Integer, List<Integer>> gIn= new HashMap<>();
            Map<Integer, List<Integer>> gOut= new HashMap<>();
            for (int i = 1; i <= N; i++){
                gIn.put(i, new ArrayList<>());
                gOut.put(i, new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                gOut.get(a).add(b);
                gIn.get(b).add(a);
            }
            int ans =0;
            for(int vid=1;vid<=N;vid++){
                cnt=0;
                boolean[] visitedIn = new boolean[N+1];
                boolean[] visitedOut = new boolean[N+1];
                dfs(gOut,vid,visitedOut);
                dfs(gIn,vid,visitedIn);
                for(int v=1;v<=N;v++){
                    if(vid!=v && visitedIn[v])cnt+=1;
                    else if(vid!=v && visitedOut[v]) cnt-=1;
                }
                if(cnt==0) ans+=1;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
