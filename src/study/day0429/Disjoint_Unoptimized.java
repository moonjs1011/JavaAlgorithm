package study.day0429;

public class Disjoint_Unoptimized {
	static int MAXSIZE = 5000;
	static int[] parent = new int[MAXSIZE];
	static int[] nums = new int[MAXSIZE];
	static {
		for(int i=0;i<MAXSIZE;i++) {
			int rand = (int)(Math.random()%10000);
			nums[i] = rand;
			parent[i] = i;
		}
	}
	static void union(int v1,int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if(p1!=p2) parent[p2] =p1;
	}
	static int find(int vid) {
		if(vid==parent[vid]) return vid;
		else return find(parent[vid]);
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		for(int i=0;i<MAXSIZE/2;i++) {
			int rand1 = (int)(Math.random()%5000);
			int rand2 = (int)(Math.random()%5000);
			union(rand1,rand2);
		}
		
		for(int i=0;i<MAXSIZE;i++) {
			System.out.println("vid = "+i+", root of vid = "+find(i));
		}
		long end = System.currentTimeMillis();
		
		
		System.out.println("Total time :"+(end-start));

	}

}
