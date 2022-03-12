package backjun;

import java.util.Scanner;


public class Test3 {
	public static boolean[] prime;
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		
		prime = new boolean[N + 1]; // 공간 생성
		get_prime(); // 작업후 prime공간에 T,F를 각각 세김
				
		for(int i = M; i <= N; i++) {
			// false = 소수 
			if(!prime[i]) System.out.println(i);
		}
	}
 
 
	// 에라토스테네스의 체 알고리즘
	public static void get_prime() {
		// true = 소수아님 , false = 소수 
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) { // 제곱근 메서드
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) { //  4 5 6 8 9
				prime[j] = true;						//     T F T T T
 			}
		}
	}
}