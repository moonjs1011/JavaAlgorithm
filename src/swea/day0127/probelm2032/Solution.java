package swea.day0127.probelm2032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int dy[] ={-1,0,1,0};
    static int dx[] ={0,-1,0,1};
    static int[][] matrix;
    static int maxSum=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                int sum = matrix[y][x];
                for(int d=0;d<4;d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                        sum += matrix[ny][nx];
                    }
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxSum);
        System.out.println(sb);

    }
}
