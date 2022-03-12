package backjun;

import java.util.Scanner;
public class Back2292_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int range = 2;
		int count = 1;
		if(n == 1) {
			System.out.println(1);
		}
		else {
			while(range <= n) {//2 ~ 7 n : 23 : 4
				range = range +(6 * count);
				count++;
			}
				
			System.out.println(count);
		}
	}
}
