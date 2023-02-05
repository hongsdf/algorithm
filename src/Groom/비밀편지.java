package Groom;

import java.io.*;
class 비밀편지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T -->0){
			String str1 = br.readLine();
			String str2 = br.readLine();
			char command = str2.charAt(0); //E or D
			str2 = str2.substring(2,str2.length());
			if(command == 'E'){
				// HELLO
				// KEY
				// A : 65 Z :90  a : 97, z : 122
				// K : 75%26 = 23
				// E : 69 %26 = 17 - >26 -17
				// Y : 89%26 = 11 -> 15
				// HELLO GOORM!
				// KEYKEY 
				// k 
				// ABCDEFGHIJKLMNOPQRSTUVWXYZ
				String answer = solve(str1,str2);
				System.out.println(answer);
			}else{ // D
				 String answer = solve2(str1,str2);
				System.out.println(answer);
			}
			
		}
		
		// shift : z-> a, 'Z'->'A'
		
		// E : 암호화
		
		
		// D : 복호화
	}
	
	public static String solve2(String str, String str2){
			String temp ="";
			for(int i = 0; i <str.length(); i++) {
				int alphabet = str.charAt(i);
				int num = str2.charAt(i%str2.length()) %26;
				if(alphabet >= 'a' && alphabet <= 'z') {
					temp += (char)((alphabet + (26 - (num %26))-'a')%26 + 'a');
				}else if(alphabet >= 'A' && alphabet <= 'Z') {
					temp += (char)((alphabet + (26 - num % 26)-'A')%26 +'A');
				}else {
					temp += (char)alphabet;
				}
			}
		
			return temp;
	}
	public static String solve(String str, String str2){
			String temp ="";
			int size = str2.length();
				for(int i = 0; i <str.length(); i++){
					int alphabet = str.charAt(i); // H : 73 ,E : 70
					int num = str2.charAt(i%size)%26;
					// 소문자 
					if(alphabet >= 'a' && alphabet <= 'z' ) {
						temp += (char)((alphabet - 'a' + num) % 26 + 'a');
					}
					// 대문자
					else if(alphabet >= 'A' && alphabet <='Z') {	
						temp += (char)((alphabet - 'A' + num) %26 + 'A');
					}
					else {
						temp += (char)alphabet;
					}
				
				
			}
		
			return temp;
	}
	
}