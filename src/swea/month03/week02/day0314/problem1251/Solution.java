package swea.month03.week02.day0314.problem1251;


import java.io.*;

import java.util.*;
public class Solution {
    static List<double[]>[] G;
    static int N;
    static double prim(int vid){
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1,o2)->Double.compare(o1[1],o2[1]));
        pq.offer(new double[]{vid,0});
        boolean[]visited = new boolean[N];
        double mst=0;
        int cnt=0;
        while(!pq.isEmpty()){
            double[] info = pq.poll();
            int dst = (int)info[0];
            double distance = info[1];
            if(visited[dst]) continue;
            visited[dst]=true;
            mst += distance;
            if(cnt++ == N-1) return mst;
            for(double[] edge : G[dst]){
                int next = (int) edge[0];
                double nextDistance = edge[1];
                if(!visited[next])
                    pq.offer(new double[]{next,nextDistance});
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(br.readLine());
            G = new ArrayList[N]; for(int i=0;i<N;i++) G[i] = new ArrayList<>();

            int[] y = new int[N];
            int[] x = new int[N];
            st =new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                y[i] = Integer.parseInt(st.nextToken());
            }
            st =new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                x[i] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    int diffy = y[i]-y[j];
                    int diffx = x[i]-x[j];
                    double dist = Math.sqrt(Math.pow(diffy,2)+Math.pow(diffx,2));
                    G[i].add(new double[]{j,E*dist*dist});
                    G[j].add(new double[]{i,E*dist*dist});
                }
            }
        double ans = prim(0);
        sb.append(Math.round(ans)).append("\n");
        }
        System.out.println(sb);
    }
}

