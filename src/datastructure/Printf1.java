package datastructure;

import java.util.Scanner;

public class Printf1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
//			int x = sc.nextInt();
			Double d = sc.nextDouble();
			// Complete this line
			System.out.printf("%-15s %.5f %n",s1,d); // "%-15s : 왼쪽으로 15만큼, %03d : 정수를 3칸으로 하고  
			System.out.println();
			// "%-15s : 왼쪽으로 15만큼, %03d : 정수를 3칸으로 하고 3칸이 미만일때 앞에 0으로 채워 3자리로 맞춘다.
			// %n : 줄바꿈
			// %b%n : boolean 하고 줄바꿈, %s :문자열 출력, %5d :정수 5자리, %.3f : 실수 (소수점 3자리까지 반올림) 
		}
		System.out.println("================================");

	}

}
