package backjun;

import java.util.Scanner;

public class Star2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i< n; i++) {
			for(int j = n-1 ; j>=0; j--) { 
				if(i < j)  
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}

}
