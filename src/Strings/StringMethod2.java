package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 10 20 30 40 */
/*1020 + 3040 = 4060*/
// 1 ¡Â A, B, C, D ¡Â 1000000
public class StringMethod2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String A =st.nextToken();
		String B =st.nextToken();
		String AB = A + B;
		String C =st.nextToken();
		String D =st.nextToken();
		String CD = C + D;
		System.out.println(Long.parseLong(AB) + Long.parseLong(CD));
		
		
	}
}
