package baekjoon.month04.week03.day0414.problem14438;

import java.io.*;
import java.util.*;
public class Main {
    static long[] segTree,arr;
    static int N;
    static void updateTree(int node, int nodeL,int nodeR,int index,int value){
        if(nodeL==nodeR){
            segTree[node] = value;
            return ;
        }
        
        int middle = (nodeL+nodeR)/2;
        if(index<=middle)
            updateTree(2*node,nodeL,middle,index,value);
        else 
            updateTree(2*node+1,middle+1,nodeR,index,value);

        segTree[node] = Math.min(segTree[2*node] , segTree[2*node+1]);
    }
    static void update(int index, int num){
        arr[index]  = num;
        updateTree(1,1,N,index,num);
    }
    static long rangeMin(int a, int b){
        return qureyTree(1,  1, N, a, b);
    }
    static long qureyTree(int node, int nodeL, int nodeR, int queryL,int queryR){
        if(queryL>nodeR||nodeL>queryR)
            return -1;
        if(queryL<=nodeL && nodeR<=queryR) 
            return segTree[node];

        int middle = (nodeL+nodeR)/2;
        long minLeft = qureyTree(node*2, nodeL, middle, queryL, queryR);
        long minRight = qureyTree(node*2+1, middle+1, nodeR, queryL, queryR);

        if(minLeft==-1) return minRight;
        else if(minRight==-1) return minLeft;
        else return Math.min(minLeft,minRight);
    }
    public static void main(String[] args) throws IOException{    
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        N = Integer.parseInt(br.readLine());
        arr = new  long[N+1];
        segTree = new long [4*N];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            update(i, Integer.parseInt(st.nextToken()));
        }   
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int opt = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(opt==1){
                update(a, b);
            }
            else{
                System.out.println(rangeMin(a, b));
            }
        }
    }
}
