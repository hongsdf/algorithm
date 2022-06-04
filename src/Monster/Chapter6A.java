package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter6A {
	public static int d[];

	public static void main(String[] args) throws NumberFormatException, IOException {
//		먼저 배열을 만든다.
		d = new int[101]; // 100까지라 가정
		//초기값 세팅이 필요
		d[1] = 1;
		d[2] = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = fib(N);
		System.out.println(num);
	}

	private static int fib(int n) {
		// base-case
		if(d[n] != 0) return d[n];
		
		return fib(n-1) + fib(n-2);
	}
}
