package GraPhrithm;

import java.util.*;

public class programers_2_3 {
	public static void main(String[] args) {
		Solution3 m = new Solution3();
		m.solution("017");
		m.solution1(017);
	}
	
	
}
class Solution3{
	
	int answer;
	// 백트레킹 중요요소
	boolean visit[] = new boolean[10]; // 1. 문제에서 필요한 boolean 크기(0 ~ 9)
	List<Integer> list = new ArrayList<>();
	
	
	
	public int solution(String numbers) {
		int answer = 0;
		String tmp = "";
		for(int size = 0; size<numbers.length(); size++) {
			dfs(numbers,tmp,size+1);
		}
		for(int j = 0; j < list.size(); j++) {
			check(list.get(j));
		}
		
		
		return answer;
	}

	///////////////////

 //  String으로형변환하고 시작 int 형 끼리는 더 해지므로 string으로 하기
	public void solution1(int num) {
		String temp ="";
		String s = String.valueOf(num);
		for(int i = 0; i <s.length(); i++) {
			
		}
		
		
		
	}

/////////////////////////

	private void check(Integer num) {
		if(num == 0 || num == 1) return;
		for (int i =2 ; i<num; i++ ) {
			if(num%i == 0) return;
		}
		answer++;
		
	}



	// (찾고 싶은 문자열, 저장 공간, 글자 크기 )
	private void dfs(String numbers, String temp, int size) { 
	if(temp.length()== size) { // 최소한 한글자
		int n = Integer.parseInt(temp);
		if(!list.contains(n)) { // 중복을 배제하기 위한 방법
			list.add(n);
		}
		return;
	}else {
		for(int i = 0; i <numbers.length(); i++) {
			if(!visit[i]) { // 해당글자 한 칸 체크
				visit[i] = true; // 그 지점 
				temp += numbers.charAt(i); // 해당글자를 넣음
				// 다음 진행 그 위치에서
				dfs(numbers,temp, size);
				
				visit[i] = false; //  다시 복원
				temp = temp.substring(0,temp.length()-1); // 글자수 (복원) 
			}
		}
	}
	
	
		
	}
}