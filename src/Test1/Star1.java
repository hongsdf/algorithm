package Test1;

import java.util.Scanner;

public class Star1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i <3; i++) {
			for(int j = 0; j <n; j++) {
				int k = n/2;
				if((j >= k -i) && (j <= k+i)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
