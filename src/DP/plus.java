package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class plus {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long d[] = new long[1000001];
		d[0] = 1;
		
		// 아예 처음부터 다 만들어 놓고 출력만
		for(int i = 1; i<= 1000000; i++) {
			if(i - 1 >= 0) {
				d[i] += d[i-1];
				
			}
			if(i - 2 >= 0) {
				d[i] += d[i-2];
			}
			if(i - 3 >= 0) {
				d[i] += d[i-3];
			}
			d[i] %= 1000000009L;
		}
		
		
		
		while(T -- > 0) {
			int Num = Integer.parseInt(br.readLine());
			System.out.println(d[Num]% 1000000009L);
			/*점화식
			 1,2,3더한다
			 D[N] = N까지 1,2,3을 더해서 완성한 경우의수
			 D[n-1] = n-1까지 1,2,3 을 더해서 완성한 경우의 수
			 o + o + o + .. + = N
			 o + o + 1  = N
			 o + o + 2  = N
			 o + o + 3  = N
			  
			 
			 * */
			/* 경우의 수 문제  */ 
			// 초기 값 세팅
//			d[0] = 1; // 공집합
			
			
		}
		
	}
}
