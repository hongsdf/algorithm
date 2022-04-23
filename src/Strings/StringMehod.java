package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*예를 들어, "Baekjoon Online Judge"를 ROT13으로 암호화하면 "Onrxwbba Bayvar Whqtr"가 된다.
  ROT13으로 암호화한 내용을 원래 내용으로 바꾸려면 암호화한 문자열을 다시 ROT13하면 된다.
   앞에서 암호화한 문자열 "Onrxwbba Bayvar Whqtr"에 다시 ROT13을 적용하면 "Baekjoon Online Judge"가 된다.

    ROT13은 알파벳 대문자와 소문자에만 적용할 수 있다.
     알파벳이 아닌 글자는 원래 글자 그대로 남아 있어야 한다. 예를 들어, "One is 1"을 ROT13으로 암호화하면 "Bar vf 1"이 된다.
     
      대문자는 대문자끼리 += 13 || -= 13
      소문자는 소문자끼리 -= 13 || -= 13
      
     */
public class StringMehod {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String ans = "";
		for( char c : str.toCharArray()) {
			if(c >= 'A' && c <= 'Z' ) { // 대문자
				if( c -'N' >= 0) {
					c -= 13;
					ans += c;
				}else {
					c += 13;
					ans += c;
				}
			}else if(c >= 'a' && c <='z') {// 소문자
				if( c - 'n' >= 0) {
					c -= 13;
					ans += c;
				}else {
					c += 13;
					ans += c;
				}
			}else { //공백
				ans += c;
			}
		}
		System.out.println(ans);
	}
}
