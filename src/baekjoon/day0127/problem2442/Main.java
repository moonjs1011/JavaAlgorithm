package baekjoon.day0127.problem2442;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			StringBuilder sb =new StringBuilder();
			for(int j=1;j<=N-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
