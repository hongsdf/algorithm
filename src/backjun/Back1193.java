package backjun;

import java.util.Scanner;

public class Back1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pre_cnt_tot = 0; // 누적합
		int cross_num = 1;
//		T == 1+1 = 2, T 1+2 /2+1 == 3,T : 1+3,2+2 4
//		T-1 : 원소 갯수 
		
		int n = sc.nextInt();
		while(true) { // n == 8
			// 입력한 수  <= 대각선직전까지 누적합 + 입력한수의 대각선원소 갯수 cross_num : 2 ==> 1
			if(n <= pre_cnt_tot + cross_num) { 
				if(cross_num % 2 == 1) { // 홀수 일대 왼쪽아래방향
					// 분모가 큰수부터 시작
					System.out.println((cross_num -(n-1-pre_cnt_tot)) +"/"+ (n - (pre_cnt_tot)));
					break;	   	       
				}else { // 짝수 오른쪽 위
					// 분자가 큰수부터 시작4
				} System.out.println((n - (pre_cnt_tot)) +"/" +(cross_num -(n-1-pre_cnt_tot)) );
				break;    
				// cross_count변수는 현재 T(대각선)의 원소 개수,
				// cross_num + 1 -n + pre_cnt_tot
//				3 <= 1 + 2;
//				4 <= 3 +3;
//				7 <= 6 + 4;
//				14 <= 10 + 5;
				
//				cross_num ==7 일때
//				16 <= 15 + 6;
//				17 <= 15 + 6;
//				18 <= 15 + 6;
//				19 <= 15 + 6;
//				20 <= 15 + 6;
//				21 <= 15 + 6;
				
//				cross_num == 8 일때
//				22 <= 21 + 7;
				
				
//				1 < = 1+0;
				
				
				
				
			}else {
				// tot : 0 , cross = 1,
				// tot : 1  , cross =2,
				// tot : 3,  cross = 3,
				// tot : 6,  cross = 4
//				cross_num : 1증가 += 전 원소 갯수
//				cross2 += cross1;
//				cross3 += cross2;
				pre_cnt_tot += cross_num;
				// cross_num(2) 까지 원소 갯수
				cross_num++; // 3
			}
			// pre_cnt_tot    cross_num
			//     0              1
			//     1              2
			//     3              3
			
		}
		
		
	}
}
