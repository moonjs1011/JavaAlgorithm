package baekjoon.month02.week02.day0211.problem9663;

import java.io.*;
import java.util.*;

/*
 * col[N+1]
 * col[1] = 1   1번째 행의 1번째열에 놓음
 * col[7] = 3   7번째 행의 3번째열에 놓음
 */
public class Main {
	static int[] board;
	static int N,cnt=0;
	static void put(int r) {
		if(r>=N+1) {
			cnt+=1;
			for(int i=1;i<N+1;i++) {
				int targetRow = board[i];
				for(int j=1;j<N+1;j++) {
					if(targetRow == j) System.out.print("Q ");
					else System.out.print(". ");
				}
				System.out.println();
			}
			System.out.println("---------------");
			return;
		}
		for(int i=1;i<N+1;i++) {
			board[r] = i;
			if(isAvailable(r)) {
				put(r+1);
			}
		}
	}
	static boolean isAvailable(int r) {
		for(int i=1;i<r;i++) {
			if(board[i]==board[r]) return false;
			if(Math.abs(i-r)==Math.abs(board[i]-board[r])) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N+1];
		put(1);
		System.out.println(cnt);
	}
}
