package swea.month05.week01.day0507.problem2930;

import java.io.*;
import java.util.*;
//비어 있으면 -1
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> -Integer.compare(o1, o2));
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				if(cmd==1){
					int num = Integer.parseInt(st.nextToken());
					pq.offer(num);
				}
				else {
					if(pq.isEmpty()) sb.append(-1).append(" ");
					else sb.append(pq.poll()).append(" ");
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
