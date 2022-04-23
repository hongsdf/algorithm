package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.*/
public class Factorial {
	public static List<int[]> list;
//	public static int<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		fac(N); // 10 = 소인수 분해 1 2 5 10 2와 5의 갯수가 같을때
		solve(N); 
		// 10을 만들기 위해선 2 와 5가 필요하다
		// 2는 어차피 많다 
		// 5의 배수 갯수만 세어 주면 된다
		// 20 = 4 5
		// 1 2 4 5 10 20(2 5 2 )
		
	}


	private static void solve(int n) {
	int sum = 0;
	for(int i = 5; i <=n; i*=5) {
		sum += n/i;
	}
	System.out.println(sum);
	
}


	private static void fac(int n) {
		int sum = 1;
		for(int i = n; i >= 1; i--) {
			sum *= i;
		}
		System.out.println(sum);
		
	}
}
