package swea.month03.week01.day0305.problem14510;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st =new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int peek = arr[N-1];
			int cnt1=0;
			int cnt2=0;
			for(int i=0;i<N-1;i++) {
				int diff = peek-arr[i];
				if(diff==0) continue;
				cnt1 += diff%2;
				cnt2 +=diff/2;
			}
			while(cnt2>cnt1+1) {
				cnt2-=1;
				cnt1+=2;
			}
			int day=-1;
			//01010
			if(cnt2>cnt1) {
				day = cnt2*2;
			}
			else if(cnt1>cnt2) {
				day = cnt1*2-1;
			}
			else if(cnt1==cnt2) {
				day =cnt1 +cnt2;
			}
			System.out.println("#"+tc+" " + day);
		}
	}
}
