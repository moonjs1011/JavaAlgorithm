package swea.etc.problem1289;


import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
			String bits = sc.next();
            int cnt =0;
            char curBit = '0';
            for(int i= 0;i<bits.length();i++){
                if(curBit == bits.charAt(i)){
                    continue;
                }
                else{
                    cnt+=1;
                    curBit = bits.charAt(i);
                }
            }
            System.out.println("#"+test_case+" " + cnt);
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
