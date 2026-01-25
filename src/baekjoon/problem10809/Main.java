package baekjoon.problem10809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int []arr = new int [26];
        Arrays.fill(arr,-1);
        for(int i=0;i<str.length();i++){
            if(arr[str.charAt(i)-'a']==-1)
                arr[str.charAt(i)-'a']=i;
        }
        for(int i=0;i<26;i++){
            bw.write(arr[i]+""+' ');
        }
        bw.flush();
        bw.close();
    }
}
