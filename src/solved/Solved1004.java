package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solved1004 {
	public int[][] map = new int[4004][4004];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			
			// 출발지점, 도착지점 좌표 4개
			String[] str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i <N; i++) {
				String[] str1 = br.readLine().split(" "); // x,y,r 입력
				int c1 = Integer.parseInt(str1[0]);
				int c2 = Integer.parseInt(str1[1]);
				int r = Integer.parseInt(str1[2]);
				
				// 좌표 그리기
				
				
			}
			
		}
	}
}
