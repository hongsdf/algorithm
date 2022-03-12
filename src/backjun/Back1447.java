package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Back1447 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = String.valueOf(N);
		
		
		String strN = br.readLine();
		char[] s2 = strN.toCharArray();
		Arrays.sort( s2 );
//		System.out.println(s);
		char[] s1 = s.toCharArray();
		Arrays.sort(s1);
		for(int i =s1.length-1; i>=0; i--) {
			System.out.print(s1[i]);
		}
		System.out.println();
		for(int i =s2.length-1; i>=0; i--) {
			System.out.print(s2[i]);
		}
		
	}
}
