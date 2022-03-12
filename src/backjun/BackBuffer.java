package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackBuffer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// buffer로 한글자 입력 받는 방법
		// br.readLine()는 문자열 한줄을 입력 받는다
		// 한글 자 씩 입력 받기 위해서 br.readLine().replace(arg1 ,ag2 )
		// replace(arg1 ,ag2 )의 의미 : arg1을 arg2로 모두 대체한다
		// a b c를 입력받으면 --> abc공백 대체
		// br.readLine().replace(" ","").toCharArray() 받아 한글자 씩 출력이 가능하게 한다.
		char[] s1 = br.readLine().replace(" ", "").toCharArray();
		for(char c:s1) {
			System.out.print(c);		
		}
	}
}
