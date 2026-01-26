package programmers.etc.problem87946;
import java.util.*;

class Solution {
    boolean[] visited = new boolean[1000];
    int size;
    int maxDepth=0;
    public void dfs(int[][]dungeons, int index,int depth,int curHp){
        maxDepth = Math.max(maxDepth,depth);
        if(visited[index]) return;
        visited[index]=true;
        for(int i=0;i<size;i++){
            if(curHp>=dungeons[index][0]){
                dfs(dungeons,i,depth+1,curHp-dungeons[index][1]);
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        for(int i=0;i<size;i++){
            Arrays.fill(visited,false);
            dfs(dungeons,i,0,k);
        }
        return maxDepth;
    }

}