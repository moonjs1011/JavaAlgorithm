package baekjoon.day0131.problem1026;
import java.io.*;
import java.util.*;

public class Main {
    static int[] arrA;
    static int[] perArr;
    static int[] arrB;
    static boolean[]visited;
    static int minSum =0;
    static int cnt=0;
    // 0 1 1 1 6
    // 8 7 3 2  1
    static void perm(int depth){
        if(depth == perArr.length){
            int sum=0;
            cnt++;
            for(int i=0;i<arrA.length;i++){

                sum+=perArr[i] * arrB[i];
            }
            minSum = Math.min(minSum,sum);
            return;
        }
        for(int i=0;i<arrA.length;i++){
            if(!visited[i]){
                visited[i]=true;
                perArr[depth] = arrA[i];
                perm(depth+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        StringBuilder sb =new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        arrA = new int[N];
        perArr = new int[N];
        arrB = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        arrB = Arrays.stream(arrB)
                        .boxed()
                                .sorted(Collections.reverseOrder())
                                        .mapToInt(Integer::intValue)
                                                .toArray();
        for(int i=0;i<N;i++){
            minSum+=arrA[i]*arrB[i];
        }
        sb.append(minSum);
        System.out.println(minSum);
    }

}
