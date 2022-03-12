package Strings;

import java.util.Scanner;
import java.util.regex.*;

public class Regex1 {

	private static final int CASE_INSENSITIVE = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
//			String pattern = "[a-zA-Z][ !@#$%^&*(),.?\\\":{}|<>]*$";
			String p = in.nextLine();
			String p1 = "?";
			// Write your code
			try { // 이게 된다고 하면 try문 실행
//				Pattern.compile(p);
				// CASE_INSENSITIVE : 대소문자 구분하지 않음.
				Pattern.compile(p,CASE_INSENSITIVE );
				System.out.println("valid");
			}catch (Exception e) {
				System.out.println("Invalid");
			}
			testCases-- ;
			
		}
		in.close();
	}
	

}
