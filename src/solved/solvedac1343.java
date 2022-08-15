package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* jdk > jre > jvm */
public class solvedac1343 {
	// 토큰 문제
	// AAAA BB
	
	
	// 문자열을 입력받는다
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int n = str.length();
			String ans = ""; // 결과 값
			int z = 0; // 의미있는 숫자 카운트
			
			boolean flag = false; // 대체 가능하다
			// 문자열을 순회하면서 X이면 TRUE , .이면 false => A,B로 대체될수 잇는지 체크
			for(int i = 0; i <n; i++) {
				char c = str.charAt(i);
				// TRUE 이면 Z++
				// Z 홀수 : = RETURN -1
				
				// Z 짝수 : 진행
				if(c == 'X') {
					flag = true;
					z++; 
				}else { // .
					// FALSE이면 Z = 0
					flag = false;
					
					if(z%2==1) {
						ans = "-1"; 
						break;
					}
					
					ans += ".";
					z = 0;
				}
				
				
				if(z !=0 && z%4 == 0) { // BB.BBAAA
					ans = ans.substring(0, i-3);
					ans += "AAAA";
					z = 0;
				}else if(z!= 0 && z%2 == 0) {
					ans += "BB";
//					z = 0;
					
				}
				
			}
			System.out.println( (z%2==1 || ans.equals("-1")) ?  -1 : ans);
	}
	
	
	
	
	
	
	
	
	
	// Z 가 짝수이면 토큰으로 가능
	
	// Z가 홀수 이면 -1
	
	
}
