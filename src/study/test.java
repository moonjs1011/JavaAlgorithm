package study;

import java.io.*;
import java.util.*;

public class test {
	 static void init(int[] a, int[] tree, int node, int start, int end) {
		...
            init(a, tree, node*2, start, (start+end)/2);
            init(a, tree, node*2+1, (start+end)/2+1, end);
            tree[node] = tree[node*2] + tree[node*2+1];
        }
    }

	static int query(int[] tree, int node, int start, int end, int left, int right) {
     ... 
            return lmin+rmin;
	 ...
        }
	static void update(int[] a, int[] tree, int node, int start, int end, int index, int val) {
        ...
        update(a, tree,node*2, start, (start+end)/2, index, val);
        update(a, tree,node*2+1, (start+end)/2+1, end, index, val);
        tree[node] = tree[node*2] +tree[node*2+1];
    }
    
	static void init(long[] a, long[] tree, int node, int start, int end) {
      ...
            init(a, tree, node*2, start, (start+end)/2);
            init(a, tree, node*2+1, (start+end)/2+1, end);
            tree[node] = tree[node*2] + tree[node*2+1];
    }
	    static void init(int[] a, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            init(a, tree, node*2, start, (start+end)/2);
            init(a, tree, node*2+1, (start+end)/2+1, end);
            tree[node] = tree[node*2] + tree[node*2+1];
        }
    }
	static int rangeSum(int[] array, int start, int end){
			int sum = 0;
			for (int i=start; i<=end; i++) {
    			sum += array[i];
			}
			return sum;
	}
	static int[] prefix;

	static void init(int[] array){
		prefix[0] = array[0];
		for(int i=1;i<array.length;i++){
			prefix[i]= prefix[i-1]+array[i];
		}
	}

	static int rangePrefixSum(int [] prefix, int start, int end){
		if(start==0) return prefix[end];
		return prefix[end] - prefix[start-1];
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]>[] G = new List[N];
		for (int i = 0; i < N; i++) G[i] = (new ArrayList<>());
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int C = sc.nextInt();
				if(C!=0) G[i].add(new int[] {j,C});
			}
		}
		boolean[] v = new boolean[N];
		int[] P = new int[N]; Arrays.fill(P, Integer.MAX_VALUE);
		int mst=0,cnt=0;
		P[0]=0;
		for(int i=0;i<N;i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j=0;j<N;j++) {
				if(!v[j] && min>P[j]) {
					min = P[j];
					minVertex = j;
				}
			}
			v[minVertex] =true;
			mst+=min;
			if(cnt++==N-1) break;
			for(int[] j : G[minVertex]) {
				if(!v[j[0]] && P[j[0]]>j[1]) {
					P[j[0]] = j[1];
				}
			}
		}
	
		System.out.println(mst);
	}

}
