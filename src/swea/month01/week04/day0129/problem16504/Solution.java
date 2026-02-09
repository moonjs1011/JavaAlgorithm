package swea.month01.week04.day0129.problem16504;
import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		double W = Integer.parseInt(st.nextToken());
		double H =Integer.parseInt(st.nextToken());
		double res = W * H /2;
		System.out.printf("%.1f",res);
			
		}
		
			
	}


