package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 
	문제
	어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다.
	예를 들어 11=3^2 + 1^2 +1^2
	그 항의 최소개수를 구하는 프로그램 
	그러면 D[N]  N까지의 최소항의 갯수를 저장한다.
	
	
	1 ≤ N ≤ 100,000
	
	1 = 1^2 1가지
	
	D[N] =   O O O O + i^2 = N
		O O O O = D[N-i^2] = N-i^2까지 최소항의갯수를 저장한것


 */
public class num2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int d[] = new int[N+1]; // N까지 다 만들기
		// 초기화 처음 부분 ~ 마지막 직전

		for(int i = 1; i <=N; i++) {
			/* j 라는 변수가 하나 추가 
				그래서 2D 
			*/
			// 초기화 
			d[i] = i; 
			/*
			d[1] = 1이다
			d[2] = 2이다 왜? 어차피 1^2 + 1^2 1을 더해 가며 만들수 잇따.
			d[3] = 3이다 1 + 1+ 1
				:
			d[n] = n이다 1을 n개 더한것	
			*/
			for(int j = 1; j*j<=i; j++) {
				if(d[i] > d[i-j*j] + 1) { // 마지막에 +1하는 이유는 변수이기 때문이다.
					/*
					  앞서 1,2,3으로 더하기 완성 문제를 살펴보자
					   O O O O + 1  = N  마지막이 1로 고정이 되어있다. 이때 1은 상수이다
					   O O O O + 2  = N  마지막이 2로 고정이 되어있다. 이때 1은 상수이다
					   O O O O + 3  = N
					   
					   
				
					   
					 */
					d[i] = d[i-j*j] + 1;
				}
			}
		}
		System.out.println(d[N]);
		
	}
}
