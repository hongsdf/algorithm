package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


class star{
	int x;
	int y;
	int r;
	star(int x,int y,int r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
}

public class Solvedac1004어린왕자 {
	public static List<star> list = new ArrayList<>();
	
	public static int arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int answer = 0;
			boolean flag = false;
			List<star> start = new ArrayList<>();
			List<star> destination = new ArrayList<>();
			String str[] = br.readLine().split(" ");
			// 출발 지점
			int x1 = Integer.parseInt(str[0]); 
			int y1 = Integer.parseInt(str[1]);
			
			// 도착 지점
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i <N; i++) {
				String str1[] = br.readLine().split(" ");
				int c1 = Integer.parseInt(str1[0]);
				int c2 = Integer.parseInt(str1[1]);
				int r = Integer.parseInt(str1[2]);
				// list.add(new star(c1,c2,r));
				
				boolean startflag = solve(x1,y1,c1,c2,r);
				
				// 도착지가 포함된 원을 찾는다.
				// destinationPlanet = solve(x2,y2,list,destination );
				boolean destinationflag = solve(x2,y2,c1,c2,r );
				
				// 한원이 출발지와 도착지를 품고 잇지 않고, 출발지와 도착지중 하나만 가지고있는 경우
				
				if(!(startflag && destinationflag) && (startflag || destinationflag)) {
					answer++;
				}
				
			}
			System.out.println( answer );
			// 출발지가 포함된 원을 찾는다.
			// startPlanet = solve(x1,y1,list,start);
			// 한 원이 둘다 포함하고 있지않고 하나만 포함하고 잇는경우
			
		
		}
			
			
		
			
			
			
		
		
		
	} // 행성번호, c1 x좌표,c2 y 좌표,r 반지름
	private static boolean solve(int x, int y, int c1, int c2, int r) {
		// 행성지 (출발지 || 도착지) 가 원안에 포함되어 있는 여부 체크
		// 두점사이의 거리가 반지름 보다 작으면 포함 되어있다.
		boolean flag = false;
		int dx = (x - c1);
		int dy = (y - c2);
		int dist = (int)Math.sqrt(dx * dx + dy *dy);
		if(dist < r) { // dist == r 이 같으면 경계면이 같으므로 포함하고 있지 않다.(참고)
			flag = true; // 포함되어있다.
		}
		
		
		
		return flag;
	}
//	private static int solve(int x, int y, List<star> list,List<star> list2 ) {
//		// 행성들과 출발지점을 거리를 비교한다.
//		int cnt = 0;
//		for(star planet : list) {
//			int dx = planet.x - x;
//			int dy =  planet.y - y;
//			int dist = (int)Math.sqrt((dx *dx) + (dy * dy));
//			
//			if(dist >= planet.r) { // 포함 x
//				
//			}else { // 포함 되어있다.
//				list2.add(new star(planet.x,planet.y,planet.r) );
//				cnt++;
//				flag = true; // 포함하고 있다.
//			}
//		}
//		return cnt;
//		
//	}
	
	
	
	
	private static void makeMAP(int number,int row, int col, int r) {
		// 윗부분
		for(int i = r; i >= 0 ; i--) { // 윗부분은 row 번호가 감소
			for(int j = -i; j<= i; j++) {
				if(row -r +i >= 0  && row -r +i < arr.length && col+j >= 0 && col+j <  arr.length) {
					// row위치로부터 그리기 위해 row : 행 위치, 변수 i, r 거리로부터 떨어진 거리
					arr[row -r +i][col+j] = number;
				}
			}
		}
		
		// 아랫부분
		for(int i = 1; i<=r; i++) { // 아래부분은 row 번호 가 증가
			for(int j = -r+i; j<= r-i; j++) {
				if(row+i < arr.length && row+i >=0 && col +j >=0 &&col+j < arr.length) {
					// row 위치로부터 그리기 row : 행위치,변수 i
					arr[row+i][col+j] = number;
				}
			}
		}
		
	}
}
