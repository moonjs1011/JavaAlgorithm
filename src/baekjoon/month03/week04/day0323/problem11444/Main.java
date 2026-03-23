package baekjoon.month03.week04.day0323.problem11444;

import java.io.*;

public class Main {
    static long MOD = 1000000007L;
    static long[][] origin = {{1,1},{1,0}};
    static long[][] pow(long[][] base, long exp){
        if(exp==1 || exp == 0)
            return base;
        long[][] ret = pow(base,exp/2);
        ret = multiply(ret,ret);
        if(exp%2==1){
            ret = multiply(ret,origin);
        }
        return ret;
    }
    static long[][] multiply(long[][] a, long[][] b){
        long[][] ret = new long[2][2];
        for(int k=0;k<2;k++){
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    ret[i][j]+= a[i][k]*b[k][j];
                    ret[i][j]%=MOD;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] A = {{1,1},{1,0}};
        System.out.println(pow(A,n-1)[0][0]);
    }

}