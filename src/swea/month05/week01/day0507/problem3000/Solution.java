package swea.month05.week01.day0507.problem3000;

import java.io.*;
import java.util.*;
/*
 * init maxheap.offer(num)
 * -> if minheap.peek < num  minheap.offer(num);
 * 	  else maxheap.offer(num)
 *  
 *  if(maxheap.size()-minheap.size()>1) minheap.offer(maxheap.poll());
 *  else if(minheap.size() - maxheap.size() >1) maxheap.offer(minheap.poll())
 *  
 */
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int modulo = 20171109;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->-Integer.compare(o1, o2));
			PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)-> Integer.compare(o1, o2));
			
			String[] tokens = br.readLine().split(" ");
			int N = Integer.parseInt(tokens[0]);
			int A = Integer.parseInt(tokens[1]);
			long answer=0;
			maxHeap.offer(A);
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<2;j++) {
					int num = Integer.parseInt(st.nextToken());
					if(minHeap.isEmpty()) {
						minHeap.offer(num);
						continue;
					}
					
					if(minHeap.peek()<num) minHeap.offer(num);
					else maxHeap.offer(num);
					
					if(minHeap.peek()<maxHeap.peek()) {
						int temp = minHeap.poll();
						minHeap.offer(maxHeap.poll());
						maxHeap.offer(temp);
					}
					if(maxHeap.size()-minHeap.size()>1) minHeap.offer(maxHeap.poll());
					if(minHeap.size()-maxHeap.size()>1) maxHeap.offer(minHeap.poll());
				}
				answer= (answer + minHeap.peek())%modulo;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
