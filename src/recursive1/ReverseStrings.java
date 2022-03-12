package recursive1;

import java.util.Scanner;

public class ReverseStrings {
	public static boolean pal(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			return pal(s.substring(1, s.length() - 1));
			
		}
		
		return false;

	}

	public static void main(String[] args) {
		// kayak
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean flag = pal(s);
		System.out.println(flag);
	}
}
