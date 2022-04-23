package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*t (1 ≤ t ≤ 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다. 각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고,
 *  다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1,000,000
 *  100000000
 *  */

/* 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.*/
public class GCD {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			for(int i = 0; i <N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
//			Arrays.sort(arr);
//			for(int i = 0; i <arr.length-1; i++) {
//				sum += gcd(arr[i],arr[i+1]);
//			}
			
			
			for(int i = 0; i <N ; i++) { // i <N 까지 면 j입장에서는 arr[] 끝에서 바로 실행한다 j = i+1을 하면 주의
				for(int j = i+1; j<N; j++) {
					sum += gcd(arr[i],arr[j]);
					
				}
			}
			
			
			
			System.out.println(sum);
		}
	}

	
	
	
	// 일단 외우기(GCD 최대 공약수 공식)
	private static int gcd(int x, int y) {
		if( y == 0) {
			return x;
		}else {
			return gcd(y,x%y); 
		}
		

	}





	private static int gcd2(int num1, int num2) {
		int gcd = 1; // 초기값 1
		for(int i = 2; i <=Math.min(num1, num2); i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}
	
}
