package backjun;

import java.util.Scanner;

public class Back2675 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0 ; i<n; i++) {
			int t = sc.nextInt();
			String str = sc.next();
			for(int v= 0; v < str.length(); v++) {
				for(int j = 0; j<t; j++) { 
					System.out.print(str.charAt(v));
					
				}
				
			}
			System.out.println();
		}
	}
}
