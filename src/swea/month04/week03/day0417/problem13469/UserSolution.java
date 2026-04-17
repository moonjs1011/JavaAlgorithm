package swea.month04.week03.day0417.problem13469;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
	int y;
	int x;
	Point(int y,int x){
		this.y =y ;
		this.x =x;
	}
	@Override
	public String toString() {
		return "["+y+", "+x+"]";
	}
}
class UserSolution
{	
	
	static char[] notepad;
	static Point start,end;
	void init(int H, int W, char mStr[])
	{
		notepad = new char[H][W];
		int pos =0;
		int i=0;
		int j=0;
		for(i=0;i<H;i++) {
			for(j=0;j<W;j++) {
				notepad[i][j] = mStr[pos++];
				if(mStr[pos]=='\0')
					return;
			}
		}
		start = new Point(0,0);
		end = new Point(i,j);
	}
	
	void insert(char mChar)
	{
		int curY = start.y;
		int curX = start.x;
		//원본 배열 deepCopy
		int H = notepad.length;
		int W = notepad[0].length;
		char[][] copy = new char[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				copy[i][j] = notepad[i][j];
			}
		}
		// 1칸씩 밀기
		for(int i=curY;i<H;i++) {
			for(int j=curX;j<W;j++) {
				if(j+1==W)
					copy[i+1][0]= notepad[i][j];
				else copy[i][j+1] = notepad[i][j];
			}
		}
		// 비어있는 자리(커서의 시작점에 mChar 입력)
		copy[curY][curX]= mChar;
		//커서의 시작점 오른쪽으로 한칸 밀기
		if(start.x+1==W) {
			start.y+=1;
			start.x=0;
		}
		else 
			start.x+=1;
		
		if(end.x+1==W) {
			end.y+=1;
			end.x=0;
		}
		else 
			end.x+=1;
		
	}

	char moveCursor(int mRow, int mCol)
	{	
		start.y = mRow;
		start.x = mCol;
		
		return '$';
	}

	int countCharacter(char mChar)
	{
		return -1;
	}
}