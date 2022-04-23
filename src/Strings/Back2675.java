package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Back2675 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T --> 0) {
			int n = sc.nextInt();
			String str = sc.next();
			solution(n,str,sb);
		}
		System.out.println(sb.toString());
	}

	private static void solution(int n, String str,StringBuilder sb) {
		for(int i = 0; i<str.length();i++) {
			for(int j = 0; j<n; j++) {
				sb.append(str.charAt(i));
				
			}
		}
	
		sb.append("\n");
		
	}
}
