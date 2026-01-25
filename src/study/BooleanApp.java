package study;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BooleanApp {
    public static String twotTimes(String text,String delimiter){
        String output ="";
        output += delimiter+"\n";
        output +=text+"\n";
        output +=text+"\n";
        return output;
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(twotTimes("Hello","World"));
        FileWriter fw = new FileWriter("output.txt");
        fw.write(twotTimes("a","*"));
        fw.close();



    }
}
