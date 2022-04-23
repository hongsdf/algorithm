package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다*/
/* 문제를 보고 점화식을 세울수 있다.
 * 일단 N --> 1로 만든다는 것은 작게 만든다(dp생각해보기)
 *  N을 1로 만드는 방법은 3가지라고 제시
 *  dp의 효율성을 높히기 위해 메모이제이션을 사용하자(구했던 값 그대로 사용)
 *  D[N] = D[N/3] + D[N/2] D[N-1](틀린 점화식)
 *  만약 N == 4라고 하자
 *  D[4] = D[4/3] + D[4/2] +D[N-1]
 *  
 *  // 올바른 점화식
 *  D[N] = Math.min(D[N/3]+1, D[N/2]+1, D[N-1]+1)   /3 , /2 ,-1 중 하여 최소값
 *  이해하기
 *  D[4] 는 /3을 할수 없는데 최소값을 구할수 있는가? 여러 생각이 든다
 *  일단 D[4]까지의 최소 값은 4->2->1 이므로 3번이다.
 *  이제 D[10]을 구해 보자
 *  10 -> 9 -> 3 -> 1 (3번) , -1,/3,/3
 *  10 -> 5 -> 4-> 2-> 1(4번) , /2,-1,/2,/2
 *  둘중 전자가 더 빠르다
 *  
 *  이번에 D[5]를 구해보자
 *  5 -> 4 ->2->1  3번 , -1,/2,/2
 *  
 *  조금씩 이해해 보자
 *  D[5]에서 D[10]은 횟수가 1차이
 *  
 *  결국 위의 10 -> 5 -> 4-> 2-> 1(4번)에서 이용한것은 D[5]의 값을 그대로 이용한것
 *  // D[5] == 3이다
 *  // D[10]을 구하기 위해 D[5] 에서 1가지 연산을 더 수행해서 만들수 있으므로 D[5] + 1 = 4번
 *  
 *  
 *  D[1] = 0; // 1이면 수정을 하지 않기 때문에 0
 *  D[2] = 1; 
 *  D[3] = 1;
 *  D[4] = 3;
 *  D[5] = 3;
 *  D[6] = 0;
 *  D[7] = 0;
 *  D[8] = 0;
 *  D[9] = 2;
 *  D[10] = 3;
 *  
 *  
 *  
 *  
 *  
 *  4 = 4-> 2 -> 1
 *  4 = 4-> 3-> 2 ->1
 *  // 나누기 3은 안됨
 *  
 * 
 * 	X가 3으로 나누어 떨어지면, 3으로 나눈다.
	X가 2로 나누어 떨어지면, 2로 나눈다.
	1을 뺀다.
 * 
 * */
public class Basic1 {
	public static int d[];
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d = new int[N+1];
		solve(N);
//		solve2(N);
		
	}
		// 반복문
		// Bottom - up 문제 배열을 d[1] ~ d[n]까지 순서대로 채워나감
		private static int solve2(int n) {
			d[1] = 0; // 초기화
			for(int i = 2; i <=n; i++) {
				// 동급 1
				d[i] = d[i-1] + 1;
				// 동급 2
				if( i%2 == 0) {
					int temp = d[i/2] + 1;
					if(temp < d[i]) d[i] = temp;
				}
				// 동급3
				if( i%3 ==0) {
					int temp = d[i/3] + 1; //  d[i/3]을 가져오고 + 연산 수행
					if(temp < d[i]) d[i] = temp;
				}
			}
			return d[n];
			
			
		}
		// 재귀
		// Top-down d[n]을 찾기 위해 분해해 가며 찾는다.
		private static int solve(int n) {
			if(n == 1) {
				return 0;
			}
			//메모이제이션
			if(d[n] > 0) {
				return d[n]; // 구했던 적이 있는 값
			}
			d[n] = solve(n-1) + 1;
			if(n%2== 0) {
				int temp = solve(n/2) + 1;
				if(temp < d[n]) {
					d[n] = temp ;
				}
				
			}
			if(n%3 ==0) {
				int temp = solve(n/3) + 1;
				if(temp < d[n]) {
					d[n] = temp ;
				}
			}
			
			
			return d[n]; 
		}
}
