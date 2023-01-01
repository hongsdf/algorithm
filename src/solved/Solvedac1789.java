package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그룹수를 늘려야한다.

public class Solvedac1789 {
	public static long size = 4294967296L;
	public static int cnt = 0;
	public static long visit[] = new long[100]; // 이해
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 로직 구현
		int i = 1;
		while(N >= i) {
			N = N-i;
			cnt++;
			i++;
			
		}
		
		
		System.out.println(cnt);
		
		
	}
}
