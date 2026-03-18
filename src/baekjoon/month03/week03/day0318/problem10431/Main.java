package baekjoon.month03.week03.day0318.problem10431;

import java.io.*;
import java.util.*;
/*
 * 5 6 2
 * 2 5 6
 */
public class Main {
	static int[]arr;
	static int cnt=0;
	static void swap(int end) {
		int lastHeight = arr[end];
		int[] temp = arr.clone();
		for(int i=0;i<end;i++) {
			if(arr[i]>lastHeight) {
				for(int j=0;i<i-1;j++) {
					temp[j] = arr[j];
				}
				temp[i] = lastHeight;
				for(int j=i+1;j<=end;j++) {
					temp[j]=arr[j-1];
				}
				arr = temp;
				cnt+= end-i;
				break;
			}
		}
//		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[20];
			cnt=0;
			int tc = Integer.parseInt(st.nextToken());
			
			arr[0] = Integer.parseInt(st.nextToken());
			for (int i = 1; i < 20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				swap(i);
			}
			sb.append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}

