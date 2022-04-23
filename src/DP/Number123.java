package DP;
/* 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다.
   합을 나타낼 때는 수를 1개 이상 사용해야 한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N을 완성할때 1 + 2 + 3 의 경우의수를 다 더 한다
// D[N] = D[N-1] + D[N-2]+ D[N-3] 

/*
 *  N == 4라고 하면
 *   O + O + O + O +... + = N을 완성할 것이다.
 *     O + O + O + O +... +   1 == N
 *     N-1 = O + O + O + O +... + 이다
 *     그러면  O + O + O + O  == 3이 될것이다.
 *     즉 N-1을 완성하기 위해 3을 사용했다.
 *     이 3은 또 1,2,3으로 조합하여 구현했을 것이다.
 * 
 *  즉 D[N-1] 은 N-1까지 오기 까지의 조합 들
 *  결국 여기까지 오기까지 밑에서 쌓아 올린것이다
 *  
 *  N-2  = O + O + O + O +... + 이다
 *  그러면 O + O + O + O == 2이다.
 *  즉 N-2을 완성하기 위해 2를 이용했다.
 *  2는 1,2로 완성했을 것이다.
 * 	
 * 
 * 
 * */


public class Number123 {
	public static int d[];
	public static void main(String[] args) throws NumberFormatException, IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			d = new int[12];
			while(T --> 0) {
				int num = Integer.parseInt(br.readLine());
				int ans = solve(num);
				System.out.println(ans);
			}
	}
	// 음수 처리가 안되어 있다.
	private static int solve(int n) {
		// 음수처리를 하기 위해 초기값을 설정중요하다
		if(n == 0) return 1;
		if(n == 1) return 1;
		if(n == 2) return 2;
	
		
		if(d[n] > 0) return d[n];
		
		d[n] = solve(n-1) + solve(n-2) + solve(n-3);
		
		return d[n];
	}
	
	private static int solve2(int n) {
		d[0] = 1;
		for(int i = 1; i< 11; i++ ) {
			for(int j = 1 ; j <=3; j++ ) {
				// 음수가 되는 경우가 잇음
				if( i - j >= 0) { //예외처리
					d[i] += d[i-j];
				}
			}
		}
		
		return d[n];
	}
	
	
}
