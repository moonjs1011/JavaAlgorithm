package baekjoon.month01.week04.day0128.problem24511;
/*
 * 
 */
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Long> dq = new ArrayDeque<Long>();
		
		int N = Integer.parseInt(st.nextToken());
		boolean[] info = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			byte b = Byte.parseByte(st.nextToken()); // 스택:0 or 큐:1
			if(b==1) {
				info[i]=true;
			}
			else info[i]=false;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			long input = Long.parseLong(st.nextToken());
			if(!info[i])//stack인 상태
				dq.offerFirst(input);
			}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			Long ci = Long.parseLong(st.nextToken());
			dq.offer(ci);
			sb.append(dq.poll()).append(" ");
			
		}
		System.out.println(sb);
	}

}
