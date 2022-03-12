package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class world2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true) {		
			s = br.readLine();
//			s = s.replaceAll("[a-zA-Z ]", ""); // 문자를 대체하지 않음
			
			if(s.equals(".")) {	// 종료 조건문 
				break; //. 을 입력하면 종료
			}		
			System.out.println(solution(s));
		}
		
		
//		String s = br.readLine(); 
//		String rs = solution(s);
//		System.out.println(rs);
		
	}

	private static String solution(String s) {
		Stack<Character> st = new Stack<>();
		for(int i =0; i <s.length(); i++) {
			char c1 = s.charAt(i);
			
			if(c1 == '(' || c1 == '[') { // 열린괄호는 push
				st.push(c1);
			}
			else if(c1 == ')') { // 닫힌 괄호를 집중
				if(st.isEmpty() || st.peek() != '(') {
					return "no";
				}else {
					st.pop();
				}
			}
			else if(c1 == ']') { // 닫힌 괄호를 집중
				if(st.isEmpty()  || st.peek() != '[') { // st.isEmpty() :를 넣는 이유
					// []]] 입력했다고 가정하자
					// 1단계 [] 가 삭제되었다
					// ] 이 들어올때 c1 == ']'을 만나게 되었다. 그런데 st.peek()문에 에러가 발생한다 왜냐하면 st가 비어있어 
					// peek 할 수없기때문이다
					// 그래서 st.isEmpty() 조건을 추가해야한다.
					return "no";
				}else {
					st.pop();
				}
			}
			
		}
		
		if(st.isEmpty()) {
			return "yes";
		}else {
			return "no";

		}
		
		
	}
}
