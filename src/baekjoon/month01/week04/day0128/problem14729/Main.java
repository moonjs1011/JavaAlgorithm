package baekjoon.month01.week04.day0128.problem14729;
import java.util.*;
import java.io.*;
class MyCompare implements Comparator<Double>{
	public int compare(Double d1, Double d2) {
		return Double.compare(d1,d2);
	}
}
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double []arr = new double[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i]= Double.parseDouble(st.nextToken());
		}
		//Arrays.sort(arr,MyCompare::new);
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<7;i++) {
			sb.append(String.format("%.3f",arr[i])).append("\n");
		}
		System.out.println(sb);
	}

}
