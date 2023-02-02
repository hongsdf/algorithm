package Groom;
import java.io.*;
import java.util.*;

public class Groom2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char c[] = input.toCharArray();
		// a b c d e f g h i j k l m n o p q r s t u v w x y z 
		// z4z4
		// z5 -> f
		// z6 -> j
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i+=2){
			 int word = c[i] -'a'; // a b c e
			 int n = c[i+1]-'0';  // 1 2 3 4
			
			  n = (int) Math.pow(n,2);
			  // int c1 = 'z'- 'a'; // 25
			  // 순환횟수 
			  // 26 + 9 = 35 % 26 = 9 
			  // 26 + 4 = 30 % 26 = 4
			  //
//			  25 + 4 = 29 % 26 = 8
			  
			// 순환횟수를 찾는다.
			// A ~ Z : 26가지
			 int a  = (word+ n)%26 +'a' ;
			sb.append( (char)a);
		}
		System.out.println(sb.toString());
		
		
	}
}
