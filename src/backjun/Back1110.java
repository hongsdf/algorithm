package backjun;

import java.util.Scanner;

public class Back1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 0;
		int m2 = 0;
		int n1 = 0;
		int cnt = 0;

		// 26 = 2 + 6 = 68, 6+8 = 84,8+4 = 42, 4 + 2 = 26
		// 55 = 5 + 5 = 50, 5 + 0 = 05, 0 + 5 = 55
		n1 = n;

		do {
			m = n % 10; // 5,0,5
			m2 = n / 10; // 5,5,0
			if (m + m2 >= 10) {
				n = m*10 + (m + m2) % 10; // 50
			} else {
				n = (m * 10) + m + m2; // 5,50 +5
			}
			cnt++;

		} while (n != n1);

		System.out.println(cnt);

	}

}
