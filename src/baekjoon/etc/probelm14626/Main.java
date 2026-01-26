package baekjoon.etc.probelm14626;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String isbn =  st.nextToken();

        int sum =0;
        int maskIndex=-1;
        int ans;
        for(int i=0;i<isbn.length();i++){
            if(isbn.charAt(i)=='*') {
                maskIndex = i; //save masked index
            }
            else{
                if(i%2==0) { //even index
                    sum+= isbn.charAt(i)-'0';
                }
                else sum+= 3*(isbn.charAt(i)-'0');
            }
        }
        for(int num=0;num<=9;num++){
            if(maskIndex%2==0 && (sum+num)%10==0){
                bw.write(num+"");
            }
            else if(maskIndex%2==1 &&(sum+3*num)%10==0){
                bw.write(num+"");
            }
        }
        bw.flush();
        bw.close();
    }
}
