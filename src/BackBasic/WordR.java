package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//baekjoon online judge -> noojkeab enilno egduj
//<open>tag<close> - > <open>gat<close>
//open<tag>close ->    nepo<tag>esolc
public class WordR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine()+"\n"; // "\n" 이것을 없애야 다음입력층에 남아 있는 개행문자가 없어 진다.
//		solve(s,bw);
//		solve2(s,bw);
		solve3(s,bw);
	}

	private static void solve3(String s, BufferedWriter bw) throws IOException {
		Stack<Character> st = new Stack<Character>();
		boolean flag = false;
		for(char c : s.toCharArray()) {
			if(c == '<' || c == '\n') {
				while(!st.isEmpty()) {
					bw.write(st.pop());
				}
				flag = true;
				bw.write(c);
			}else if(c=='>') {
				flag = false;
				bw.write(c);
			}else if(flag) {
				bw.write(c);
			}else {
				st.push(c) ;
			}
		}
		bw.flush();
			
		
	}

	private static void solve2(String s, BufferedWriter bw) throws IOException {
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		for(char c : s.toCharArray()) {
			if(c == '<') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				flag = true;
				bw.write(c);
			}else if(c == '>') {
				flag = false;
				bw.write(c);
			}else if(flag) {
				bw.write(c);
			}else {
				stack.push(c);
			}
		
		}
		bw.flush();
		
		
	}

//	private static void solve(String s, BufferedWriter bw) throws IOException {
//		// 뒤집기 stack 사용
//		
//		Stack<Character> stack = new Stack<>();
//		for(char c : s.toCharArray()) {
//			if(c == ' '|| c == '\n') { //공백이 발생될때 스택에 전부 뒤집기
//				while(!stack.isEmpty()) {
//					bw.write(stack.pop());
//				}
//				bw.write(c);
//			}else {
//				stack.push(c);
//			}
//		}
//		bw.flush();
//		
//	}
}
