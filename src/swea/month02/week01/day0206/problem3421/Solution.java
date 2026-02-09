package swea.month02.week01.day0206.problem3421;

import java.io.*;
import java.util.*;

/*
 *  n,m static <- 
 *  index 0 부터 시작
 *  List 받음
 *  list에 원소들이 조합 불가능한지 확인 
 *  OK? -> list 에 넣고 인덱스 늘려줘서 재귀
 *  No -> 인덱스만 늘려줘서 재귀
 */
public class Solution {
	static int[] arr;
	static Map<Integer, List<Integer>> map;
	static int cnt = 0;

	static void subs(int index, List<Integer> list) {
		if (index == arr.length) {
			cnt += 1;
			return;
		}
		
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {
			/*
			list에 있는 원소들과 현재 검사하고 있는 원소,
			즉 arr[index]값이 서로 조합 가능한지 판별
			*/
			if (map.get(list.get(i)).contains(arr[index])) {
				flag = false;
			}
		}
		if (flag) {//조합 가능
			list.add(arr[index]);
			subs(index + 1, list);
			list.remove(list.size() - 1);//재귀 호출전에 삽입했던 원소를 pop
		}
		subs(index + 1, list); //skip
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N]; //조합의 대상인 원소들을 저장 1..N
			//해당 원소가 조합 불가능한 점들을 List로 저장
			//key : 원소값 , value : key와 조합 불가능한 원소들 
			map = new HashMap<>(); 
			cnt = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = i + 1;
			}
			for (int i = 0; i < N; i++) {
				map.put(i + 1, new ArrayList<Integer>());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map.get(a).add(b); //조합 불가능한 정보를 저장
				map.get(b).add(a); //조합 불가능한 정보를 저장
			}
			
			List<Integer> list = new ArrayList<>();
			subs(0, list);
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}
