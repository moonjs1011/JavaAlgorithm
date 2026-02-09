package baekjoon.month01.week04.day0129.problem28107;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//key : 주방장이 내준 스시 
		//value : 해당 스시를 원하는 손님들의 큐
		Map<Integer,ArrayDeque<Integer>> map = new HashMap<>(); 
		for(int i=0;i<200001;i++)
			map.put(i,new ArrayDeque<Integer>()); //초기화
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<k;j++) {
				map.get(Integer.parseInt(st.nextToken())).offer(i); //i번째 사람을 해당 메뉴의 map에 insert
			}
		}
				
		st=new StringTokenizer(br.readLine());
		
		ArrayDeque<Integer> choq = new ArrayDeque<>(); // 초밥의 종류를 담는 큐
		int []cnt = new int[N]; //N명의 사람들의 먹는 횟수
		for(int i=0;i<M;i++) {
				int cho = Integer.parseInt(st.nextToken());
				if(!map.get(cho).isEmpty()) {
					cnt[map.get(cho).poll()]+=1;
				}
		}
		for(int c : cnt) {
			sb.append(c).append(" ");
		}
		System.out.println(sb);
		
	}

}
