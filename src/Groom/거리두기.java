package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 거리두기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][6]; // 1번 베이스 시작
		int mod = 1000000007;
		// 1행 배치도 작성 
		// 초기
		dp[1][1] = 1; // 1번배치
		dp[1][2] = 1; // 2번배치
		dp[1][3] = 1; // 3번배치
		dp[1][4] = 1; // 4번배치
		dp[1][5] = 1; // 5번배치
		
		// 한 행의 나올수 있는경우를 배치도로 나눈다.
		// i번째 행의 배치도로 i-1의 나올수 있는 배치도의 경우의 수를 구한다.
		
		for(int i =2; i<=N; i++){
			for(int j = 1; j<=5; j++){
				 dp[i][1] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4] + dp[i-1][5]) % mod;
				 dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % mod;
				 dp[i][3] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4] + dp[i-1][5]) % mod;
				 dp[i][4] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][3]) % mod;
				 dp[i][5] = (dp[i-1][1] + dp[i-1][3]) % mod;
			}
		}
		
		System.out.println((dp[N][1] + dp[N][2] + dp[N][3] + dp[N][4] + dp[N][5])  % 1000000007);
	}
}