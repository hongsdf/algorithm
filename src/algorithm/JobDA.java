package algorithm;

import java.util.Stack;

public class JobDA {
	public static void main(String[] args) {
		Solve m = new Solve();
		int n = 6;
		int k = 2;
		int h[] = {1,7,2,3,8,5};// 1,7,2,3,8,5
		// 1,3,5,4,2,6
		// return 2
		
		
		// case2
//		int n = 9;
//		int k = 2;
//		int h[] = {9,5,3,8,7,6,9};
		// return 2
		
		
		m.solution(n, k, h);
		
	}
}
class Solve{
	public int check[];
	public int k;
	public int h[];
	public int solution(int n,int k,int h[]) {
		int answer = 0;
		check = new int[n];
		// 일반 타워, 컨트롤 타워가 존재하고
		// 처음 모든 타워는 일반타워이다.
		// 일반타워는 양옆의 자신보다 높은 타워로 부터 수신을 받아야하며 양쪽에 존재할경우 왼쪽을 우선순위로 받아온다. 
		// 종료 조건
		int time = 1; // 시간
		while(true) {
			// 모든 타워가 k시간 이내로 송신을 받을 경우 종료
			if(!checking()) {
				break;
			}
			
			// 가장 높이가 높은 타워는 반드시 컨트롤 타워가 되야한다.
			int max = -1;
			int index = 0; // 최정상 높이 인덱스
			for(int i = 0; i <check.length; i++) {
				if(max < h[i]) {
					max = h[i];
					index = i;
				}
			}
			
			check[index] = 99999; // 컨트롤 타워
			answer++; // 컨트롤 타워 갯수 증가
			
			// 1.일반 타워 구현 시작
			// 1-1. 컨트롤 타워 바로 옆 구현
			if(index - 1 >= 0 ) {
				check[index-1] = time;
			}
			
			if(index + 1 < n ) {
				check[index+1] = time;
			}
			// 1-2. 
			boolean leftCheck = false;
			boolean rightCheck = false;
			//왼쪽 진행
			int left = 0;
			
			// 왼쪽 stack구현
			Stack<Integer> st1 = new Stack<>();
			//st1.push(index-1);
			
			for(int i = index-2; i >=0; i--) {
				boolean flag = false;
				while(!st1.isEmpty() && h[st1.peek()] > h[i]) {
					// time++;
					// index까지 전부 변경
						check[st1.pop()] = time;
						flag = true;
					}
					if(flag) {
						time++;
					}
					
					st1.push(i);
				}
				
					
			
			// 남은 타워 들
			check[st1.pop()] = time;
			//오른쪽 진행
			for(int i = index; i >0; i--) {
				
			}
			
			
		}
		
		
		return answer;
	}
	private boolean checking() {
		for(int i = 0; i <check.length; i++) {
			if(check[i] > k) {
				return false;
			}
		}
		return true;
	}
}