package swea.month05.week01.day0509.problem2948;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            HashMap<String,Integer> map= new HashMap<>();
            String[] tokens = br.readLine().split(" ");
            int aSize = Integer.parseInt(tokens[0]);
            int bSize = Integer.parseInt(tokens[1]);

            tokens = br.readLine().split(" ");
            for(int i=0;i<aSize;i++){
                map.put(tokens[i],map.getOrDefault(tokens[i],0)+1);
            }
            tokens = br.readLine().split(" ");
            for(int i=0;i<bSize;i++){
                map.put(tokens[i],map.getOrDefault(tokens[i],0)+1);
            }
            int ans =0;
            for(String key : map.keySet()){
                if(map.get(key)>1) ans+=1;
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}
