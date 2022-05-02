package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복이 가능한 순열
// 순열은 r크기의 저장공간이 있어야한다
// pos == r 조건일때 탈출 조건
// 순열은 pos가 움직인다.

// pos := 깊이를 의미

public class N_M3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N개 중
		int M = Integer.parseInt(st.nextToken()); // M개를 만든다
		int[] output = new int[M]; // 순열 저장 공간
		permute(0, output, N, M);

	}
	// 4 2

	private static void permute(int pos, int[] output, int n, int m) {
		if (pos == m) {
			print(output, m); // 저장공간에 있는 것을 출력
			return;
		}
		for (int i = 0; i < n; i++) {
			// 중복이 가능하면 visit 방문여부를 만들지 않아도 된다.
			output[pos] = i + 1;
			permute(pos + 1, output, n, m);

		}
	}

	private static void print(int[] output, int m) {
		for (int i = 0; i < m; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();

	}

}
