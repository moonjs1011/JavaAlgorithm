    package swea.problem1959;


    import java.io.BufferedReader;
    import java.io.FileInputStream;
    import java.util.StringTokenizer;

    /*
    Index의 조합으로 length가 작은 Array를 긴 Array와 비교
     ex input
    3 5
    1 5 3
    3 6 -7 5 4

    문제 이해를 잘못했다.
    각 배열의 원소의 순서를 못바꾼다.
     */
    class Solution
    {
        public static void main(String args[]) throws Exception
        {
            System.setIn(new FileInputStream("input/input.txt"));
            int T;
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            /*
               여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
            */

            for(int test_case = 1; test_case <= T; test_case++)
            {

                /////////////////////////////////////////////////////////////////////////////////////////////
                //Input phase
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                int [] arrA = new int[N];
                int [] arrB = new int[M];
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<N;i++){
                    int input = Integer.parseInt(st.nextToken());
                    arrA[i]=input;
                }
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<M;i++){
                    int input = Integer.parseInt(st.nextToken());
                    arrB[i]=input;
                }

                //Swapping Phase, If N is bigger than M
                if(N>M){
                    int temp=N;
                    N=M;
                    M=temp;

                    int []tempArr = arrA;
                    arrA=arrB;
                    arrB=tempArr;
                }
                int maxSum=0;
                for(int i=0;i<=M-N;i++){
                    int sum=0;
                    for(int j=0;j<N;j++){
                        sum+=arrA[j]*arrB[i+j];
                    }
                    maxSum= Math.max(maxSum,sum);
                }
                System.out.println("#"+test_case+" "+maxSum);
                /////////////////////////////////////////////////////////////////////////////////////////////

            }
        }
    }
