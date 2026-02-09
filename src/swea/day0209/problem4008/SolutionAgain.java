package swea.day0209.problem4008;

import java.io.*;
import java.util.*;

public class SolutionAgain {
	static Map<Character,Integer> opMap;
	static int[] nums;
	static int maxSum,minSum;
	static void dfs(int index,int sum) {
		if(index == nums.length) {
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			return;
		}
		if(opMap.get('+')!=0) {
			opMap.put('+',opMap.get('+')-1);
			dfs(index+1, sum + nums[index]);
			opMap.put('+',opMap.get('+')+1);
		}
		if(opMap.get('-')!=0) {
			opMap.put('-',opMap.get('-')-1);
			dfs(index+1, sum - nums[index]);
			opMap.put('-',opMap.get('-')+1);
		}
		if(opMap.get('*')!=0) {
			opMap.put('*',opMap.get('*')-1);
			dfs(index+1, sum * nums[index]);
			opMap.put('*',opMap.get('*')+1);
		}
		if(opMap.get('/')!=0) {
			opMap.put('/',opMap.get('/')-1);
			dfs(index+1, sum / nums[index]);
			opMap.put('/',opMap.get('/')+1);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int plus = Integer.parseInt(st.nextToken());
			int mius = Integer.parseInt(st.nextToken());
			int mul = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());
			
			opMap = new HashMap<>();
			opMap.put('+',plus);
			opMap.put('-',mius);
			opMap.put('*',mul);
			opMap.put('/',div);
			
			nums = new int[N];
			st =new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			maxSum =Integer.MIN_VALUE;
			minSum =Integer.MAX_VALUE;
			dfs(1,nums[0]);
			String format = String.format("#%d %d\n",tc,(maxSum-minSum));
			sb.append(format);
		}
		System.out.println(sb);
	}
}
