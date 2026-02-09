package baekjoon.month02.week01.day0204.problem30678;
/*
 * 별찍기 
 */
import java.util.*;
public class Main {
	static int N;
	static void printSpace() {
		for(int i=0;i<N;i++)
			System.out.print(" ");
		System.out.println();
	}
	static void printStar() {
		//height = N*2 +1
		for(int y=0;y<2*N+1;y++) {
			for(int x=0;x<2*N+1;x++) {
				
			}
		}
	}
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
	 }
}
