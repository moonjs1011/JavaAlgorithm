package study;
import java.io.*;
import java.util.*;
public class PrimMain {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]>[] G = new List[N]; for(int i=0;i<N;i++) G[i] = new ArrayList<>();
        boolean[] v = new boolean[N];
        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                int c = sc.nextInt();
                if(c!=0) G[i].add(new int[]{j,c});
            }
        }
        int []P = new int[N]; Arrays.fill(P,Integer.MAX_VALUE);
        int mst=0,cnt=0;
        P[0] = 0;
        for(int i=0;i<N;i++){
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<N;j++){
                if(!v[j] && min>P[j]){
                    min =P[j]; minVertex = j;
                }
            }
            v[minVertex] = true;
            mst+=min;
            if(cnt++==N-1) break;
            for(int[] j : G[minVertex]){
                if(!v[j[0]]&&P[j[0]]>j[1]){
                    P[j[0]] = j[1];
                }
            }
        }
        System.out.println(mst);
        sc.close();
    }
}
