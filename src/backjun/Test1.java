package backjun;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
	
			while(n>0) {
				int a = n%10;
				sum +=a; 
				n = n/10;
			}
			System.out.println(sum);

	
	
	}
}
