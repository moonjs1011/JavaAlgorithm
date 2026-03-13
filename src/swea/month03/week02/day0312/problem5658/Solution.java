package swea.month03.week02.day0312.problem5658;

import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, edgeSize;
	static char[][] hex;
	static List<Integer> nums;
	
	static void log() {
		for(char[] e : hex) 
			System.out.println(Arrays.toString(e));
		System.out.println();
	}
	static void rotate() {
		char[][] temp = new char[4][edgeSize]; 
		//배열을 순회하면서 한칸씩 밀어줌
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < edgeSize - 1; j++) {
				temp[i][j + 1] = hex[i][j];
			}
		}
		//첫번째 변의 첫번째 원소 = 마지막 변의 마지막 원소  
		temp[0][0] = hex[3][edgeSize - 1];
		//i번째 변의 첫번째 원소 = i-1번째 변의 마지막 원소
		for (int i = 1; i < 4; i++) {
			temp[i][0] = hex[i - 1][edgeSize - 1];
		}
		
		//저장된 값을 덮어씌어줌
		hex = temp;
	}

	static void calculate() {
		//4변에 대해 계산 수행
		for (int i = 0; i < 4; i++) {
			int result = hexToDeciam(hex[i]);
			
			if (!nums.contains(result)) //중복을 허용하지 않음으로 중복 체크
				nums.add(result);
		}
	}

	static int hexToDeciam(char[] arr) {
		//16진수를 10진수로 변환하는 함수
		int sum = 0;
		int di = 0;
		
		//sum+=(arr[i] * 16^di)
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] >= '0' && arr[i] <= '9')
				sum += (arr[i] - '0') * Math.pow(16, di);

			else if (arr[i] >= 'A' && arr[i] <= 'F')
				sum += (arr[i] - 'A' + 10) * Math.pow(16, di);
			di += 1;
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/swea/month03/week02/day0312/problem5658/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();

			edgeSize = line.length() / 4;	//각 변에 저장할 수 있는 값의 개수
			hex = new char[4][edgeSize];	//사각형이므로 [4][edgeSize]의 배열 생성

			//원본 배열 생성
			int index = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < edgeSize; j++) {
					hex[i][j] = line.charAt(index++);
				}
			}
			
			nums = new ArrayList<>();//각변의 원소를 10진수로 바꾼 값을 관리할 List
			log();//원본 상태
			calculate();//원본 상태
			for (int i = 0; i < edgeSize; i++) {
				rotate(); //회전 수행
				log(); //회전 후 상태
				calculate();//각변의 값들을 계산
			}
			
			Collections.sort(nums, (o1, o2) -> -Integer.compare(o1, o2));//오름차순 정렬
			sb.append("#").append(tc).append(" ").append(nums.get(K - 1)).append("\n");
		}
		System.out.println(sb);
	}
}
