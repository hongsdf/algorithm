package DP;
/*정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다.
 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2D 다이나믹을 사용한다 이유?
 	N을 완성하기 위해 중복이 없어야한다
 	 _ + 1 = N
 	 위의 식을 보면 _ 에서는 2,3이 들어가야한다(중복이 없어야 하니깐) _ (=변수)다 바뀔수있는 값이니깐
 	 그러면 즉 변수가 2개다 그래서 2D를 사용하는 것이다.
 	 
 	 문제 풀이
 	  _ + 1 = N _ = (2,3)
 	  _ + 2 = N _ = (1,3)
 	  _ + 3 = N _ = (1,2)
 	  
 	  D[i - 1][j] = D[i - 1][2] || D[i - 1][3]
 	  
 	  D[i - 2][j] = D[i - 2][1] || D[i - 1][3]
 	  
 	  D[i - 3][j] = D[i - 3][1] || D[i - 3][2] :  i-3 해석 3을 선택하기 전에는 j (= 1,2)중 하나를 선택했다.
 	  
 	  문제 조건
 	  n은 양수이며 100,000 
 	  

		출력
	각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
 	  
 	  
 */
public class number123distinct {
	static final int N = 100000;
	static long d[][] = new long[N+1][4]; // 100001은 n = 100000 + 0(1가지), 4경우 1,2,3 경우와 + 포함하지 않은 경우
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 보통 배열의 크기는 문제 수 +1 로 세팅
		for(int i = 1; i<=N; i++) {
		/* i번째수를 만족하기 위해 [i번째][ i 사용한수] :  */	
			if(i -1 >=0) { // i-1은 음수 x
				d[i][1] = d[i-1][2] + d[i-1][3];
				if(i == 1) { //처음 한자리 수 세팅 
					// 1번 수는 _한칸으로 완성
					d[i][1] = 1; 
				}
			}
			if(i - 2 >=0) {
				d[i][2] = d[i-2][1] + d[i-2][3];
				// 2번째 _ 한칸은 2하나로 완성가능
				if(i == 2) {
					d[i][2] = 1;
				}
			}
			if(i - 3 >= 0) {
				d[i][3] = d[i-3][1] + d[i-3][2];
				if(i == 3) {
					d[i][3] = 1;
				}
			}
			// 이제 통합 해보면
			// d[4][1] : 4번째 위치를 1로 완성했다.
			// 그러면 n-1 (= 3번째는 2,3)으로 완성했을 것이다.
			
			// d[4][2] : 4번재 위치를 2로 완성했다면
			// d[4-2][1] :  [i-2] i번째 2번째가 아니라 : 
			/* i직전에 사용한 수가 2라고 해석 */
			// 즉 4까지 완성하기 전에는 2를 사용했다 (한 칸씩 해석)
			
			
			// d[n-1][2]  , d[n-1][3]
			d[i][1] %= 1000000009L;
			d[i][2] %= 1000000009L;
			d[i][3] %= 1000000009L;
			
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			int a = Integer.parseInt(br.readLine());
			// 다시 해석 a위치를 1로 완성했을 경우 + a위치를 2완성 + a위치를 3완성
			System.out.println((d[a][1] + d[a][2] + d[a][3])%1000000009L );
			
		}
	
	}
}
