package baekjoon.month02.week02.day0211.problem2606;
import java.util.*;
import java.io.*;
public class Main {
    static Map<Integer,List<Integer>> adjList;
    static Map<Integer,Boolean> visited;
    static int cnt=0;
    static void bfs(int vid){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited = new HashMap<>();
        visited.put(vid,true);
        q.offer(vid);
        while(!q.isEmpty()){
            int frontVid = q.poll();
            for(int nextVid : adjList.get(frontVid)){
                if(!visited.getOrDefault(nextVid,false)){
                    visited.put(nextVid,true);
                    q.offer(nextVid);
                    cnt+=1;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        adjList = new HashMap<>();
        for(int i=1;i<=v;i++) adjList.put(i,new ArrayList<>());
        visited = new HashMap<>();

        for(int i=0;i<e;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }
        bfs(1);
        System.out.println(cnt);
    }
}
