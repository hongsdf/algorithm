package DP;

import java.util.Scanner;

/*오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.*/
public class IncreasingNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d[][] = new int[N+1][10];
		//초기값
		for(int i = 0; i <= 9; i++) {
			d[1][i] = 1;
		}
		
		for(int i = 2; i<=N; i++) {
			for(int j = 0; j <=9; j++) {
				for(int k = 0; k<=9; k++) { // 3변수를 사용 j보다 작거나 같다는 것을 표현하기 위해 변수를 사용 
					if(k <= j) {
						d[i][j] += d[i-1][k];
						
					}
					d[i][j] %= 10007;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i<=9; i++) {
			ans += d[N][i];
		}
		System.out.println(ans);
	
	
	}
}
