package Strings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokener {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // StringTokenizer st : 
        // StringTokenizer(s) : 공백을 기준으로 문자열을 나눈다.
        // StringTokenizer(s, ",") : ,를 기준으로 s문자열을 나눈다.
        // StringTokenizer(s, ",!|?") : ,!|?를 기준으로 s문자열을 나눈다.
        // StringTokenizer(s, ",",true) : ,를 기준으로 s문자열을 나누고 (true)다음줄에 공백하여 출력, false(공백 x)
        StringTokenizer st = new StringTokenizer(s," !,?._'@",false);
        // countTokens() : 토큰의 갯수를 출력해주는 함수
        System.out.println(st.countTokens());
        // 토큰 출력 방법
        // st.hasMoreTokens() : 반복문을 통해 Token이 있을때까지 수행
        // st.nextToken() : 토큰을 하나씩 반환
        while(st.hasMoreTokens()) {
        	System.out.println(st.nextToken());
        }
        
        //  tokenizer.nextToken(); //다 소모한 객체에서 토큰을 뽑아내려고 시도. 예외 발생
        //  StringTokenizer의 기준으로 문자열을 잘라서 사용하면 다시 사용할수없다. => 에외발생 NoSuchElementException 
        
//        s.split(" ")
        
        scan.close();
    }
	
}
