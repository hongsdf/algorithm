package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 문제를 읽고 나선형 문제를 확인하게 되엇다.
 * 먼가 복잡해 보여 어려워 보였다.
 * 침착하자 먼저 그림을 그려가며 패턴을 익히도록 하였다.
 * 어떤 면 순서대로 그려지는가 체크 해 보았으나 감이 잡히지 않았다.
 * 
 * 그러다 수를 나열해 보니 규칙을 발견하여 문제를 풀었다.
 * dp[i] = dp[i-2] + dp[i-3]으로 정리하는 패턴이다.
 * 문제의 크기는 N이 100까지 커질수 있다 
 * 정답 long타입으로 선언해야 Overflow가 발생하지 않는다.
 * 
 * 
 */
public class Backjooon9461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		long dp[] = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		dp[9] = 7;
		dp[10] = 9;
		
		
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine()) ;
			
				for(int i=11; i <=N; i++) {
					dp[i] = dp[i-2] + dp[i-3];
				
				}
			bw.write(dp[N]+"\n");	
//			System.out.println(dp[N]);
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
