package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

// 단어 뒤집기 
// baekjoon online judge -> noojkeab enilno egduj
// <open>tag<close> - > <open>gat<close>
// 구분 <>를 자르기


public class Wordreverse {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// <>안에 있는 배열로 구간을 받아서 < 시작하면 넘기고
		// <>시작하지 않으면 뒤집기
		
		String s = br.readLine();
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean flag = false; //태그가 시작되면 true
		for(char c : s.toCharArray()) {
			if(c == '<') { // '<'일때 st을 뒤집는 작업을 한다
				print(sb,st);
				flag = true; //태그 시작을 알린다.
				sb.append(c);
				
				// 참고사항
				// if절끼리는 동급이여서 조건이 맞은면 같이 출력되지만
				// else if절끼리는 위의 esle if절이 맞으면 *밑에 else if절은 조건에 맞더라도 skip*
				
				
			/* else if절 순서가 중요하다 (조건 1과 조건 2를 위치를 다르게 배치하면 안된다.) */
				// 조건 1
			}else if(c == '>') { //  태그 시작과 태그 종료부분을 붙혀서 배치
				flag = false; // 태그 종료
				sb.append(c);
				// 조건 2
			}else if(flag) {
				sb.append(c); // flag가 false가 될때까지
				
			/*else if절 순서가 중요하다 */
			}else {
				if(c == ' ') { // 공백이 나오면 문자열을 뒤집는다.
					print(sb,st); // 스택을 이용하여 뒤집기
					sb.append(c); // 마지막 공백(' ')도 입력받기
				}else {
					st.push(c); //st에 푸쉬
				}
				
			}
		
		
		}
		print(sb,st); // 나머지 태그안에 있는 것들이 있으면 뒤집기방법
		System.out.println(sb.toString());
	}

	private static void print(StringBuilder sb, Stack<Character> st) {
		while(!st.isEmpty()) {
			char c = st.pop();
			sb.append(c);
		}
		
	}
}
