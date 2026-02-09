package baekjoon.month02.week01.day0202.problem2531;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        StringBuilder sb =new StringBuilder();

        st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //N개의 초밥
        int d = Integer.parseInt(st.nextToken()); //초밥의 가지수
        int k = Integer.parseInt(st.nextToken()); //연속해서 k개를 먹으면 쿠폰 c를 준다.
        int c = Integer.parseInt(st.nextToken());

        int []arr = new int[N]; //회전 초밥의 배열
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int []eat =new int[d+1]; //해당 초밥을 먹었나 안 먹었나 체크
        int cnt=0;
        for(int i=0;i<k;i++){
            if(eat[arr[i]]==0) cnt++;
            eat[arr[i]]+=1;
        }
        int maxCnt = (eat[c] == 0) ? cnt + 1 : cnt; //쿠폰 적용
        for(int i=0;i<N;i++){
            //슬라이딩 윈도우 [pop-front]
            eat[arr[i]]-=1;
            if(eat[arr[i]]==0) cnt-=1;

            //슬라이딩 윈도우 [push-back]
            if(eat[arr[(i+k)%N]]==0) cnt+=1;
            eat[arr[(i+k)%N]]+=1;

            if(eat[c] == 0) { //쿠폰 적용 체크
                maxCnt = Math.max(maxCnt, cnt + 1);
            } else {
                maxCnt = Math.max(maxCnt, cnt);
            }
        }

        sb.append(maxCnt);
        System.out.println(sb);
    }
}
