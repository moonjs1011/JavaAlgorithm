package baekjoon.month02.week02.day0211.problem2606;
import java.util.*;
import java.io.*;
public class Main {
	static int v,e;
    static Map<Integer,List<Integer>> adjList;
    static Map<Integer,Boolean> visited;
    static int count() {
    	int cnt =0;
    	for(int vid=2;vid<=v;vid++) { //1번 정점은 카운팅에서 제외 O(V)
    		if(visited.getOrDefault(vid,false)) cnt+=1;
    	}
    	return cnt;
    }
    static void bfs(int vid){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited = new HashMap<>();
        visited.put(vid,true);
        q.offer(vid); // O(1)
        while(!q.isEmpty()){ // O(V+E)
            int src = q.poll(); //O(1)
            for(int dst : adjList.get(src)){
                if(!visited.getOrDefault(dst,false)){ //O(1 X E) [ 비교연산 횟수 X 간선들의 개수 ]
                    visited.put(dst,true);//O(1)
                    q.offer(dst); //O(1)
           
                }
            }
        }
    //Method Total : O(V+E)
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        adjList = new HashMap<>();
        for(int i=1;i<=v;i++) adjList.put(i,new ArrayList<>()); //O(V)
        visited = new HashMap<>();

        for(int i=0;i<e;i++){ // O(V)
            StringTokenizer st =new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }
        bfs(1); //Method : O(V+E)
        int res = count();
        System.out.println(res);
        //Total : O(V+E)
    }
}
