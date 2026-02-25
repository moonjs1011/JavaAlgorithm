package study;

public class BitMasking {
	public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        // 1 << n은 2^n, 즉 모든 부분 집합의 개수 (0000 ~ 1111)
        for (int i = 0; i < (1 << n); i++) {
            
            // 현재 선택된 원소의 개수를 확인 (조합 nCr에서 r에 해당)
            // 예: 0011 이면 bitCount는 2입니다.
            if (Integer.bitCount(i) == 2) { // 크기가 2인 조합만 출력하고 싶을 때
                System.out.print("Mask " + Integer.toBinaryString(i) + " : ");
                
                for (int j = 0; j < n; j++) {
                    // i의 j번째 비트가 1인지 확인
                    if ((i & (1 << j)) != 0) {
                        System.out.print(arr[j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
