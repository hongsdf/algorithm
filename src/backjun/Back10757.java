package backjun;

import java.math.BigInteger;
import java.util.Scanner;

// b1.add(b2) : b1 + b2;
// 
public class Back10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger B1 = sc.nextBigInteger();
		BigInteger B2 = sc.nextBigInteger();
		
		BigInteger B3 = B1.add(B2); // b1.add(b2) : b1 + 
		System.out.println(B3.toString());
		
	}
}
