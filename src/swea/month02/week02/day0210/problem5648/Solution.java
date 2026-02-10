package swea.month02.week02.day0210.problem5648;

import java.io.*;
import java.util.*;

//시간을 0.5초씩 검사
/*
 * 1.입력은 2배로 늘려서 받음 [0.5단위 계산을 피하기 위함]
 * 2. 한번 전부다 움직인 다음, 해당 좌표에 몇개가 위치하는지 파악
 */
class Node {
	int y, x, direction, energy;
	boolean alive;

	public Node(int x, int y, int direction, int energy) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.energy = energy;
		this.alive = true;
	}
}

public class Solution {
	static int MAXSIZE = 4001;
	static int[] dy = { 1, -1, 0, 0 }; // 0 : 상, 1 : 하, 2:좌, 3:우
	static int[] dx = { 0, 0, -1, 1 };
	static List<Node> nodeList;
	static int[][] hitMap;
	static int totalEnergy = 0;

	static void moveOnce() {
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.get(i);
			if (node.alive) {
				int cx = node.x;
				int cy = node.y;
				int direction = node.direction;
				hitMap[cx][cy] -= 1;
				int nx = cx + dx[direction];
				int ny = cy + dy[direction];
				if(ny<0 || ny>=MAXSIZE || nx<0 || nx>=MAXSIZE) {
					node.alive=false;
					continue;
				}
				hitMap[nx][ny] += 1;
				node.x=nx;
				node.y =ny;
			}
		}
	}
	static boolean checkAlive() {
		for(int i=0;i<nodeList.size();i++) {
			if(nodeList.get(i).alive) {
				return true;
			}
		}
		return false;
	}
	static void check() {
		List<int[]> tempList = new ArrayList<>();
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.get(i);
			int cx = node.x;
			int cy = node.y;
	
			if (hitMap[cx][cy] >= 2) {//충돌 발생
				totalEnergy += node.energy;
				node.alive=false;
				tempList.add(new int[] { cx, cy });
			}
		}
		//충돌한 좌표 reset
		for(int[] e : tempList) {
			int x =e[0];
			int y= e[1];
			hitMap[x][y]=0;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			nodeList = new ArrayList<>();
			hitMap = new int[MAXSIZE][MAXSIZE];
			totalEnergy=0;
			
			for(int i=0;i<N;i++) {
				st =new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				int mapX = (x+1000) * 2;
				int mapY = (y+1000) * 2;
				hitMap[mapX][mapY]+=1;
				nodeList.add(new Node(mapX,mapY,direction,energy));
			}
			
			while(checkAlive()) {
				moveOnce();
				check();
			}
			String format = String.format("#%d %d\n",tc,totalEnergy);
			sb.append(format);
		}
		System.out.println(sb);
	}
}
