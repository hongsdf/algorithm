package Strings;

import java.util.Scanner;

public class SubString {
	public static void main(String[] args) {
		 System.out.println("abc");
	     String cde = "cde";
	     System.out.println("abc" + cde);
	     String c = "abc".substring(1,3);
	     String d = cde.substring(1, 2);
	     System.out.println(c);
	     System.out.println(d);
	     
	     String str = "abc";
	     char cha [] = str.toCharArray();
	     System.out.println(new String(cha));
	     
	     
	     Scanner in = new Scanner(System.in);
	        String S = in.next();
	        int n = in.nextInt();
	        int m = in.nextInt();
	        String res = S.substring(n,m);
	        System.out.println(res);
	      
	}
	

}
