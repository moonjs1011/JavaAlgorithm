package baekjoon.month04.week03.day0414.problem9205;

import java.io.*;
import java.util.*;

class Point {
	int y, x;
	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Point[] points = new Point[n + 2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
			}
		}

	}
}
