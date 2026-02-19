package baekjoon.month02.week03.day0218.problem1931;
import java.io.*;
import java.util.*;
class Room{
    int start,end;
    public Room(int start,int end){
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];
        for(int i=0;i<N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(start,end);
        }
        Arrays.sort(rooms,(r1,r2)->{
            if(r1.end == r2.end) return Integer.compare(r1.start,r2.start);
            return Integer.compare(r1.end,r2.end);
        });
        int roomCnt = 0;
        int prevEndTime = 0;
        for(int i=0;i<N;i++){
            if(prevEndTime<=rooms[i].start){
                prevEndTime = rooms[i].end;
                roomCnt+=1;
            }
        }
        System.out.println(roomCnt);



    }
}
