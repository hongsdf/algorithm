package Monster;

import java.util.Scanner;

public class Chapter_prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		boolean flag = prime2(number);
		System.out.println(flag == true? "소수입니다": "소수가 아니다" );
	}
	// O(sqrt(n))
	private static boolean prime(int number) {
		for(int i = 2; i<=(int)Math.sqrt(number); i++) {
			if(number % i == 0) { // 나누어지면 소수가 아니다
				return false;
			}
		}
		
		return true;
	}
	
	// 정수표현으로 사용하는 것이 좋다
	// O(sqrt(n))
		private static boolean prime2(int number) {
			if(number <= 1) { //예외처리 1보다 작은 값은 소수가 x
				return false;
			}
			for(int i = 2; i * i <= number; i++) {
				if(number % i == 0) { // 나누어지면 소수가 아니다
					return false;
				}
			}
			
			return true;
		}
	
}
