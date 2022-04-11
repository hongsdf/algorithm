package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 
  단어는 영어 알파벳으로만 이루어져 있다.*/ 
// stack은 뒤집기 작업 하기에 유용  *중간에 잇는 원소가 수정되야하면 stack를 쓰는 것이 아니다.
// 여기 주의 할점 한줄안에 공백(개행문자가 포함되어있을경우 ) 개행문자도 한글자로 취급해야한다.

public class Back9093 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			String s = br.readLine()+"\n"; // 궁금중?
			Stack<Character> st = new Stack<>();
			for(char c : s.toCharArray()) { 
				if(c == '\n' || c == ' ') { // 개행문자라면 그때 뒤집기 시작
					while(!st.isEmpty()) {
						bw.write(st.pop());
					}
					bw.write(c); // 개행문자 출력
				}else {
					st.push(c);
				}
			}
			
		}
		bw.flush();
	}
}
