package baekjoon.month03.week01.day0304.problem2042;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static Long[] segmentTree;
    static Long[] arr;

//    static Long rangeSum(int node,int nodeL,int nodeR,int query);
    static void updateSegment(int node,int nodeL, int nodeR, int index, Long value){
        if(nodeL==index && nodeR == index){
            segmentTree[node]  = value;
            return;
        }
        int mid = (nodeL-nodeR)/2;
        if(index<=mid) updateSegment(node*2+1,nodeL,mid,index,value);
        else updateSegment(node*2+2,mid+1,nodeR,index,value);

        //segmentTree[node] = segmentTree[nodeL]+segmentTree[nodeR]; <-이거 안됌 nodeL,R은 tree위의 index
        segmentTree[node] = segmentTree[2*node+1] + segmentTree[2*node+2];
    }

    static void update(int index,Long value){
        arr[index] = value;
        updateSegment(0,0,N-1,index,value);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        segmentTree = new Long[4 * N];
        arr = new Long[N];
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a==1){//update, b번째 index를 c로 바꿈
                int b = Integer.parseInt(st.nextToken());
                Long c = Long.parseLong(st.nextToken());
            }
            else{//rangeSum b to c의 구간 합을 출력
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
            }
        }


    }
}
