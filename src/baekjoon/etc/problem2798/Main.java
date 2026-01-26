package baekjoon.etc.problem2798;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            int input = sc.nextInt();
            arr.add(input);
        }
        int maxsum=0;
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                for(int k=j+1;k<N;k++) {
                    int sum = arr.get(i)+arr.get(j)+arr.get(k);
                    if(sum>maxsum && sum<=M) maxsum=sum;
                }
            }
        }
        System.out.println(maxsum);
        sc.close();
    }
}