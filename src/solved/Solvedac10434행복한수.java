package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solvedac10434행복한수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			boolean flag = true;
			Set<Integer> set = new HashSet<>();
			String str[] = br.readLine().split(" ");
			int index = Integer.parseInt(str[0]);
			
			int number = Integer.parseInt(str[1]);
			
			int N = number;
			
			// 구현
			// 1이 되는 수를 행복한 수가 되면 종료 일단 한번은 실행한다.
			do {
				String number2 = String.valueOf(number);
				char c[] = number2.toCharArray();
				int sum = 0;
				for(int i = 0; i <c.length; i++) {
					int num	= c[i]-'0';
					sum += (num * num);
					
				}
				number = sum;
				if(!set.contains(number)) {
					set.add(number);
				}else {
					flag = false;
					break;
				}
				
				if(number == N) { // 1이 아니라 자신의 값으로 돌아오면
					flag = false;
					break;
				}else if(number == 1) {
					// 소수 검증
					if(check(N)) {
						flag = true;
					}else {
						flag = false;
					}
					break;
				}
				
				
				
			}while(number != N);
			// 정답
			System.out.println(index +" "+ N +" "+(flag == true? "YES":"NO"));
			
		}
	}

	private static boolean check(int i) {
		boolean flag = true;
		if(i == 1) {
			return false;
		}
		
		for(int j = 2; j <=(int)Math.sqrt(i); j++) {
			if(i%j == 0) {
				flag = false;
				break;
			}
		}
		return flag;
		
	}
}
