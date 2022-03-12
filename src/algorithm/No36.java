package algorithm;

import java.util.Scanner;

/*점화식 문제(DP)*/
/* 1,2,3 숫자로 n을 표현하는 경우의 수
	1 = 1  : 1가지
	
	(2) : 2가지
	'1' + 1
	 2
	
(3) : 4가지
'1 + 1'  +1
'2 + 1'
1 + 2
3
(4) : 7 가지
'1 + 1 + 1'+ 1
'2 + 1' + 1
'1 + 2' + 1
'3' + 1

1 + 1 + 2
1 + 3
2 + 2
(5) 
'1 + 1 + 1 + 1' + 1
'2 + 1 + 1' + 1
'1 + 2 + 1' + 1
'3 + 1' + 1
'1 + 1 + 2' + 1
'1 + 3'+1
'2 + 2'+1
	
'1 + 1'  +1 + 2
'2 + 1' + 2
1 + 2 + 2
3 + 2

'1' + 1 + 3
	2 + 3




* [n] = [n-1] + [n-2] + [n-3] 

5C2  = 5 4 3 2 1/ 3 2 1 * 2 1 = 8
3C2 =  3 2 1 /  1 * 2 1
	 
	  	_ _
	  	a b
	  	b a
	  	a c
	  	c a
	  	c b
	  	b c 
*/



public class No36 {
	
	static int func(int n) {
		if(catche[n] != 0) { //catche[4] 을 입력하면 처음에는 catche[4] : 0 이므로
			return catche[n]; // 여기서 탈출
		}
		// 여기 실행
		//  4  = 1의 경우의수 + 2의 경우의수 + 3의 경우의 수 : 7
		return catche[n] = func(n-3) + func(n-2) + func(n-1);
	}
	
	static int catche[] = new int [1000];
	
	public static void main(String[] args) {
		 // 7가지 방법
		/* 주요 요점
		 * cathe[n] = ? : n을 표현할수 있는 경우의 수
		 * 
		 * 
		 * */
		
		catche[1] = 1; // 1을 표현할수 있는 경우의 수 
		catche[2] = 2; // 2을 표현할수 있는 경우의 수
		catche[3] = 4; // 3을 표현할수 있는 경우의 수 
		// catche[4] = cathe[1] + cathe[2] + cathe[3] 
		// cathe[n] : n을 표현할수 있는 경우의 수
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = func(n);
		System.out.println(answer);
		
		
	}
	
	
	
	
}
