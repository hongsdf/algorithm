package BackBasic;

import java.util.Scanner;

// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
// 테스트 케이스 수가 없다. (끝을 알수 없다)

public class Back10951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num < 5) {
			System.out.println("5보다 작다");
		}else if(num >= 5) {
			System.out.println("5보다 같거나 크다");
		}else if(num >= 5) {
			System.out.println("10보다 크거나 같다");
		}else {
			System.out.println("해당 없음");
		}
		
		/* if절은 동급임 두개 조건을 확인*/ 
		/* else if절은 동급이 아니여서 위에 else if절이 맞으면 밑에 else if절도 맞더라도 수행 되지 않음*/
//		if(num < 5) {
//			System.out.println("5보다 작다");
//		} 
//		if(num <= 15) {
//			System.out.println("10보다 크거나 같다");
//		}else if(num == 15){
//			System.out.println(15);
//		}
		
	}
}
