package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Backjoon10610 { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		// 10^5
		//30 의 배수
		// 조건 1 : 무조건 뒤에 0이 있어야하고, 조건2 : 3의 배수리스트에 값들중 각 자리 합이 3의 배수이여야한다. 6 = 0 + 6,    54 = 5 + 4 == 9%3==0          
		
		int arr[] = new int[10]; // 0~ 9까지
	     // 30의 배수 2 + 5 + 2
		
		// 1,2,3,5,6,10,15,30
		// 6 + 5 + 4 = 654  64500
		// 숫를 더했을때 3의 배수 체크
		// 5+ 4 + 0 0
		// 7 + 1 + 00
		// 3 3 + 0 0	
		long answer = 0;
		for(int i = 0; i <N.length(); i++) {
			int num = N.charAt(i) -'0';
			arr[num]++; // 9이면 9인덱스 ++
			answer += num;
			// 10201 1 1
			// 0 1 2  
			// 2 4 1 = 7
		}
		//새로운 문법으로 문자열안에 포함되는 문자 확인
		// 문자열안에 0이 없거나 자릿수 합이 3으로 나누어떨어지지 않는 경우
		if(!N.contains("0") || answer % 3 != 0) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 9; i>=0; i--) {
			while(arr[i] > 0) {
				sb.append(i);
				arr[i]--; // 2111100
			}
		}
		System.out.println(sb.toString());
		
		
		
		// int value = dfs(0,"",c, answer,visit); 
		// 57210

		// 210
		// 987512
		// 100000 : 5! 54321 * 5
		// 30의 배수
		// 30 = 3의 && 10 5
		// 30 60 90 120 150 180
		
		// 102 3자리 사용해야된다.
		// 10000
		
		// 수를 섞어서 가장 큰수를 만들기
		// 완전탐색이라고 생각
//		102
//		120
//		210
//		201
//		012
//		021 :30보다 작으면 제외
		
	}
	// 내가 구현한것 재귀로 구현하니 메모리 초과 에러 발생
	//  그이유는? 자릿수가 10^5개까지 적을수 잇다 
	// 처음에는 100000까지라고 생각햇지만 그것이 아니었다.
	// 11111111111111...... 1111 이것이 10만개라는 것이다.
	
	public static int dfs(int depth,String temp,char c[], int answer,boolean visit[]) {
		if(depth == c.length) {
			int target = Integer.parseInt(temp);
			if(target%30 == 0) {
				answer = Math.max(answer,target);
			}
			return answer;
		}
		
		for(int i = 0; i<c.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp += c[i];
				answer= Math.max(answer ,dfs(depth+1,temp,c,answer,visit));
				temp = temp.substring(0,temp.length()-1);
				visit[i] = false;
			}
		}
		return answer;
		
	}

}
