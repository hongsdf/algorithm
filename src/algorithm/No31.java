package algorithm;

public class No31 {
	
	/*주요 요점
	 * n-1 + n-2 : 피보나치 수열의 개념 중요
	 * 1,2번항 조건정의 나머지는 n-1 + n-2 : 피보나치 수열의 개념 
	 * 
	 * 
	 * */
	static int finbonaci(int n) {
		// 1번항
		if(n == 1) {
			return 1;
		}
		// 2번항
		if(n == 2) {
			return 1;
		}
		// 그외항
		// 4  :       2      +      1  : 3
		return finbonaci(n-1) + finbonaci(n-2);
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		int n = 4;
		int answer;
		// 1-1-2-3-5-8
		answer = finbonaci(n);
		
		System.out.println(answer);
	}
}
