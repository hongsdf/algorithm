package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*스택을 활용할때
 * 앞 ->  뒤 로 방향정해져잇고
 * 앞에서 뒤로 갈때 특정기준을 가지고 계속 적용할때 생각해 볼 수 있다.
 * 어떠한 경우 stack에 push , 어떠한 경우 pop 할지 생각을 항상 해보자
 * 
 * ex) 오 큰수, 오등 큰수 , 후위표기법(차량기지)
 * 
 * ex) stack 에디터 문제 (커서 문제)
 * 
 * */



/* 차량기지 알고리즘 : 중위표기법 --> 후위표기법으로 바꾸는 알고리즘 
 * 
 *  정리
 *  ABCD...Z까지 등장한다
 *  1.중위표기법 -> 후위표기법 식으로 바꾸는 방법에서 출력값은 식 형태이므로 String형태로 반환
 *  String ans = ""; 생성
 *  
 *  2.피연산자는 ans+= 이어 붙히기를 할것이고, 연산자와 괄호를 신경써야한다
 *  먼저, 연산자간에는 우선순위가 존재한다 (* X / > + ,- 보다 연산 우선순위가 높다 이것을 비교하기 위해 따로 매서드를 만들어서 해결한다(비교방법이 없다) )
 * 	연산자를 stack에 담고 다음 연산자가 들어오면 while(!stack.isEmpty(){} 상단의 peek()값과 비교
 *  1.peek() 보다 작거나 같으면 answer += pop()
 *  2.peek() 보다 우선순위가 높으면 push()
 *  
 *  3.괄호
 *  ((A+B)/C + A/B ) 중위표기법을 봐도 괄호안에 괄호가 있는 식들이 존재한다.
 *  후위표기법의 장접은 괄호를 표기하지 않아도 우선순위가 보장된다는 점이다.
 *  후위표기법은 괄호를 출력하지 않지만 중위표기법 우선순위를 지켜줘야한다.
 *  
 *  ( 괄호가 나오면 그대로 push : 스택의 괄호문제는 열린괄호는 넣어준다
 *  
 *  ) 단힌 괄호가 나올때 문제
 * 	while(!stack.isEmpty()){
 * 	  다시 열린괄호가 나올때까지  stack.pop 연산자를 꺼낸다
 * 		if(c == ')') break; 열린괄호가 나오면 종료
 * }
 * 	결국 결과값은 괄호가 들어있지 않다
 *  
 *  4.연산자 우선순위 매서드
 *   따로 힘들게 구현할 필요없다 종류가 한정적이어서
 *   일단 비교를 하기 위해 int형으로 반환해야한다
 *   ( 괄호를 제일 낮은 순위 0
 *   + , - 우선순위 1
 *   나머지 * , / 우선순위 2로 만들자 (여기서 )괄호는 위의 조건문에 잇으므로 상관없다)
 *   
 * 
 * 
 * 
 * 
 *  스택에 연산자를 담는다 
 *  그리고 연산자위 상단이 다른 연산자보다 작거나 같을때 (우선순위를 챙김)
 *  무슨 뜻이냐?
 *  stack에는 + 연산이 들어 잇고 다음연산자는 x이다  + 는 X연산보다 (우선순위가 작거나 같다)
 *  그러면 push
 *  
 *  괄호가 있는 식의 경우에는
	• 여는 괄호는 연산자 스택에 넣고
	• 닫는 괄호가 나오면 여는 괄호가 나올 때까지 연산자 스택에서 계속해서 연산자를 꺼낸다 pop.
 *  
 *  
 *  
 * */

//  a + (b*c) == a bc*+
/* 예를 들어 a+b*c는 (a+(b*c))의 식과 같게 된다. 그 다음에 안에 있는 괄호의 연산자 *를 괄호 밖으로 꺼내게 되면 (a+bc*)가 된다.
   마지막으로 또 +를 괄호의 오른쪽으로 고치면 abc*+가 되게 된다.*/
public class BackOperate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		/*
		    중위 표기법대로 먼저 괄호를 묶는다 . flag 변수 사용?
 		    * , / 먼저 찾아내서 묶어야한다
 		    그리고 연산자를 하나씩 오른쪽으로 옮긴다.
 		    
		 */
		// 결과는 중위표기법 -> 후위표기법으로 바꾼식
		String answer = ""; 
		Stack<Character> stack = new Stack<>(); 
//		Stack<Character> stack2 = new Stack<>(); // 피연산자 스택
		
		
		for(char c : str.toCharArray()) {
			if(c >= 'A' && c <= 'Z') { //피연산자 이면
				answer+= c;
			}else if(c == '(') {
				stack.push(c);
			}else if(c == ')') {
				// 단힌 괄호가 나오면 st뒤집기 시작
				while(!stack.isEmpty()) {
					char ch = stack.pop();
					if(ch == '(') break; //괄호안의 ( 괄호가 다시등장하면 이런꼴 ( A + B * ( C * D ) + (C * B) )
					answer += ch; // 연산자를 담는다 ( 괄호가 나올때 까지
				}
			}else { // +, - ,* , /
				/* stack의 상단값보다 연산자 우선순위가 낮으면 pop                       */
				while(!stack.isEmpty() && precedure(stack.peek()) >= precedure(c)) { // stack의 상단의 값이 지금 확인한 연산자보다 우선순위가 높을때 
					
					answer += stack.pop();
				}// stack상단의 연산자보다 높은 값은 push 
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}
	// 연산자 비교 방법을 만드는 매서드
	private static int precedure(char c) {
		if(c == '(') return 0;
		if(c == '+' || c == '-') return 1;
		return 2; // * , / 는 우선순위가 높다
	}
}
