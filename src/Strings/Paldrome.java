package Strings;

import java.io.*;
import java.util.*;

public class Paldrome {
	static boolean paldrom(String s) {
		boolean flag = true;
		for(int i =0; i<s.length()/2;i++) {
			if(s.charAt(0+i) != s.charAt((s.length()-1)-i)) flag = false;
			
		}
//		madam
		
		return flag;
	}

	
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        boolean res = paldrom(A);
        System.out.println(res);
        
    }
}