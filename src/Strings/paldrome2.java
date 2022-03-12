package Strings;

import java.util.Scanner;

public class paldrome2 {

	public static boolean paldrome2(String s) {
		boolean flag = true; // abcba
		for(int i =0; i < s.length()/2 ; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				flag = false ;
			}
		}
		
		
		
		return flag;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean res = paldrome2(s);
		System.out.println(res);
	}

}
