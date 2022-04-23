package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.*/
// 이런 문제가 나오면 에라토스체가 가장 좋다
// 1 ≤ M ≤ N ≤ 1,000,000
public class Aretosche {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[M+1];
		boolean check[] = new boolean[M+1];
		// 3 ~ 16 
		int cnt = 0 ;
		// 0,1을 예외처리
		check[0] = true;
		check[1] = true;
		
		for(int i = 2; i+i <= M; i++) {
			if(!check[i]) {
				// 지워지지 않는 수중 2다음 => 2의 배수 4부터 지워진다.
				
				for(int j = i+i; j <= M; j+= i) {
					check[j] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = N; i <=M; i++) {
			if(!check[i]) sb.append(i).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
}
