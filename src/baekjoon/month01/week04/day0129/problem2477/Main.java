package baekjoon.month01.week04.day0129.problem2477;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int maxWidth = Integer.MIN_VALUE;
		int maxWidthIdx = -1;
		int maxHeight = Integer.MIN_VALUE;
		int maxHeightIdx = -1;
		
		int []arr = new int[6]; //변들을 저장
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0;i<6;i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			arr[i] = length;
			if(direction == 1 || direction ==2) {
				if(maxWidth<length) {
					maxWidth=length;
					maxWidthIdx =i;
				}
				
			}
			else {
				if(maxHeight<length) {
					maxHeight=length;
					maxHeightIdx = i;
				}
			}
		}
		int result = (maxWidth * maxHeight) - (arr[(maxWidthIdx+3)%6] * arr[(maxHeightIdx+3)%6]);
		result *=K;
		sb.append(result);
		System.out.println(sb);
	}

}
