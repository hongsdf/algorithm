package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* d[i][j] = 2 * i 까지 최대 합 
 * 
 * 해석 (i열) 에서  j를 떼어냈을때 최대합 
 * 
 * 그러면  i-1? j와 인접한것을 떼어내지 말아야한다.
 * 
 * 스티커 문제 어렵다(= 동물원과 유사 위아래 살피기)
 * 
 * n <= 100,000
 * arr[] ( 0<= arr[] <= 100)
 * 
 * 10000000
 * 
 * */
public class Sticker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0 ) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n+1][2]; // 한 열의 위,아래 원소를 n개 입력받아야한다. => 행과 열을 뒤집어서 입력받기?
			// 일단 각열에는 2개의 원소가 있다.(= 위, 아래)
			// 입력 층에서
//			50 30 100   이렇게 입력 받으면 [50,10] [ 30,20] 이렇게 저장하자 
//			10 20 70
			
			// 그러면 이렇게 저장  [  [  ,  ]
//								  [  ,  ]
//							      [  ,  ]
//							      [  ,  ]
//								  [  ,  ] ]
			
			
			// 이렇게 입력받으면 어려움
//			for(int i = 0; i < 2; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine()," ");
//				for(int j = 1; j<=n; j++) {
//					arr[i][j] = Integer.parseInt(st.nextToken());
//					
//				}
//				
//			}
			
			
			// 위의 원소만 전부 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i = 1; i<=n; i++ ) {
					arr[i][0] = Integer.parseInt(st.nextToken());
				
			}
			// 아래 원소만 전부 입력받기
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 1; i<=n; i++ ) {
					arr[i][1] = Integer.parseInt(st.nextToken());
				
			}
			
			
			
			
			// i번째 열에서 할 수 있 는 경우의수  0.떼어낸다, 1.위를 떼어낸다, 2.아래를 떼어낸다
			int D[][] = new int[n+1][3]; // 한열에 3가지 행동을 할 수있다.
			// 시각적으로 [ 0 , 1 , 2 ] [ , , ] [ , , ] [ , , ] .. 이런씩이다 의미는 [, , ] : 하나가 한열의 행동을 의미하고 0,1,2중 끝나는 것을 의미
			
			for(int i = 1; i<=n; i++) {
				D[i][0] = Math.max(D[i-1][2], Math.max(D[i-1][0], D[i-1][1])) ;
				D[i][1] = Math.max(D[i-1][0], D[i-1][2]) + arr[i][0]; // 위의 원소 선택  (이것을 이해하기 해야한다.)
				D[i][2] = Math.max(D[i-1][0], D[i-1][1]) + arr[i][1]; // 아래 원소 선택
				/*arr[][] =  위 , 아래
				 * 			
				 * 			[50,  10]
				 * 			[30,  20]
				 * 			[100, 70] 
				 * */
				
			}
			int ans = 0;
			ans = Math.max(D[n][2], Math.max(D[n][0], D[n][1]));
			System.out.println(ans);
			
		}
	}
}
