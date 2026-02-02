package swea.day0202.problem1230;
import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			
			List<String> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine()); // 명령어 처리
			for(int i=0;i<M;i++) {
				char cmd = st.nextToken().charAt(0);
				if(cmd=='I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0;j<y;j++) {
						String s = st.nextToken();
						list.add(x+j, s);
					}
					
				}
				else if(cmd=='D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0;j<y;j++)
						list.remove(x);
				}
				else if(cmd=='A') {
					int y = Integer.parseInt(st.nextToken());
					for(int j=0;j<y;j++) {
						String s = st.nextToken();
						list.add(s);
					}
				}
				
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
