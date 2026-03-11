package baekjoon.month03.week02.problem2042;

import java.io.*;
import java.util.*;
public class Main {
	static long[] arr;
	static long[] segmentTree;
	static int N;
	static void update(int index,long value) {
		arr[index]=value; 
		updateTree(1,1,N,index,value);
	}
	static void updateTree(int node, int nodeL, int nodeR,int index,long value) {
		if(nodeL==nodeR) {
			segmentTree[node] = value;
			return;
		}
		int middle = (nodeL+nodeR)/2;
		if(index<=middle) {
			updateTree(2*node,nodeL,middle,index,value);
		}
		else updateTree(2*node+1,middle+1,nodeR,index,value);
		
		segmentTree[node]  = segmentTree[2*node] + segmentTree[2*node+1];
	}
	static long rangeSum(int a,int b) {
		return queryTree(1, 1, N, a, b);
	}
	static long queryTree(int node,int nodeL,int nodeR, int queryL,int queryR) {
		if(queryL>nodeR||nodeL>queryR) return 0;
		
		if(queryL<=nodeL && nodeR<=queryR) {
			return segmentTree[node];
		}
		int middle = (nodeL + nodeR)/2;
		long sumLeft = queryTree(2*node, nodeL, middle, queryL, queryR);
		long sumRight = queryTree(2*node+1, middle+1, nodeR, queryL, queryR);
		return sumLeft + sumRight;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		 
		arr =new long[N+1];
		segmentTree = new long[4*N];
		for(int i=1;i<=N;i++) {
			long input = Long.parseLong(br.readLine());
			update(i,input);
		}
		for(int i=0;i<M+K;i++) {
			st =new StringTokenizer(br.readLine());
			int opt = Integer.parseInt(st.nextToken());
			if(opt==1) {//update
				int index = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(index,value);
			}
			else {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				System.out.println(rangeSum(a,b));
			}
		}
	}
}
