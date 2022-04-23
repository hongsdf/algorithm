package DP;
/* 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2 * N 에서 N이 주어 졌을때 경우의수*/
// 점화식 D[N] = 경우의수는 ?
// 문제에서 1*2 , 2*1 타일 이라고 주어짐 그러면
// 타일수는   =   1 * 2 (경우의수 ) +  2* 1(경우의 수)

/* 큰거 + 나머지 로 분할 해서 생각하자*/


public class Tile1 {
	public static int d[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d = new int[1001];
		int ans = solve2(N);
		System.out.println(ans);
	
	}
	private static int solve(int n) {
//		if(n == 0) return 1; // 주의사항 0도 하나의 경우이다(채울수 없음도)
//		if(n == 1) return 1;
		d[0] = 1;
		d[1] = 1;
		
		// i == 2조각부터 n번째 조각까지 합해가며 구한다(Bottom-up)
		for(int i = 2; i <=n; i++) {
			d[i] = d[i-1] + d[i-2];
			d[i] %= 10007;
		}
		
		
		
		return d[n];
	}
	// top-Down
	private static int solve2(int n) {
		if(n == 0) return 1; // 주의사항 0도 하나의 경우이다(채울수 없음도)
		if(n == 1) return 1;
		// i == 2조각부터 n번째 조각까지 합해가며 구한다(Bottom-up)
		if(d[n] > 0 ) return d[n];
		d[n] = solve2(n-1) + solve(n-2);
		d[n] %= 10007;
		
		
		return d[n];
	}
	
}
