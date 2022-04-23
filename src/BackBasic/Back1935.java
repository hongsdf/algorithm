package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*5
ABC*+DE/-
1
2
3
4
5

내가 문제를 이해한걸로는 이건
123*45/ -1

(3 + 2) × 3 - 4 → 3 2 + 3 ×4
32+3*4-

정보
-전위 표기법(PrefixNotation)은 연산자를 앞에 두는 방식이며, 폴란드 표기법(Polish
Notation) 이라고 한다.

-후위 표기법은 역폴란드 표기법(ReversePolishNotation)이라고도 한

생각한 고민

1. stack을 언제 넣지 배열이 필요하지 않을까?
2. ABC매칭이랑 중복값을 활용하기 위해 배열이 필요하나? -- 필요하다 라고 판명

*/
public class Back1935 {
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			double arr[] = new double[N];
			String str = br.readLine();
			/* 용법 배열1에서 <--> 다른 배열2 매칭 시키는 방법
				배열1과 배열2는 다르다
				서로 매핑을 하기 위해선 잘 생각해야한다
				여기서는 arr[0] <-> arr[c-'A'] 매칭 시키는 방법이다.
				생각은 arr[c-'A']이것을 보고 arr[0]을 매핑해보자
				
				
				stack에 push값은 arr[i]요소를 완성하는 것이다
				stack.push(arr[]) 시작
				stack.push()는 int 형이라 하면
				string에서 타입은 char 타입이므로 push할때 생각
				그리고 char타입인데 arr[]과 연관시켜야한다.
				st.push(arr[c])  처음요소가 arr[0]인덱스를 봐야한다.
				c == A라고 하자 c가 0이 되는 방법은 c-'A' 를 하면 0 이 됨
				st.push(arr[c - 'A']
			
			*/
			for(int i = 0 ; i <N; i++) {
				// ABC매칭이랑 중복값을 활용하기 위해 배열이 필요하나? -- 필요하다 라고 판명
				arr[i] = Double.parseDouble(br.readLine()); // {2,3,4}  라고 하면 A == 2
				
			}
			
			Stack<Double> st = new Stack<>();
			/* 이제  arr 배열에 잇는 각 원소를 매칭 ABCD...랑 매칭
			 */
			for(char c : str.toCharArray() ) {
				// 피연산자랑 연산자랑 구분
				if(c >= 'A' && c <='Z') {
					st.push( arr[(int)(c -'A')] ); // A가 뜻하는 건 1, 	B는 2, C는 3..
					
				}else{
					// 연산자가 나오면 pop
					Double d1 = st.pop();
					Double d2 = st.pop();
					if(c == '+') {
						st.push(d1 + d2);
					}else if(c == '-') {
						st.push(d1 - d2);
					}else if(c == '*') {
						st.push(d1 * d2);
					}else if(c == '/') { // 후위표기는 나누기 주의 거꾸로 
						st.push(d2 / d1);
					}
					
				}
			}
			System.out.printf("%.2f",st.pop()); //마지막 값
					
					
					
					
					
					
					
					
					
					
					
					
					
					
	}
}
