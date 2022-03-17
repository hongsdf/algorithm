package leetcode;
import java.util.*;

public class Correctgwalho {
	public static void main(String[] args) {
		Solution1 m = new Solution1();
		String s = "))(("; // () ()()()
		// "() ))((()" "() (())()"
		String ans = m.solution(s);
		System.out.println(ans);
	}
}
class Solution1{
	int pos = 0;
	
	public String solution(String s) { // 매개변수로는 균형잡힌 문자열
		if(s.equals("")) return s;
		
		boolean flag = isCorrect(s); // 올바른 문자열 인지 판단
		String u = s.substring(0,pos);
		String v = s.substring(pos,s.length());
		
		// s가 올바른 문자열이라면
		if(flag) {
			return u + solution(v);
		}
		
		//올바른 문자열이 아니라면
		String answer = "("+solution(v) + ")";
		// 처음과 마지막 문자열을 빼고 뒤집기
		for(int i = 1; i< u.length()-1 ; i++) {
			if(u.charAt(i) == '(') {
				answer += ")";
			}else {
				answer +="(";
			}
		}
		
		return answer;
	}

	
	private boolean isCorrect(String s) {
		boolean correct = true;
		int left = 0; int right = 0 ;
		Stack<Character> st =new Stack<Character>();
		// u,v 분리
		for(int i = 0; i <s.length(); i++) {
			// 괄호 갯수 세기 , 올바른최소문자열찾기
			if(s.charAt(i) == '(') {
				left++;
				st.push(s.charAt(i));
			}else {
				right++;
				if(st.isEmpty()) {
					correct = false;
//					return false; // false로 변경해도 종료하면 안됨
					// 결국 찾아야하는 것은 올바른 문자열을 꼭 찾아야하기때문
				}else {
					if(st.peek() != s.charAt(i)) {
						st.pop();
					}
				}
			}
			
			if(left == right) {
				//올바른 문자열 최소길이 찾기
				pos = i + 1;
				return true ;
			}
		
		}
		
		return correct;
	}
}