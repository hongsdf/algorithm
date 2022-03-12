package algorithm;

public class DP1 {
	
	static int fib(int n) {
		
		if(n == 0) return 1;
		if(n == 1) return 1;
		else {
			return fib(n-1) + fib(n-2);
			// 1 1 2 
		}
		
	}
	
	
	public static void main(String[] args) {
		// 피보나치 수열
		int ans = fib(5);
		System.out.println(ans);
	}
}
