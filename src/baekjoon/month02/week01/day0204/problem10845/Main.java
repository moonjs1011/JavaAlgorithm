package baekjoon.month02.week01.day0204.problem10845;
import java.io.*;
import java.util.*;
/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class Main {
    static final int MAXSIZE = 10000; //큐의 size의 고정
    static int[] q = new int[MAXSIZE];
    static int f=0;
    static int r=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push")){
                q[r++] = Integer.parseInt(st.nextToken());
            }

            else if(cmd.equals("pop")){
                if(r-f==0) { // empty 일때,
                    sb.append(-1).append("\n");
                }
                else sb.append(q[f++]).append("\n");
            }

            else if(cmd.equals("size")){
                sb.append(r-f).append("\n");
            }

            else if(cmd.equals("empty")){
                if(r-f==0) sb.append(1).append("\n");

                else sb.append(0).append("\n");
            }

            else if(cmd.equals("front")){
                if(r-f==0){//empty 일때,
                    sb.append(-1).append("\n");
                }

                else{
                    sb.append(q[f]).append("\n");
                }
            }

            else if(cmd.equals("back")){
                if(r-f==0){
                    sb.append(-1).append("\n");
                }

                else{
                    sb.append(q[r-1]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
