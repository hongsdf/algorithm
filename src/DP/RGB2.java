package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N+1][3];
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j< 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*3
		26 40 83
		49 60 57
		13 89 99*/
		// 초기값
		int d[][] = new int[N+1][3];
		d[1][0] = arr[1][0];
//		d[1][1] = arr[1][1];
		d[1][2] = arr[1][2];
		
		
		// 처음 집과 마지막 집이 서로 이웃해 있다면 원형 구조 이다.
		// 2~ N-1까지는 직선처럼 구현을 하고
		// 처음 부분과 N부분을 처리해 주어야한다.
		// 풀이 방식은 
		// 마지막, 처음 중 하나를 고정해야한다.
		// 2 ≤ N ≤ 1,000 , 집을 칠하는 비용은 1,000보다 작거나 같은 자연수
		int ans = 1000001;
		
		for(int k = 0; k< 3; k++) {
			/* K : 1번 집을 의미 */
			for(int j = 0; j<3; j++) {
				if(j==k) {
					d[1][j] = arr[1][j];
				}else {
					d[1][j] = 1000001;
				}
			}
			
			// 점화식
			for(int i = 2; i<=N; i++) {
				d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + arr[i][0];
				d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + arr[i][1];
				d[i][2] = Math.min(d[i-1][1], d[i-1][0]) + arr[i][2];
			}
			
			for (int j=0; j<=2; j++) {
				/* j : 마지막 집을 의미  마지막집을 0 , 1, 2 중 하나로 칠하고 첫번째 집과 비교 */
				if (j == k) continue; /*첫번째집과 마지막 집의 색이 같으면 건너 뛴다. */
				ans = Math.min(ans, d[N][j]);
			}
			
		}
		System.out.println(ans);
		
		
		
		
		
//		// 마지막
//		d[N][0] = Math.min(d[N-1][1] + Math.min(d[1][2],d[1][1]) , d[N-1][2] + Math.min(d[1][2], d[1][1]));
//		d[N][1] = Math.min(d[N-1][0] + Math.min(d[1][2],d[1][0]) , d[N-1][2] + Math.min(d[1][2], d[1][0]));
//		d[N][2] = Math.min(d[N-1][0] + Math.min(d[1][1],d[1][0]) , d[N-1][1] + Math.min(d[1][1], d[1][0]));
//		
//		System.out.println( Math.min(d[N][2],Math.min(d[N][1], d[N][0])));
		
	}
}
