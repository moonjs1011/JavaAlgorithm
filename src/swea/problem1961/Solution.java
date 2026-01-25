package swea.problem1961;


import java.io.BufferedReader;
import java.util.StringTokenizer;

class Solution
{
    public static int [][] rotate90(int [][]arr,int N){
        int [][]retArr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                retArr[i][j]=arr[N-j-1][i];
            }
        }
        return retArr;
    }
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));

		//Input Phase
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int [][]matirx = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    int input = Integer.parseInt(st.nextToken());
                    matirx[i][j]=input;
                }
            }
            //Output Phase
            System.out.println("#"+test_case);
            int [][] arr90 = rotate90(matirx,N);
            int [][] arr180 = rotate90(arr90,N);
            int [][] arr270 = rotate90(arr180,N);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(arr90[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(arr180[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(arr270[i][j]);
                }
                System.out.println();
            }
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
