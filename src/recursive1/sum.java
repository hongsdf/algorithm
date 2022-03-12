package recursive1;

public class sum {
	public static int sumnum(int n) {
//		int result = 0;
		if(n == 1) {
			return n;
		}

		return n+sumnum(n-1);
	}
	
	
	
	
	public static void main(String[] args) {
		
//		int n = 10;
//		int sum = 0;
//		for(int i =1; i<=n; i++) {
//			sum +=i;
//		}
//		System.out.println(sum);
		
		
		int n =5;
		System.out.println(sumnum(n));
	}
	// 실행 순서
//	return : n+sumnum(n-1) 
	
											    // 1 종료
								     // 2 + sumnum(1)
						  // 3 + sumnum(2)
			   // 4 + sumnum(3)
	// 5 + sumnum(4)
	
	
}
