package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Card1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int p[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <=N; i++) {
			p[i] =  Integer.parseInt(st.nextToken());
		}
		// 점화식
		// d[N] = d[N-i] + d[i]
		// N개를 구매해야한다면 마지막직전을 집중하자
		//	 O + O + O..+	i개를 구매하고 = N이 되었을 것이다.
	    // 그러면 i개를 구매했다는 것은 (=i번째 팩을 구매했다는 것)
	    // 그러면 그 직전까지 N-i을 어떻게 조합해서 구매해왔을것이다.
	    // d[n] = d[n-i] + p[i](= i팩 가격)
		// 문제에서 가격을 측정하는 것이라 i개를 구매했다는 것은 (= i 가격을 의미)
		
		int d[] = new int[N+1];
		d[0] = 0;// 하나도 구입하지 않은 경우	0원일 것이다.
		// 주의 할 점이 있다.
		// 카드팩을 구매할때 기준(i)번째 팩까지 구한다는 것은 j는 i이하 까지 구매할수 있다.
		// 무슨 뜻이냐?
		// 1번팩까지는 1팩만 구매할수 있다.
		
		// 2번팩까지는 1,2팩 2가지 경우
		// 3번팩까지는 1,2,3 3가지 경우
		// N번팩까지는 1,2,3... n가지 경우
		// 이므로 
		// 기준 자신의 이하 팩은 전부 살수 있다.
		
		
		// 표현 방법
//		for(int i = 1; i<=N ; i++) { // 기준
//			for(int j = 1; j<=i; j++) { // 기준이하 까지 표현
//				
//			}
//		}
		// 시간 복잡도 N개를 찾아야하고  , N개를 칸마다 비교 하니깐 시간복잡도 == O(N^2)
		for(int i =1; i<=N; i++) {
			for(int j =1; j<= i; j++) {
//	점화식		d[i] = d[i-j] + p[j]; // 이 표현  (=i기준이하의 팩들 중)에서 구매해서 최대값을 구한다
				//해석
				// 2번 팩이라고 하면
//				d[2] = d[2-1] + p[1]; 경우의수 1 : 2팩자지 1를 구매하지않고 완성했을 경우 + 마지막 1를구매
//				d[2] = d[2-2] + p[2]; 경우의수 2 : 2팩까지 2를 구매하지않고 완성했을경우 + 마지막 2를 구매
//				경우의 수 1,2를 다 해보고 최대값을 저장
				
				if(d[i] < d[i-j] + p[j]) {
					d[i] = d[i-j] + p[j] ;
				}
				
						
			}
		}
		System.out.println(d[N]);
				
	}
}
