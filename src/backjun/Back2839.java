package backjun;

import java.util.Scanner;

public class Back2839 {
	static final int a = 3;
	static final int b = 5; // 8 : 5 + 3, 16 5+5+3+3, 7: 5 + 3, 3 :
	static int cnt = 0;
	static int min = Integer.MAX_VALUE;

	static void recursive(int n) { // 16 21: 18 15 10 5 0
//		System.out.println(n);
		// recursive(15) // 8 3
		// 8 :
		if( n %5 == 0) { // 11  cnt : 3 -> recursive(11) 6 recursive(6) 1  recursive(1)
			n -= 5;
			cnt++;
		}
		else if(n >= 3) {
			n -=3;
			cnt++;
		}
		else {
			System.out.println(-1);
			return;
		}
		
		
//		n -= b; // 10 - 5 = 5 15-5 =10

		if (n == 0) {
			System.out.println(cnt);
			return;
		}
		
	 //recursive(6) , recursive(3)
		recursive(n); // return(10) --> return(5) ---> n==0
		
		
		// recursive(10) --> recursive(5) --> sysout( 0 : ) --> recursive(5) -->
		// recursive(10)

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		recursive(n);

//		if (min > cnt) {
//			min = cnt;
//		}

//		System.out.println(min);
  // 31 = 5*5 3*2
	}
}
