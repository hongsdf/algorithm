package algorithm;

public class No33 {
	
	static void num2(int x) {
		if(x/2 == 0) {
			int result = x%2;
			System.out.print(result);
			return;
		}
		num2(x/2); //10/2 , 5/2, 2/2, 1/2 ( stack )
		System.out.print(x%2);
		
	}
	
	
	public static void main(String[] args) {
		/* 10진수를 2진수로
		 * 
		 * 
		 * 10 :  1010 == 2+8  
		 * 10%2 == 0 && 10/2 = 5 
		 * 5%2 == 1 && 5/2 = 2
		 * 2%2 == 0 && 2/2 = 1
		 * 1%2 == 1 && 1/2 = 0
		 * 
		 *    
		 * 17 : 10001 == 16 + 1
		 * 
		 * 17%2 == 1 && 17/2 = 8 
		 * 8%2 == 0 && 8/2 = 4
		 * 4%2 == 0 && 4/2 = 2
		 * 2%2 == 0 && 2/2 = 1    
		 * 1%2 == 1 && 1/2 = 1    
		 *    
		 */
		
		int n = 10;
		
		num2(n);
	}
}
