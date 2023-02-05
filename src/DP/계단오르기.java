package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int dp[] = new int[N+1]; // N번째 계단까지 오르기 까지 최대 값
		for(int i = 1; i <=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 로직
		// 도착지점은 밟아야한다.
		dp[0] = 0;
		dp[1] = arr[1];
		if(N == 1) {
			System.out.println(dp[N]);
			return;
		}
		dp[2] = arr[1] + arr[2];
		// dp[3] = arr[1] + arr[3];
		for(int i = 3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i] ,dp[i-3] + arr[i-1]+ arr[i]);
		}
		
		System.out.println(dp[N]);
		
		
	}
}
