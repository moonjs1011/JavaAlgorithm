package baekjoon.month02.week03.day0219.problem1007;
/*
bitmasking으로 조합 구현
 */
import java.io.*;
import java.util.*;
class Point{
    int y;
    int x;
    public Point(int y,int x){
        this.y = y;
        this.x=x;
    }
}
public class Main {
    static Point[] points;
    static boolean[] choice;
    static boolean[] target;
    static boolean[] visited;
    static int N;
    static double minRes;
    static double calculate(){
        double sumStartY =0;
        double sumStartX =0;
        double sumEndY=0;
        double sumEndX =0;
        for(int i=0;i<N;i++){
            if(target[i]){
                sumStartY+= points[i].y;
                sumStartX+=points[i].x;
            }
            else{
                sumEndY+= points[i].y;
                sumEndX+=points[i].x;
            }
        }
        double sumX  = sumStartX - sumEndX;
        double sumY = sumStartY -sumEndY;
        double res = Math.sqrt(Math.pow(sumX,2)+Math.pow(sumY,2));
        return res;
    }
    static void perm(int start,int depth){
        if(depth==N/2){
            //do main logic
            double res = calculate();
            minRes = Math.min(minRes,res);
            return;
        }
        for(int i=start;i<N;i++){
                target[i] = true;
                perm(i+1,depth+1);
                target[i]=false;
            }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            N  = Integer.parseInt(br.readLine());
            points = new Point[N];
            choice = new boolean[N];
            target = new boolean[N];
            visited = new boolean[N];
            for(int i=0;i<N;i++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                points[i] = new Point(y,x);
            }
            Arrays.fill(choice,0,N/2,true);
            minRes = Double.MAX_VALUE;
            perm(0,0);
            System.out.printf("%.12f\n",minRes);
        }
    }
}
