package swea.problem12712;

import java.io.BufferedReader;
import java.util.StringTokenizer;

/*
Goal : 한번의 iterator안에, 4번의 연산을 수행.
최상단좌측의 좌표를 (0,0)이라 가정
case1 수평이동 :  만약 현재의 좌표가 (y,x)라면
      왼쪽  : (y,x-1)
      오른쪽 : (y,x+1)
      위쪽  : (y-1,x)
      아래쪽 : (y+1,x)
    end : range을 넘어갈 때
case2 대각선이동 :  만약 현재의 좌표가 (y,x)라면
      왼쪽상단 대각선  : (y-1,x-1)
      오른쪽상단 대각선: (y-1,x+1)
      왼쪽하단 대각선 : (y+1,x-1)
      오른쪽하단 대각선: (y+1,x+1)
    end : range을 넘어갈 때
 */
class Solution
{
    static int[][]map = new int[16][16];
    static int maxCount = 0;
    static int N,M;

    public static boolean rangeCheck(int y,int x){
        return y>=0 && y<N && x>=0 && x<N;
    }
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T;
        T=Integer.parseInt(st.nextToken());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
            maxCount=0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for(int row =0;row<N;row++) {
                st = new StringTokenizer(br.readLine());
                for(int col =0;col<N;col++){
                    int num = Integer.parseInt(st.nextToken());
                    map[row][col]=num;
                }
            }
            int []dx1 = {-1,0,1,0};
            int []dy1 = {0,-1,0,1};
            int []dx2 ={-1,-1,1,1};
            int []dy2 ={-1,1,-1,1};
            for(int row=0;row<N;row++) {
                for(int col=0;col<N;col++){
                    int sumHorizontal = map[row][col];
                    int sumVertical = map[row][col];
                    for(int i=1;i<M;i++){
                        for(int j=0;j<4;j++){
                            int nx =row+ i*dx1[j];
                            int ny = col + i*dy1[j];
                            if(rangeCheck(nx,ny)){
                                sumHorizontal+=map[nx][ny];
                            }
                            nx = row+i*dx2[j];
                            ny = col+i*dy2[j];
                            if(rangeCheck(nx,ny)){
                                sumVertical+=map[nx][ny];
                            }
                            maxCount=Math.max(maxCount,Math.max(sumHorizontal,sumVertical));
                        }
                    }
                }
            }

            System.out.println("#"+test_case+" "+maxCount);
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
