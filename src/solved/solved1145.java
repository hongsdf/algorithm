package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//다섯 개의 자연수가 있다. 이 수의 적어도 대부분의 배수는 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수이다.
//서로 다른 다섯 개의 자연수가 주어질 때, 적어도 대부분의 배수를 출력하는 프로그램을 작성하시오.
// 30 42 70 35 90   210
// 30 35 42 70 90

// 30 45 23 26 56 -> 23 26 30 45 56
// 1170

// 1 2 3 4 5  := 1을 제외한 수부터 공배수가 있는지를 찾는다.
// 5c3 = 52/ 2 321
// 4

// 2 / 1 = 2 .. 0
// 26 /23 = 1 .. 3

// 정답 로직 배열안의 3개의 최소 공배수 찾기

public class solved1145 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		int arr[] = { 30, 45, 23, 26, 56 };
		Arrays.sort(arr); // n log n
		int n = arr.length;
		// 리스트 1 생성
		List<Integer> list1 = new ArrayList<>();

		// 5000 * 5000 * 5 == 125
		for (int i = 0; i < n; i++) {
			// GCD로직
			for (int j = i + 1; j < n-1; j++) {
				int ans = gcd(arr[i], arr[j]);
				int lcs  = (arr[i] * arr[j] / ans);
				for (int k = j + 1; k < n; k++) {
					int numlcs = gcd(arr[k], lcs);
					list1.add((arr[k] * lcs / numlcs));
				}

			}

		}
		Collections.sort(list1); // n log n
		System.out.println(list1.get(0));
	}

	// 최대 공약수 로직 + 최소공배수
	private static int gcd(int a, int b) {
		int gcd = 1;
		for (int i = 2; i <= a * b; i++) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
			}
		}
		return gcd;

	}
}
