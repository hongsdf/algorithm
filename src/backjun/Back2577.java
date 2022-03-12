package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;

public class Back2577 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.*/
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(InputStreamReader(System.in));
//		 
//		int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
		int value = (sc.nextInt() * sc.nextInt() * sc.nextInt());
		String str = Integer.toString(value);
		
//		str.charAt(value) - '0' 문자열 분해
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int sum = A * B* C;
		System.out.println(A * B * C);
		int mode[] = new int[10];
		while(sum > 0) {
//			int m  = sum%10;
			mode[sum%10]++;
			sum /= 10;
		}
//		for(int i = 0;i<mode.length; i++) {
//			System.out.println(mode[i]);
//		}
		for(int k: mode) {
			System.out.println(k);
		}
		
	}

	private static Reader InputStreamReader(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
}
