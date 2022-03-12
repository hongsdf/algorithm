package algorithm;

import java.util.Scanner;

public class No43 {
	// DP : Dynamic Programming (점화식)
	// 작은 문제들로 큰 문제를 해결하는 방법
	
	static int[] ans = new int [1000];
	static int[] arr = new int [1000];
	public static void main(String[] args) {
		
		/*
		 * n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
		 * 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
		 * 
		 * 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
		 * 
		 * int n = 3개의 동전
		 * int k = 합
		 * n,k
		 * 1번 동전의가치 
		 * 2번 동전의가치 
		 * 3번 동전의가치
		 * 
		 * 1,2,3번을 합산하여 k를 만들수 있는 경우의 수
		 */
		
	
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i =0; i< n; i++) {
			arr[i] = sc.nextInt(); // 1번숫자, 2번 숫자, 3번 숫자
				
		}
		// 초기화
		ans[0] = 1;

		for(int i = 0; i<n; i++) { // 1,2,3
			for(int v = arr[i]; v<=k ; v++) { // arr[0] : 1 ~ 10 arr[1] : 2 ~ 10
				ans[v] += ans[v- arr[i]]; //  1 - 1  // ans[1 - 1] = ans[0] = 1
				// 밑에 문제를 해결하면 서 큰 문제를 해결
				// ans[2] += ( 2 - arr[0] : 1) 
				// ans[2] = 2
				
				// ans[3] += ( 3 - 1원짜리) : 2
				// ans[3] = 2
			}
		}
		System.out.println(ans[k]);

	
				/*
				 *  ans :   1 2 3 4 5 6 7 8 9 10
				 *  1   	1 1 1 1 1 1 1 1 1 1
				 *  2   	0 1 1 2 2 3 3 4 4 5
				 *  5   	0 0 0 0 1 1 2 2 3 4 
				 *      	1 2 2 3 4 5 6 7 8 10
				 *  
				 * */
		
	}
}
