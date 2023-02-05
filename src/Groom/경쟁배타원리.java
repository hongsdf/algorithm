package Groom;

import java.io.*;
import java.util.*;
public class 경쟁배타원리 {
	// public static int board[][] = new int[1001][1001];
	public static int board[][] = new int[11][11];
	public static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int max = 0;
		int number = 1;
		while(N --> 0 ){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 로직
			x1--;
			y1--;
			x2--;
			y2--;
			// 맵을 그린다.
			mapIntoBoard(x1,y1,x2,y2);
			// number++;
		}
		// 맵의 갯수를 센다.
		for(int i = 0; i <board.length; i++){
			for(int j = 0; j <board.length; j++){
				if(board[i][j] == K) answer++;
			}
		}
		
		// 정답
		System.out.println(answer);
		// 종의 수  < K  >  경쟁이 일어나지 않고 공생하며 살아간다.
		// 즉 k개일때 메타 경쟁이 일어난다.
		
		// 메타버스의 생태계 지도가 주어졌을 때, 경쟁 배타의 원리가 일어나는 영역의 총 넓이를 구해보자.
	}
	public static void mapIntoBoard(int x1,int y1, int x2, int y2){
		for(int i = x1; i<=x2; i++){
			for(int j = y1; j<=y2; j++){
					board[i][j]++;
			}
		}
	}
}
