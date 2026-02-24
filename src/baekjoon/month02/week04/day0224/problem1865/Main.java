package baekjoon.month02.week04.day0224.problem1865;

import java.io.*;
import java.util.*;

/*
 *  N개의 지점 존재
 *  N개의 지점들 사이ㅏ에 M개의 도로와 W개의 웜홀 (도로는 양방향, 웜홀은 단방향)
 *  웜홀ㅇㄴ 시작 위치에서 도작 위치로 가는 path, 도착을 하면 시작을 하였을 때보다 시간이 뒤로감
 *  	(웜홀 안에서는 시간이 반대로 흐름)
 *  경우가 있는지 없는지
 *  N 500 M  500 W 200
 *
 */
class Node{
    int src,dst,weight;
    public Node(int src,int dst,int weight){
        this.src =src;
        this.dst =dst;
        this.weight=weight;
    }
}
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점의 수
            int M = Integer.parseInt(st.nextToken()); // 도로의 수
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 수

            List<Node> nodeList = new ArrayList<>();
            for (int i = 0; i < M; i++) {// M개의 도로 입력 받기
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()); // src 지점 id
                int E = Integer.parseInt(st.nextToken()); // dst 지점 id
                int weight = Integer.parseInt(st.nextToken()); // 걸리는 시간(weight)
				nodeList.add(new Node(S,E,weight));
                nodeList.add(new Node(E,S,weight));
            }
            for (int i = 0; i < W; i++) {// W개의 웜홀의 수 입력 받기
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()); // src 지점 id
                int E = Integer.parseInt(st.nextToken()); // dst 지점 id
                int weight = Integer.parseInt(st.nextToken()); // 걸리는 시간(weight)

                nodeList.add(new Node(S,E,-weight));// 웜홀은 음의 값
            }
            boolean flag =false;
            int[]dict = new int[N + 1];
            for(int i=1;i<=N;i++){
                for(Node node : nodeList){
                    int src =node.src;
                    int dst = node.dst;
                    int weight = node.weight;
                    if(dict[dst]>dict[src]+weight){
                        System.out.println(src+" "+dst+" "+weight);
                        dict[dst] = dict[src]+weight;
                        if(i==N)
                            flag=true;
                    }

                }
            }
            if (flag)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
