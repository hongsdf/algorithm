package Strings;

import java.io.*;
import java.util.*;
public class No1 {
	public static String upperthree(String str) {
		char c[] = str.toCharArray();
		if(c.length < 4) return null;
		
		for(int i =1; i<4; i++) { // 1 2 3
			c[i] = Character.toUpperCase(c[i]);
		}
		
		
		
		
		return new String(c);
		
		
	}
	
	
	public static String uppercaseFirst(String str) {
			char arr[] = str.toCharArray(); // toCharArray : 문자열을 배열
			arr[0] = Character.toUpperCase(arr[0] );
			
			return new String(arr); // 배열을 다시 문자열로
			
		}
	
	    public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        String B=sc.next();
	        /* Enter your code here. Print output to STDOUT. */
	        System.out.println(A.length() + B.length());
	        int c = A.compareTo(B);
//	        System.out.println(c);
	        if(c < 0) System.out.println("NO");
	        else System.out.println("YES");
	        System.out.println(uppercaseFirst(A)+" "+ uppercaseFirst(B));
	        System.out.println(upperthree(A)+" "+upperthree(B));
	    }
	

}
