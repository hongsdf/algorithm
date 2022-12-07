package Groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class 구슬게임 {
	public static int N;
	public static int M;
	public static int K;
	public static int cnt; // 정답 경우의수
	public static int cnt2 = 0;
	public static int dp[][] = new int[10][10]; // [경기수][구름이의 구슬갯수]
	public static int dp2[][] = new int[12][11];  // [204][1000]
	
	public static Map<Integer,Integer[]> map;
	
	public static void main(String[] args) throws Exception {
		// [1]입력층
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		 N = Integer.parseInt(str[0]);
		 M = Integer.parseInt(str[1]);
		 K = Integer.parseInt(str[2]);
		 
		 int ans = solve(N,K,0);
		 System.out.println(ans);
		 // System.out.println(0 % 21);
		 //int ans = solve(N,K);
		 
		for(int a = 0 ; a<=K; a++) {
			for(int b = 0; b<=N+M; b++) {
				dp[a][b] %= 10000007;
				// 한쪽으로 구슬이 몰려 경기가 끝났을경우
				if(b == 0 || b == N+M) dp[a][b] = 1;
				// 구름이가 패배한경우
				if(0 < b-1 && b-1 < N+M ) dp[a+1][b-1] += dp[a][b];
				// 구름이가 승리한경우
				if( 0 < b + 1 && b + 1 < N+M) dp[a+1][b+1] += dp[a][b];
				// 무승부
				if( 0 < b && b < N+M) dp[a+1][b] += dp[a][b];
				
			}
		}
		 
		System.out.println(dp[K][N]); 
		// [2] 구현층 (완전탐색 중복 o)
		// 목적 : 모든 구슬을 잃는 경우의 수
		// 조건 : 게임은 명 중 한 명이 모든 구슬을 잃었거나, 가위바위보를 k번 진행한 경		우 끝난다.
		// 2-1 상대방이 올인되는 경우
		
		
		// 2-1 구름이가 올인되는 경우
		
		
		
		
		
		// [2-1] 완전탐색 중복 가능  + 순열  
		// handshake 만들어야할가?
//		가위 -> 보
//		바위 -> 가위
//		보 - > 바위
		
//		(3^k 시간복잡도)가 발생 위의 그림에서만 other의 구슬일수잇는경우
		
		
		// [2-2] dp - 특정 상황에서 경우의수를 찾는문제 (k번째에 구슬이 0이 되는 조건)
		// 경우의 수 문제 , 탐색조건이 다양하다
		// 1. k깊이 까지 탐색을 한경우
		// 2. k깊이 이전의 0이 된경우 x
		
		 // dp [ 남아잇는 경기수] [ 구름이의 구슬갯수]
		 // 조건
		 // 1. 구름이의 갯수가 0
		 // 2. 구름이의 갯수 N+M 모두 획득한 경우
		 // 3. 경기가 모두 치뤄진경우
		 
		 
		 // TOP-DOWN
		
		
		
		
		
		// [3] 정답
		// System.out.println(Other);
	}
	private static int solve(int curr, int round,int j) {
		//int cnt = 0;
		
		// 탈출조건
		// 구름이의 구슬이 0 (패배 경우) || 구름의 구슬을 모두획득(승리)
		if(dp2[round][curr] != 0) {
			return dp2[round][curr];
		}
		
		if(curr == 0 || curr == N+M) {
			return 1;
		}
		// 라운드가 모두 지나간 경우
		if(round == 0) {
			return 0;
		}
		cnt2 = 0;
		cnt2 += solve(curr+1,round-1,j+1); // 승리
		cnt2 += solve(curr,round-1,j+1); // 무승부
		cnt2 += solve(curr-1,round-1,j+1); // 패배
		
		// MOD 연산
		cnt2 %= 100000007;
		dp2[round][curr] = cnt2;
		
		return cnt2;
	}
//	
}
