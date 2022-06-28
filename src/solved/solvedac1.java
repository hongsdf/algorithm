package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
 
// 2008 12 27
// 2009 1 22

// 문제 요점
// 단위 계산
// 매월마다 일수가 다르다 Month 배열
// 그리고 윤년의 조건을 달아 4년마다 366일이 온다
// 그리고 2월 이전 3월 이후 기준이 존재

public class solvedac1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1[] = br.readLine().split(" ");
		String str2[] = br.readLine().split(" ");
		int y = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);
		int d = Integer.parseInt(str1[2]);
		
		int y1 = Integer.parseInt(str2[0]);
		int m1 = Integer.parseInt(str2[1]);
		int d1 = Integer.parseInt(str2[2]);
		
		int Day = 0;
		
		int Month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		// 천년 초과시
		if((y+1000 < y1) || (y+1000 == y1 && m < m1) || (y+1000 == y1 && m == m1 && d <= d1 )) {
			System.out.println("gg");
		}
		else { // 천년 초과시가 아닌 경우 계산
			for(int year = y+1; year < y1; year++) {
				// 윤년 체크
				if((year%4 == 0 && year%100 != 0) || year%400 == 0) {
					Day += 366;
				}else {
					Day += 365;
				}
			}
			
			// 년도가 같은 경우
			if(y == y1) {
				// 월 비교
				if(m == m1) {
					Day = Day + (d1-d);
				}else {
					for(int month = d+1; month<d1; month+=1) {
						Day  = Day + Month[month];
					}
					// 고민해야할 부분
					if(((y%4 == 0 && y%100 != 0) || y%400 == 0 ) && m <=2 && m1 <= 3) {
						Day++;
					}
					// 시작월
						Day = Day + Month[m-1] - d;
					// 종료월
					    Day = Day + d1;
				}
			}else { // 시작 년,월이 다를 때
				
				for(int month = 0; month < m1-1; month+=1) {
					Day = Day+Month[month];
				}
				
				for(int month = m; month < 12; month++) {
					Day = Day + Month[month];
				}
				
				
				// 시작년도가 윤년이고 시작월이 2월 이전인경우
				if(((y%4 == 0 && y%100 != 0) || y%400 == 0) && m <= 2) {
					Day+=1;
				}
				
				// 끝 년도가 윤년이고 종료월이 3월인 경우
				if(((y1%4 == 0 && y1%100 != 0) || y1%400 == 0) && m1 >= 3) {
					Day++;
				}
				
				// 시작월
				Day = Day + Month[m-1] - d;
				
				// 종료월
				Day = Day +d1;
			}
			System.out.println("D-"+Day);
		}
	}
}
