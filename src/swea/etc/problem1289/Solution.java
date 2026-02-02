package swea.etc.problem1289;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static void main(String args[]) throws Exception
    {
  
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
