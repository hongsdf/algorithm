package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;

// 1000000
// O(n)
public class Chapter4_primeNumber {
	public static final Scanner scanner = new Scanner(System.in);

	public static void testCase(int caseIndex) {
		long N = scanner.nextLong();

		// N을 소인수 분해한다
		ArrayList<Long> factors = MathUtil1.factorize(N);

		// 정답을 출력한다
		System.out.printf("#%d:\n", caseIndex);
		for (int i = 0; i < factors.size(); i += 1) {
			System.out.print(factors.get(i));
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}

class MathUtil1 {
	/**
	 * 자연수 N을 구성하는 모든 소인수를 반환하는 함수
	 *
	 * @param N
	 * @return
	 */
	public static ArrayList<Long> factorize(long N)
	{
		ArrayList<Long> factors = new ArrayList<>();
		// 내가 구현한 방법
//		 while(N > 1){
//		 	for(long i = 2; i<=N; i++){
//		 		if(N % i == 0){
//		 			factors.add(i);
//					N/= i;
//		 			break;
//		 	}
//		 }
			
		// native
//			 for(long i = 2; i <= N; i++){
//			 	while(N % i == 0){ // 같은 소인수로 나누어지면 계속 나눈다 ex) 2,2,2..
//			 			factors.add(i);
//			 			N/=i;
//			 }
//		}
			 
		// optimal solution
	    // ex) number := 14인 경우
		for(long i = 2; i*i <= N; i++){ // sqrt(n) 까지만 살피기
			while(N % i == 0){ // 같은 소인수로 나누어지면 계속 나눈다 ex) 2,2,2..
				factors.add(i);
				N/=i;
			}
		}
		
		// 여기까지 오면 루트(N)까지 인수를 다 비교한것이다.
		// 만약 N이 1보다 크면 N은 소수인 것이다.
		if(N > 1){
			factors.add(N);
		}

		return factors;
	}
}