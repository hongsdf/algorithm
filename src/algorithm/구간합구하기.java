package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구간합구하기 {
	public static int answer[]; // 구간합 배열을 생성
	// 의미 : 자주 반복되는 배열의 값을 캐시로 만들어 바로 가져다 사용
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		String str1[] = br.readLine().split(" ");
		int N = Integer.parseInt(str1[0]);
		int M = Integer.parseInt(str1[1]);
		int arr[] = new int[N+1]; // 1-base 시작
		answer = new int[N+1];
		
		String str[] = br.readLine().split(" ");
		for(int i = 1; i <=N; i++) {
			arr[i] = Integer.parseInt(str[i-1]);
			answer[i] += arr[i] + answer[i-1];
		}
		
		// 테스트 케이스 : 시간 복잡도  O(N*M)
		while(M --> 0) {
			int sum = 0;
			String str2[] = br.readLine().split(" ");
			int start = Integer.parseInt(str2[0]);
			int end = Integer.parseInt(str2[1]);
			
			// 정답
			System.out.println(answer[end] - answer[start-1]);
			
			// 왜 
			// start-1번째를 빼는 것일까?
			// ex
			
			
			
			
			
		}
		
	}
}
