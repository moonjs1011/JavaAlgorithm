package baekjoon.month03.week01.day0308.problem2042;

import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] segmentTree;
    static int N, M, K;

    static void update(int index, long value) {
        arr[index] = value;
        updateTree(1, 1, N, index,value);
    }

    static void updateTree(int node, int nodeL, int nodeR, int index,long value) {
        if (nodeL == nodeR) {
            segmentTree[node] = value;
            return;
        }

        int middle = (nodeL + nodeR) / 2;
        if(index<=middle)
            updateTree(2 * node, nodeL, middle, index,value);
        else updateTree(2 * node + 1, middle + 1, nodeR, index,value);

        segmentTree[node] = segmentTree[2 * node] + segmentTree[2 * node + 1];
    }
    static long rangeSum(int left,int right){
        return queryTree(1,1,N,left,right);
    }
    static long queryTree(int node, int nodeL, int nodeR, int queryL, int queryR) {
        if (queryL >nodeR || nodeL > queryR) return 0;
        if (queryL <= nodeL &&  nodeR <= queryR) return segmentTree[node];

        int middle = (nodeL + nodeR) / 2;
        long sumLeft = queryTree(2 * node, nodeL, middle, queryL, queryR);
        long sumRight = queryTree(2 * node + 1, middle + 1, nodeR, queryL, queryR);

        return sumLeft + sumRight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        segmentTree = new long[4 * N];

        for (int index = 1; index <= N; index++) {
            long value = Long.parseLong(br.readLine());
            update(index, value);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(b, c);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                System.out.println(rangeSum(b,c));
            }

        }


    }
}
