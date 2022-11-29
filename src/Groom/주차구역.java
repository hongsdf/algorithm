package Groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주차구역 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int mod = 100000007;
		// 이 문제를 이해하기에는 어려웠다.
		// a b c a b c 와  c a b c a b는 같은 방식이다 (1,4),(2,5),(3,6) 같은 방식으로 묶었기 때문이다.
		int dp[] = new int[100001]; //조기화
		dp[1] = 0;
		dp[2] = 1;
		for(int i = 3; i<=n; i++){
			dp[i] = ((2*(i-1) + 1) * dp[i-1] + dp[i-2]) % mod;
		}
		
		
		System.out.println(dp[n] % mod);
	}
}

