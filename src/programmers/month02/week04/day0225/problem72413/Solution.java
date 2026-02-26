package programmers.month02.week04.day0225.problem72413;
import java.util.*;
/*
* 
*/
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        List<int[]>[] aad = new List[n];
        int[][] dict =new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(dict[i],Integer.MAX_VALUE);
            dict[i][i] = 0;
        }
        for(int[] edge : fares){
            dict[edge[0]][edge[1]] = edge[2];
            dict[edge[1]][edge[0]] = edge[2];
        }
        dict[s][s]=0;
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dict[i][k]!=Integer.MAX_VALUE && dict[k][j]!=Integer.MAX_VALUE&&dict[i][j]>dict[i][k]+dict[k][j]){
                        dict[i][j] = dict[i][k] + dict[k][j];
                    }
                }
            }
        }

        //1.중간 지점까지 같이 가고, A 데려다주고 B 데려다줌.
        //2. 처음부터 같이 움직이면서 A 데려다주고, B 데려다줌.
        //3. 처음부터 같이 움직이면서 B 데려다주고, A 데려다줌.
        int minSum = Integer.MAX_VALUE;
        int rideAtoB = dict[s][a] + dict[a][b];
        int rideBtoA = dict[s][b] + dict[b][a];
        for(int mid =1;mid<=n;mid++){
            minSum = Math.min(minSum,dict[s][mid]+dict[mid][a]+dict[mid][b]);
            
        }
        return Math.min(minSum,Math.min(rideAtoB,rideBtoA));
    }
    
}