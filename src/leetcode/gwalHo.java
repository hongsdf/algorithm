package leetcode;

import java.util.HashMap;
import java.util.*;

public class gwalHo {
	public static void main(String[] args) {
		Solution30 m = new Solution30();
		String s = "))(("; // () ()()()
		// "() ))((()" "() (())()"
		String ans = m.solution(s);
		System.out.println(ans);
	}
}

class Solution30 {
	int pos = 0;

	public boolean correct(String s) {
		boolean flag = true;
		Stack<Character> st = new Stack<Character>();
		// left = ")" , right = "("
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				right++;
				st.push('(');
			} else {
				left++;
				// st이 비워져 있을 수 있음
				if (st.isEmpty()) {
					flag = false;
				} else {
					// 짝이 맞음
					st.pop();
				}
			}
			// *아주 중요한 부분*
			// 최소 길이 반환 (이때 균형잡힌 문자열이다)
			if (left == right) {
				pos = i + 1; // v 시작 위치
				return flag; // 최소 길이 찾으면 종료
			}

		}

		return true;
	}

	public String solution(String p) {
		if (p.isEmpty())
			return p;
		// flag가 false인 경우는 생각하지 않는다 왜? 매개변수로 처음부터 균형잡힌 문자열이 들어오므로 항상 균형잡힌 문자열을 찾을 수 있다.
		boolean flag = correct(p);// correct 통해 u,v를 분리
		// 균형잡힌 최소 길이찾은 시점부터 u,v 분리
		String u = p.substring(0, pos);
		String v = p.substring(pos, p.length());
		if (flag) {
			return u + solution(v);
		}
		String answer = "("+solution(v) + ")";
//		answer += "(" + solution(v) + ")";
		// u의 처음 문자와 마지막글자를 제외하고 나머지 괄호 방향 변경
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == ')') {
				answer += "(";
			} else {
				answer += ")";
			}
		}

		return answer;
	}
}