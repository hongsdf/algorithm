package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 연속합 2
 * 
 * 보통 수열 문제는 DP를 생각해보자
 * 오름차순 내림차순 반복이 되면 바이토닉 2가지 배열을 만들자.
 * 1. 오름차순 배열
 * 2. 내림차순 배열
 * 
 * 연속합
 * 포함시키는 경우, 포함시키지 않는 경우 N 의 크기가 크면 시간 복잡도 O(n^2)
 * 
 * []k[] k를 포함 시키지 않는경우 
 * 
 * 
 * 
 * 배열의 길이가 N이라면  O(N)
 * N개 수를 포함 , 불포함 다 한번씩 해본다. O(N)
 * 
 * 즉 O(N^2)
 * 
 * 시간 복잡도 줄이기
 * 
 * [ K-1까지의 연속합  ]K[ K+1부터 연속합    ]
 * 
 * 두개 배열 생성한다
 * 그리고 더한다 그러면 K를 포함하지 않는 연속합  == 위에랑 같지만 시간복잡도는 빠르다
 * 
 * 
 * 비교방식
 * D[i] = d[i-1]까지 더한 값 + arr[i];
 * 
 * 거꾸로 
 * int i = N-1  i ~0 i--
 * d[i] = arr[i]
 * 
 * 
 * D2[i] = d[i+1] + arr[i];
 * 
 *  10
 * 10 -4 3 1 5 6 -35 12 21 -1
 * 
 * */
public class number3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N] ;
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// k-1까지 배열 연속합
		int D[] = new int[N];
		
		for(int i = 0; i <N; i++) {
			D[i] = arr[i];
		}
		
		for(int i = 0; i <N; i++) {
			if(i - 1 >= 0) {
				if(D[i] < D[i-1] + arr[i]) {
					D[i]  = D[i-1] + arr[i];
				}
				
			}
		}
	
		
		
		
		// k+1부터 연속합 
		int D2[] = new int[N];
		
		for(int i = 0; i < N ; i++) {
			D2[i] = arr[i];
		}
		
		for(int i = N-1; i >=0 ; i--) {
			if( i + 1 < N) {
				if(D2[i] < D2[i+1] + arr[i]) { // i위치를 빼고 (i-1) + (i+1)을 더한것
					D2[i] = D2[i+1] + arr[i];
				}
				
			}
		}
		
		// 제거 하지 않은 경우 D2 배열 필요없음
		int ans = D[0]; 
		for(int i = 0; i <N; i++) {
			ans = Math.max(ans, D[i]);
		}
		
		
		
		// 제거 한 경우
		/* [10, -4, 3, 1, 5, 6,     (* -35),  12, 21, -1] : -35를 지우고
		 * [10, 6, 9, 10, 15,   (21),  -14,   12, 33, 32] : D1[21] +
		 *[21, 11, 15, 12, 11, 6, -2,        (33), 21, -1]: D2[33] */ 
		// int ans = 0;
		for(int i = 0; i <N; i++) {
			if(i - 1 >=0 && i + 1 < N) {
				ans = Math.max(ans, D[i-1] + D2[i+1]);
				
			}
		}
		System.out.println(ans);
		
		
	}
}
