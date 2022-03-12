package recursive1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class reversestring {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String result = reverse1(s,"");
		System.out.println(result);
		
	}

	private static String reverse1(String s,String res) { 
		// abcd
		// TODO Auto-generated method stub
		if(s.equals("")) {
			return res; //  cd
		}
		
		
//		s = s.substring(0, s.length()-1);
		
		
		res += s.charAt(s.length()-1);
		return reverse1(s.substring(0,s.length()-1),res);
//		       reverse(s.substring(0,s.length()-1),res) ;
	}
	
}
