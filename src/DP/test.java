package DP;

import java.io.*;
import java.util.*;
/* 행에 대한 조건   
 * */
public class test {
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); // 조건 갯수
		/* 0 ~ N 까지  경우의 수를 구하는 프로그램
		 *  더해서 0부터 N까지의 정수 K개를 더해서 그 합이 N
		 * */
		
		long d[][] = new long[K + 1][N + 1]; // N+1 : 0~ N, [N]이 아니다 x
		// 초기값
		 d[0][0] = 1; // 공집합 개념 아무것도 선택 하지 않음
		 
		// 점화식
		 for(int k1 = 1; k1<=K; k1++ ) {
			 for(int i = 0; i<=N; i++) {
				for(int j = 0; j <= i; j++ ) {
					/* i수를 k1번을 활용하여 만들기까지
					 * 
					 * k1-1 에는 i보다 작은 수 이다.
					 * 그리고 j는 i보다 작은수 이여야만 한다. 왜?
					 * 
					 * 자 살펴보자
					 * i == 1이라면
					 * d[i] : 1의 수를 완성해야한다.
					 * 만약 j가 1보다 커 버리면 1보다 큰수를 만들것이다.
					 * 그래서 조건에 위배 된다.
					 * 
					 * 처음
					 * 나는
					 * for(int j = 0; j<=N; j++ ){
					 * 
					 * } 갈수 있다고 생각햇지만
					 * 
					 * i수를 완성하기위해 j를 더할것이며 i보다 큰 수를 만들면 안된다.
					 * 
					 * 
					 * 그래서
					 * d[i-j] :해석하면
					 * i =3 이면
					 * 
					 * j : 0,1,2,3 의 수로 3을 완성하면 된다. (= j에 4가 포함되어잇다면 이미 3을 넘는다 위배  )
					 * 
					 * 마지막 해석하면
					 * d[i][k1] = d[i-j][k1-1] : k1갯수를 활용하여 i를 만들기  =  k1-1전 갯수에서 i보다 작은수 들을 조합하여 만든다.
					 * */
					d[k1][i] += d[k1-1][i-j]; /* + 경우의수가 아니면  d[i-j][k1-1] + d[i] 을 것이다.*/ 
					// i 전까지 수들 중 j를 하나씩 빼어보며 i를 완성하는 경우
					
				}
			}
			
		}
		System.out.println(d[K][N]);
		
    }
}