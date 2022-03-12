package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.util.LinkedList;
import java.util.Stack;

public class world {
	public static void main(String[] args) throws IOException {
		// So when I die (the [first] I will see in (heaven) is a score list).
//		[ first in ] ( first out ).
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
//		String str = "a_bcd";
		System.out.println(str);
//		String regex = Format.
		str = str.replaceAll("[a-zA-Z .]", "");
		System.out.println(str);
		char[] c1 = str.toCharArray();
//		Stack<Character> st = new Stack<>();
		LinkedList<Character> st = new LinkedList<>();
		
		for(int i=0; i<c1.length; i++) {
			char c2 = c1[i];

			if(c2 == '(' || c2 =='[') {  // 괄호 문제 핵심을 다뤄보자
			    // 1.먼저 스택에 구현할때 ), ]	닫힌 괄호가 들어가면 바로 탈락이다
				// 2. 그래서 ( , [ 처음 넣을 수 있는 괄호는 열린 괄호
				// 3. (열린괄호는 계속 push한다) 개념
				// 4.  닫힌 괄호는 조건을 따져야한다.
				// 4-1 괄호의 종류에 따라 조건문을 적고
				// 해당괄호의 종류의 닫힌 괄호가 아니면 실패 || 그리고 st가 비어있으면 안된다 (1번 조건해당)
				// 해당괄호의 종류의 열린 괄호이면 pop
			
				st.push(c2);
			}
			else if(c2 == ')') {
				
				if(st.isEmpty() || st.peek() != '(') {
					System.out.println("no");
					break;
				}else { // st.peek == '('
					st.pop();
				}
			}else if(c2 == ']') {
				
				if(st.isEmpty() || st.peek() != '[') {
					System.out.println("no");
					break;
				}else  {
					
					st.pop();
				}
			}
		}
		
		if(st.isEmpty()) {
			System.out.println("yes");
		}
		
		
		
		
//		if(st.isEmpty() || st.pop() == '.') {
//			System.out.println("yes");
//		}else {
//			System.out.println("no");
//		}
		
//		for(int i =0; i<c1.length; i++) {
//			if(st.isEmpty()) {
//				st.push(c1[i]);
//				
//			}else {
//				if(st.peek() == '[' && c1[i] ==']') {
//					st.pop();
//				}
//				if(st.peek() == '(' && c1[i] ==')') {
//					st.pop();
//				}
//			}
//			
//			
//			
//		}
//		while(!st.isEmpty()) {
//			char curr = st.pop();
//			System.out.print(curr+" ");
//		}
		
//		
//		for(int i =0; i<c1.length; i++) {
//			if(st.isEmpty()) {
//				st.push(c1[i]);
//			}else {
//				if(st.peek() == '[' && c1[i] == ']') {
//					st.pop();
//				}
////				if(st.peek() =='(' && c1[i] == ')') {
////					st.pop();
////				}
//			}
//		}
//		
//		while(!st.isEmpty()) {
//			int curr = st.pop();
//			System.out.println(+curr+" ");
//		}
	}
}
