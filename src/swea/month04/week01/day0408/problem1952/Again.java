package swea.month04.week01.day0408.problem1952;

import java.io.*;
import java.util.*;

/*	
 * ticket[4] : 1일 이용권료,1달 이용권료, 3달 이용권료,12달 이용권료
 * monthUsage[12] : 달별 이용횟수
 * dp[i] = i번째 달까지 계산한 최적해(최소 요금)
 * dp[i] = min{ 
 * 				dp[i-1] + (1일 이용권료 * 1일 이용횟수(monthUsage[i])),
 * 			    dp[i-1] + 1달 이용권료,
 * 				dp[i-3] + 3달 이용권료, if, i-3>=0
 * 				dp[i-12]+ 12달 이용권료 if, i-12>=0
 * 			  } 
 * print(dp[12])
 */
public class Again {
	public static void main(String[] args) throws IOException{ 
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int[] ticket = new int[4];
			int[] monthUsage = new int[12+1]; //index from 1 to 12
			int[] dp = new int[12+1]; // index from 1 to 12
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				ticket[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=12;i++) {//1번 index부터 이용
				monthUsage[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<=12;i++) {
				int costDay = Integer.MAX_VALUE;
				int costMonth = Integer.MAX_VALUE;
				int costTriple = Integer.MAX_VALUE;
				int costYear = Integer.MAX_VALUE;
				
				costDay = dp[i-1] + ticket[0] * monthUsage[i];
				costMonth = dp[i-1] + ticket[1];
				if(i-3>=0) costTriple = dp[i-3] + ticket[2]; //index 오류 처리
				if(i-12>=0) costYear = dp[i-12] + ticket[3]; // index 오류 처리
				
				dp[i] = Math.min(costDay, Math.min(costMonth, Math.min(costTriple, costYear)));
			}
			sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
		}
		System.out.println(sb);
	}
}
