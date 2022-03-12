package backjun;

import java.util.Scanner;

public class IF_1 {

	public static void main(String[] args) {
		/*
		 * 첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) 그리고 이것은 현재 상근이가 설정한 놓은 알람 시간 H시 M분을 의미한다.
입력 시간은 24시간 표현을 사용한다.
 24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다. 시간을 나타낼 때, 불필요한 0은 사용하지 않는다.*/
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		
		if(H >= 0 && H <= 23 && M >= 0 && M <= 59) {
			clock(H,M);
		}


}

	 static void clock(int h, int m) {
//		 0h 0m = 0m
//		 0h 1m = 1m
//		 1h = 60m
//		 2h = 100m
//		   :
//		 11h = 660m
//		 12h = 720m
//		 13h = 780m
//		 14h = 840m
//		 	:
		 
//		 23h = 1380m
//		 23h 59m = 1,439
		 
//		 14h 30m => 870분 => 835 => 13시 55
		 
		 // 0 30 => 23 45 =  a  =  1,425 + 45
		 // 0 20 => 23 35
		 
		 
		 if(h == 0 && m < 45) {
			 h = 24;
		 }
		 int time = h * 60 + m -45;
		 h = time/60;
		 m = time - (h *60); // 835 - (13 * 60)	 
		 System.out.print(h);
		 if(m < 10) {
			String min = "0" + m;
			if(!min.equals("00"))
			System.out.println(min);
		 }else {
			 System.out.print(m);
		 }
//		  13 53
//		   1380 -> 1308

		 
//		System.out.println(h+"시"+m+"분입니다");
		
		
	}
}
