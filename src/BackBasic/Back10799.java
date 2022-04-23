package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반드시 레이저를 표현한다.
	쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다. */
public class Back10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pipe = br.readLine();
		solve(pipe);
	}
	//()(((()())(())()))(())
	// 열린괄호만 st에 push
	// 닫힌 괄호가 나오면 체크
	// 1. 이웃한 열린괄호랑 번호차이 -1
	// 2. 1차이가 아니면 파이프의 끝이는 의미
	private static void solve(String pipe) {
		char c[] = pipe.toCharArray();
		Stack<Integer> st = new Stack<>();
		int sum = 0;
		for(int i = 0; i <c.length; i++) {
			char word = c[i];
			if(word == '(') {
				st.push(i);
			}else {
				int num = st.peek();
				if(i - num == 1) { // 레이저라는 의미
					st.pop();
					sum += st.size();
				}else {
					st.pop();
					sum++;
				}
			}
		}
		System.out.println(sum);
		
	}
}
