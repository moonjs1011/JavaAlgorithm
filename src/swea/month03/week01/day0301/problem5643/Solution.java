package swea.month03.week01.day0301.problem5643;
import java.io.*;
import java.util.*;
public class Solution {
    static int N,M;
    static void dfs(Map<Integer,List<Integer>> g,boolean[] visited,int vid){
        if(visited[vid]) return;
        visited[vid] = true;
        for(int nextVid:g.get(vid)){
            dfs(g,visited,nextVid);
        }
    }
    static int check(boolean[]visitedIn, boolean[] visitedOut){
        int cnt=0;
        for(int i=1;i<=N;i++){
            if(visitedIn[i] || visitedOut[i])  cnt+=1;
        }
        return cnt;
    }
    public static void main(String[] args) throws  IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            Map<Integer,List<Integer>>gOut,gIn;
            gOut = new HashMap<>(); for(int i=1;i<=N;i++) gOut.put(i,new ArrayList<>());
            gIn = new HashMap<>(); for(int i=1;i<=N;i++) gIn.put(i,new ArrayList<>());


            for(int i=0;i<M;i++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                gOut.get(a).add(b);
                gIn.get(b).add(a);
            }
            int ans =0;
            for(int vid=1;vid<=N;vid++){
                boolean[] visitedIn = new boolean[N+1];
                boolean[] visitedOut= new boolean[N+1];
                dfs(gIn,visitedIn,vid);
                dfs(gOut,visitedOut,vid);
                if(check(visitedIn,visitedOut)==N) ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);

    }
}
