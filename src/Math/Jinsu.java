package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2진수 -> 8진수 
 
 	알고있는 정보 
 	진수를 8진수로 변환하기 위해 3개씩 묶는다
 	
 	16진수라면 
 	4개씩 묶는다.
 
 
  
  */
public class Jinsu {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		String str = br.readLine(); // 1 100 010 011
		int n = str.length();
		// 묶이지 않은 것에 대해 처리
		if(n %3 == 1) {
			System.out.print(str.charAt(0)); // 왜? 3개씩 묶인 값들은 숫자로 변환되었을 것이다.
			// 나머지가 1인 것은 묶이지 않은 것이므로 처리
		}else if(n%3 == 2) {
			// 나머지 2개 정리
			// str.charAt(0), str.charAt(1) 번 처리 2개
			System.out.print((str.charAt(0) - '0') * 2 + (str.charAt(1) -'0'));
		}
		// 묶인 것에 대해서 처리
		for(int i=n%3; i<n; i+=3) { 
			/* i = n%3 은 멀까 위해서 처리한 나머지 위치의  다음위치 부터 시작한다는 의미 */
			/* 그리고 증가식은 3씩 증가*/
			
			// str.charAt(0), str.charAt(1),str.charAt(2) 처리 3개
			System.out.print((str.charAt(i) -'0') * 4 + (str.charAt(i+1) - '0') *2  + (str.charAt(i+2) - '0'));
		}
		
	 }
}
