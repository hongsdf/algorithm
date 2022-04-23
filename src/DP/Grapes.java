package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 n = 10,000  arr[] =1,000
 
 10000000 < 1초 이하
 
 
 연속 문제 핵심
• D[i][0] = 0번 연속해서 마신 포도주 → A[i]를 마시지 않음
• D[i][1] = 1번 연속해서 마신 포도주 -> A[i-1]을 마시지 않았음
• D[i][2] = 2번 연속해서 마신 포도주 → A[i-1]을 마시고, A[i-2]는 마시지 않았어야 함
 
 • D[i][j] = A[1], …
  A[i] 까지 포도주를 마셨을 때, 마실 수 있는 포도주의 최대 양, A[i]는 j번
  연속해서 마신 포도주임
 
  표현방식
	1. i번째 포도주를 마시지 않는 경우
	• D[i-1]
  	2번째 포도주를 마시는 경우
	• D[i-1] + A[i]
 
 
 */
public class Grapes {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 2dp로 풀지 않는다. 선택 한다 || 안 한다 두개중 하나
//		int d[] = new int[n+1];
//		// 초기화 처음 원소는 arr[1]요소 초기화
//		d[1] = arr[1];
//		if(n >= 2) {
//			d[2] = arr[1] + arr[2]; // 2개 원소까지 세팅 (=아직 연속 2번째다)
//		}
		
		/* 기본 생각
		 * 
		 * d[i] : i번째가 2번째연속 값이라면 - > arr[i](= 이번값을 마시고 ) + i-1은 마시면 2번
		 * 		
		 * d[i] : i번째가 1번째연속 값이라면 - > arr[i](= 이번값을 마시고 ) + i-1 마시지 x
		 * 
		 * d[i] : i번째가 0번째연속 값이라면 - > arr[i]도 마시면 안된다.
		 * 
		 * 
		 *  
		 * */
		

		
		
		

		
		int D[][] = new int[n+1][3];
//		D[1][0] = 0; 
		D[1][1] = arr[1];
//		D[1][2] = 0; 이런 경우는 없다
		
		
		int ans = arr[1];
		if(n >= 2) {
			D[2][2] = arr[1] + arr[2]; // 2개 원소까지 세팅 (=아직 연속 2번째다)
			D[2][1] = arr[2];
			D[2][0] = arr[1];
			ans = D[2][2];
					
		}
		
		for(int i = 3; i<=n; i++) {
			D[i][0] = Math.max(D[i-1][2] , D[i-1][1]); // d[i][0]이라는 얘기는 i-1번째가 0,1,2 연속 경우의수중 최대 값을 넣는다. 
			D[i][1] = Math.max(D[i-2][0], Math.max( D[i-2][1],  D[i-2][2]))  + arr[i];
			D[i][2] = D[i-1][1] + arr[i];
			
		}
		
		for(int i = 1; i<= n; i++) {
			if(ans < Math.max(D[i][1],Math.max(D[i][2],D[i][0]))) {
				ans = Math.max(D[i][1],Math.max(D[i][2],D[i][0]));
			}
		}
		
		System.out.println(ans);
	
	}
}
