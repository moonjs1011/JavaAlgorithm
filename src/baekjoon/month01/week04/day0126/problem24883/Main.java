package baekjoon.month01.week04.day0126.problem24883;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String []args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	StringBuilder sb =new StringBuilder();
	
	char ch = st.nextToken().charAt(0);
	if(ch == 'N' || ch =='n') {
		sb.append("Naver D2");
	}
	else sb.append("Naver Whale");
	
	System.out.println(sb);
	}
}
