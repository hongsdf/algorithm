package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 주차구역 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		// dp[N] 은 N까지색깔로 만들수 있는 방법 
	 // 0 0 0 
		dp[1] = 0; 
		dp[2] = 1;// abab -> baba
		dp[3] = 5; // [c]b[c]a[c]b[c]a[c]
		// dp[4] = 11;  // abcabc  [d]a[d]b[d]c[d]a[d]b[d]c[d]   d;
		// dp[5] = dp[4] * 2 + dp[3];
		
		for(int i = 4; i <=N; i++){
			dp[i] += 2 * (i-1) + dp[i-2];
		}
		System.out.println(dp[N] % 1000000007);
		
		
		
	}
}
