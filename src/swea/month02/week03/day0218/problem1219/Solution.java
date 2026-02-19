package swea.month02.week03.day0218.problem1219;
import java.io.*;
import java.util.*;
public class Solution {
    static Map<Integer,List<Integer>> adjList;
    static Map<Integer,Boolean> visited;
    static void dfs(int vid){
        if(visited.getOrDefault(vid,false)) return;
        visited.put(vid,true);
        for(int nextVid : adjList.get(vid)){
            dfs(nextVid);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<=10;tc++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int testCase = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            adjList = new HashMap<>(); for(int i=0;i<=99;i++) adjList.put(i,new ArrayList<>());
            visited = new HashMap<>();
            for(int i=0;i<N;i++){
                int src = Integer.parseInt(st.nextToken());
                int dst = Integer.parseInt(st.nextToken());
                adjList.get(src).add(dst);
            }
            dfs(0);
            StringBuilder sb =new StringBuilder();
            String format;
            if(visited.getOrDefault(99,false))
                format = String.format("#%d %d",testCase,1);
            else
                format = String.format("#%d %d",testCase,0);
            sb.append(format);

            System.out.println(sb);
        }

    }
}
