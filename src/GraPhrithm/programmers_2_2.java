package GraPhrithm;

import java.util.*;

public class programmers_2_2 {

}

class Solution2_2 {
	int answer;
	boolean[] check = new boolean[10];

	ArrayList<Integer> arr = new ArrayList<>(); // 1
	// 백트레킹 문제
	
	void dfs(String str, String tmp, int m) {//   "017" ,  ,  1 -> tmp1,
		if (tmp.length() == m) {
			int num = Integer.parseInt(tmp);
			if (!arr.contains(num))
				arr.add(num);
			return;
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (!check[i]) {
					check[i] = true;
					tmp += str.charAt(i);
					dfs(str, tmp, m);
					check[i] = false;
					tmp = tmp.substring(0, tmp.length() - 1);
				}
			}
		}
	}

	public int solution(String numbers) {
		String tmp = "";   //017
		//  arr를 채우는 함수 ( 백트레킹 + 순서가 있는 조합)
		for (int i = 0; i < numbers.length(); i++) {
			dfs(numbers, tmp, i + 1);
		}
		
		for (int i = 0; i < arr.size(); i++) {
			is_prime(arr.get(i));
		}
		return answer;
	}

	private void is_prime(Integer num) {
		if(num == 1 || num == 0) return;
		for(int i = 2; i<num; i++) {
			if(num % i== 0) {
				return;
			}
		}
		answer++;
		
	}

}
