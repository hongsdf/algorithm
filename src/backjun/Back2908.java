package backjun;

import java.util.Scanner;
public class Back2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int hundred = (n % 10) * 100;
		int ten = ((n / 10) % 10) * 10;
		int one = n / 100;
		int sum1 = hundred + ten + one;

		int hundred2 = (m % 10) * 100;
		int ten2 = ((m / 10) % 10) * 10;
		int one2 = m / 100;
		int sum2 = hundred2 + ten2 + one2;

		if (sum1 > sum2) {
			System.out.println(sum1);
		} else
			System.out.println(sum2);

	}
}
