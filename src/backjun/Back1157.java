package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int mode[] = new int[26];
		int cnt = 1; int max = 0;
		int pre = 32;
		char c = ' ';
		
		for (int i = 0; i < str.length(); i++) { // bba
			char s = str.charAt(i);
			if(s >= 'a') { //A :65 , 
				s = (char) (s - pre) ; // 97 - 32 = 65 ,66
				// System.out.println(s);
			}
			for (int j = 0; j < mode.length; j++) {
				// 대문자 65 ~ 90  소문자 97 ~ 122
				if (s == 'A' + j) {
					mode[s - 'A']++; // mode[1] = 2, mode[0] = 1
					
				}
				

			}

		}
		
		for(int i = 0; i <26; i++) {
			 if(max < mode[i]) {
				 max = mode[i];
				 c = (char)(i+65); // b = 66
			 }else if(max == mode[i]) {
				 c = '?';
			 }
			
		}
		System.out.println(c);
		

		
	}

}
