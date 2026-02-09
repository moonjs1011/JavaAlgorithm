package swea.month01.week04.day0129.problem3499;
import java.io.*;
import java.util.*;
/*
 * 
 */
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));;
		StringBuilder sb =new StringBuilder();
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			ArrayDeque<String> dq1 = new ArrayDeque<>();
			ArrayDeque<String> dq2 = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			if(N%2==0) {
				for(int i=0;i<N/2;i++) {
					dq1.offer(st.nextToken());
				}
				for(int i=N/2;i<N;i++) {
					dq2.offer(st.nextToken());
				}
			}
			else {
				for(int i=0;i<N/2+1;i++) {
					dq1.offer(st.nextToken());
				}
				for(int i=N/2+1;i<N;i++) {
					dq2.offer(st.nextToken());
				}
			}
			StringBuilder target = new StringBuilder();
			while(!dq1.isEmpty()||!dq2.isEmpty()) {
				if(!dq2.isEmpty())
					target.append(dq1.poll()).append(" ").append(dq2.poll()).append(" ");
				else
					target.append(dq1.poll()).append(" ");
			}
			sb.append("#").append(tc).append(" ").append(target).append("\n");
		}
		System.out.println(sb);
	}
}
