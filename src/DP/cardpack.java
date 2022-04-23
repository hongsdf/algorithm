package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N번째까지를 구해하는 최대 비용 = N-i번째 전까지 비용 + i번째 비용                           */
/* D[N]  = D[N-i] + p[i]*/

/* 다이나믹이라고 생각하는 근거
 * 
 * 카드를 사는 행동은 같은 패턴이다.
 * 
 * 
 * 
 * */ 
public class cardpack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int p[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <=N; i++) {
			p[i] =  Integer.parseInt(st.nextToken());
		}
		/*첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다.
		 *  (1 ≤ N ≤ 1,000)

			둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)
		 * 
		 * 
		 * 
		 * */ 
		int D[] = new int[N+1]; // N개 까지 결과 값

		for(int i = 1; i<=N; i++) { // 카드 팩이 N개 가 있다.   1 ,2 ,3 ,4,5....
			for(int j = 1; j<=i; j++) { // 팩중 하나를 선택할 것인데 팩을 선택할 때는 제한 사항이 있다.
				// 팩의 번호의 이하 갯수만 선택
				// 3팩이 3개다 ==> *그럼 총 3장만 선택 할수 잇다.
				// p[1] = 1
				// p[2] = 5
				// p[3] = 6
				
				// i번째 팩에서 이하의 구매할수 있는 카드 갯수 j
				// 2번째 팩은  1,2에서 구매 할수잇다. 2가지 조건을 해보고 최대
				if( D[i] < D[i - j] + p[j] ) {
					D[i] =  D[i - j] + p[j];
				}
			
			}
		}
		
		System.out.println(D[N]);
		
	}
}
