package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대공약수는 줄여서 GCD라고 쓴다.
// 두 수 A와 B의 최대공약수 G는 A와 B의 공통된 약수 중에서 가장 큰 정수이다.
// 최대공약수를 구하는 가장 쉬운 방법은 2부터 min(A, B)까지 모든 정수로 나누어 보는 방법
// 최대공약수가 1인 두 수를 서로소(Coprime)라고 한다.
public class GCD_LSM {
	public static int GCD =1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
//		GCD(A, B);
		GCD = gcd(A,B);
		LSM(A, B);

	}

	// LSM 최소 공배수 각 수를 GCD로 나누고 * GCD
	private static void LSM(int a, int b) {
		// 최소공배수 l = g * (a/g) * (b/g) : 최대 공약수를 이용하여 구할수 있다.
		// 방법1
		int LCM = GCD * (a / GCD) * (b / GCD);
		// 방법2
		//int LCM = a * b / GCD; 
		// 24/6 * 18/6 = 4 * 3 * 6
		System.out.println(LCM);

	}

	// 24 18 6
	// 최대 공약수(일반적으로 구현)
	private static void GCD(int a, int b) {
		// 두 수 중 작은 수까지 비교한다.
		for (int i = 2; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				GCD = i;
			}
		}
		System.out.println(GCD);

	}
	// 최대 공약수 재귀 함수 방법
	static int gcd(int a, int b) { // 24 18 -> 
		if (b == 0) { // base - case 탈출 조건 
			return a;
		} else {
			return gcd(b, a % b); 
			// 18%24(시작) 24,18 -> 18,6 ->  6,0
			// 24%18(시작) 18,6 -> 6,0 
		}
	}
	// Swap 이 필요없다 (작은수와 큰수끼리) 18%24 = 18, 24%18 = 6
	// 
}