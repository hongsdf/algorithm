package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2579 {
	// static Integer dp[]; // i번째 까지 계단 합 // null값을 사용하기 위해 Integer타입 사용
	static int dp[]; // i번째 까지 계단 합 // null값을 사용하기 위해 Integer타입 사용
	
	static int d[]; //계단 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d = new int[N+1]; // 계단 정보 입력
		dp= new int[N+1]; // 연속된 3개의 계단 표기
		for(int i = 1; i <=N; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}
		// dp[0] = d[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
		dp[1] = d[1];
		dp[2] = d[1] + d[2];
		
		int answer = find(N); // 재귀함수 구현
		System.out.println(answer);
	    // DP 구현
		// 한개 두개 계단을 오를 수 있다.
		// 연속된 3개 계단은 오를수 없다(단 시작업은 포함하지않는다)
		// 마지막 도착지점은 밟아야한다.
		
		// 연속된 3계단을 밟지 말아야한다는 조건을 생각
		
		
		
		
		
	}

	private static int find(int n) {
	  // 목적: n의 위치를 찾기
	  // 탈출조건 : n의 값을 찾으면 종료
		if(n <= 0) return 0;
		if(dp[n] == 0) {
			// n-2값과 n-3을 비교한다. 이유? => n-2을 밟으면 n-1은 자동으로 밟으면 안된다. 왜냐하면 n-2 + n-1 + n 값으로 연속된 3개값을 밟게된다.
			// n-3을 밟으면 직전 n-1을 밟고 n을 밟는것이다.
			// 하지만 그러면 n-1을 재귀함수를 사용하면 안될까?  ?????
			dp[n] = Math.max(find(n-2), find(n-3)+  d[n-1] ) + d[n];
					
		}
		return dp[n];
		
	}
	
	
	
}
