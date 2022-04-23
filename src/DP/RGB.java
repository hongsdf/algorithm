package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*  1번 부터 N번까지 집을 칠하는 데 이웃한 집은 같은 색으로 칠할 수 없다 
  
  점화식
  d[i][j] = i번째 집을 j 색으로 완성했을때  최소비용
  
  그렇다면 i-1번째 집은 j원소랑 다른 색으로 완성해왔다.
  
  
  i번째 집을 R로 칠했다면 i-1번째는 G or B = >두 개 중 최소 비용으로 완성 했을 것이다.
  i번째 집을 G로 칠했다면 i-1번째는 R or B
  i번째 집을 B로 칠했다면 i-1번째는 R or G
  
  d[i-1][j] = i-1번집을 
  N(2 ≤ N ≤ 1,000)이 주어진다
  1,000보다 작거나 같은 자연수
  1000000 1억이하
 */ 
public class RGB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][3];
		int d[][] = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for(int i = 1; i <=N; i++) {
//			for(int j = 0; j <3; j++) {
//				if( i - 1 >= 0 && j-1 >= 0) {
//					// i번째 집을 j로 칠했다면 i-1번째 집은 j랑 다른 수로 칠햇을 것이다.
//					d[i][j] += Math.min(arr[i-1][j+1],arr[i-1][j-1]); 
//					
//				}
//				
//			}
//		}
		for(int i = 1; i<=N; i++) {
			/* 0 : R , 1 : G , 2 : B
			 
			 	둘 중 작은 값으로 칠해 져 온다
			 
			 */
			
			d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + arr[i][0]; // i번째 위치를 0(=R)로 완성했을때 까지의 비용
			d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + arr[i][1]; 
			d[i][2] = Math.min(d[i-1][1],d[i-1][0]) + arr[i][2];
		}
		/*3개의 원소 을 비교하는 방법*/
		// 그래서 마을 N번째 까지 위치까지
		// N번째 위치를 0(=R)로 완성했을때 까지의 비용, N번째 위치를 1(=G)로 완성했을때 까지의 비용 , N번째 위치를 2(=B)로 완성했을때 까지의 비용
		System.out.println(Math.min(d[N][2], Math.min(d[N][0],d[N][1]) )) ; 
		
		
			
		
	}
}
