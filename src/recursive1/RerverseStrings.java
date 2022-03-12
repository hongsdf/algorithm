package recursive1;

import java.io.BufferedReader;

public class RerverseStrings {
	public static void main(String[] args) {
		
		String s = "dcba";
		String ans = reverse(s,"");
		System.out.println(ans);
	}
	public static String reverse(String s,String res) {
		// base-case
		if(s.equals("")) {
			return res;
		}
		res += s.charAt(s.length()-1); // abcd
		return reverse(s.substring(0,s.length()-1),res) ;
		
		
		
		
	}
//	 순서
//	res(문자열의 제일끝)   reverse(,)
//	a 				   dcb(0부터 마지막전까지) res : a
//  b 				   dc(0부터 마지막전까지) 	res : ab
//	c				   d(0부터 마지막전까지) 	res : abc
//	d				   (0부터 마지막전까지) 	res : abcd
//                     
//	결론 : return abcd
}
