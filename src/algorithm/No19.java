package algorithm;

public class No19 {

	public static void main(String[] args) {
		/* 5^3 = 123*/
		
		// 5 * 5 * 5 = 125
		
		int n = 8;
		
		int total = 1;
		for(int i = 0; i < 3 ; i++) {
//			System.out.print(n);
			total *= n;
		}
		System.out.print(total);

	}

}
