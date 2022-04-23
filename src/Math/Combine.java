package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*  nCm 조합 에서 0의 갯수를 찾으시오. */
// 0의 갯수는 각각을 소인수 분해하여 2와 5가 한쌍을 이룰때 +1
// n : 2,000,000,000 

// 조합 공식
  /*
   *  			N! (+) 분자 
   *       -----------
   *      (N-M)! *  M!  (-) 분모
   */
public class Combine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken()); 
		long two = 0; long five = 0; // 2의 갯수와 5의 갯수를 체크하여 둘중 작은 값으로 출력
		// 이유: 작은 값 기준으로 한쌍의 최소 수치를 맞힐수 있다.
		// 분자 부분은 + 
		for(long i = 2; i<=N; i*=2 ) {
			two += N/i;
		}// 분모 부분은 - 해줘야한다
		for(long i = 2; i <=N-M; i*=2 ) {
			two -= (N-M)/i; 
		}// 분모 부분은 - 해줘야한다
		for(long i = 2; i <=M; i*=2 ) {
			two -= M/i;
		}// 분자 부분은 + 
		for(long i = 5; i <=N; i*=5) {
			five += N/i;
		}// 분모 부분은 - 해줘야한다
		for(long i = 5; i <=M; i*=5) {
			five -= M/i;
		}// 분모 부분은 - 해줘야한다
		for(long i = 5; i <=N-M; i*=5 ) {
			five -= (N-M)/i;
		}
		System.out.println( Math.min(two, five));
		
		
		
		
	}
}
