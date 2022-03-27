package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1541 {
//	55-50+40 = 55 - 90  = -35
//	55 -(50+30+60)
//	55 -(50+30+60) -60-70
//	50 -140 -130 = -220
	
	
//	55 -(50+30+60-60-70)
//	50 -140 -130 = -220
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] s1 = s.split("-");
//		for(String s2:s1) System.out.println(s2);
		
		//------------------------------------------
		// 첫수는 양수이기 때문에 미리 넣고 시작한다 : 하지만 이것도 에러가 발생한다
		// 이유 ? : 10+20+30+40 처음부터 - 기호가 없으면 분리가 되지 않은 상태이므로 10+20+30+40값인 문자열을 더할수 없다
		// java.lang.NumberFormatException : 넘버 형식 에러
		// int answer = Integer.parseInt(s1[0] );
	    //	------------------------------------------------
		
		int answer = Integer.MAX_VALUE;
		
		
		for(int i = 0; i<s1.length; i++) {
			int sum = 0;
			// -기준으로 분리된 배열안에서 다시 +로 배열을 나눈다 핵심
			String[] s3 = s1[i].split("\\+"); // 정규식 에러
			for(int j =0; j <s3.length; j++) {
				// +으로 나눈배열의 원소를 더한다.
				sum += Integer.parseInt(s3[j]);
			}
			
			// 에러 : java.util.regex.PatternSyntaxException
			// String[] s3 = s1[i].split("+"); 이렇게 자르면 안됨 : 정규식 에러발생
			
			if(answer == Integer.MAX_VALUE) { // 이 블록은 첫수를 넣는 작업
				answer = sum;
			}else {
				answer -= sum; // 더한 값들을 뺀다.
				
			}


		}
		
		System.out.println(answer);

	}
	
}
