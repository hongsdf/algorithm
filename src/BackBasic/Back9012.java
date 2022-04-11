package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
 *  그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
 *   한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
 *    만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
 *     그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
 *      예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 

여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. */


// 보통 괄호 문제에서는 일반적으로 *열린 괄호를 체크한다
// st에 닫힌 괄호를 넣지 않고 열린괄호를 넣고
// 닫힌 괄호가 나오면 가까운 열린괄호중 (짝이 맺어지지않는 열린괄호)를 만나 pop()이 된다.



public class Back9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			String s = br.readLine();
			// 열린괄호가 중요하다
			int cnt = 0;
			for(char c : s.toCharArray()) {
				if(c =='(') {
					cnt++;
				}else {
					cnt--;
				}
				
				if(cnt < 0) { // 0 이 되는 순간 닫힌 괄호의 수가 더 많다는 뜻 ( 닫힌괄호는 열린괄호를 찾을때 앞에 잇는 열린 괄호만 찾게 된다)
					break;
				}
			}
			if( cnt == 0) {
				bw.write("Yes\n");
			}else {
				bw.write("No\n");
			}
			
		}
		bw.flush();
		
	}
}
