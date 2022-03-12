package datastructure;

import java.util.Scanner;

public class Try_catch {
	static int B, H, area; // 정적 클래스 변수 static 변수를 사용하는이유: 
	static boolean flag;
	static {
		Scanner sc = new Scanner(System.in);
		B = sc.nextInt();
		H = sc.nextInt();

		sc.close();
		try {
			if (B <= 0 || H <= 0) {
				throw new Exception("Breadth and height must be positive");
			} else {
				System.out.println(B * H);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}// end of main

}// end of class
