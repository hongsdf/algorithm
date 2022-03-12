package algorithm;

public class No25 {
	public static void main(String[] args) {
		
		// 26 => 2 + 6 = 8  -->  68
		// 68 => 6 + 8 = 14 -->  84
		// 84 => 4 + 8 = 12 -->  42
		// 42 => 4 + 2 = 6  -->  26
		
		int n = 79; // 초기
		int res = n;
		int tmp = 0;
		int cnt = 0;
		
		do{ // 한번은 실행해 보고 조건을 확인하여 true이면 실행 아니면 종료
			tmp = res/10 + res%10;
		//         2     +   6
			res = res%10 * 10 + tmp %10; 
		//	       60   +    8
			cnt++;
			
			
		}while(n!=res); // 조건이 같아지면 종료
		
		System.out.println(cnt);
		
	}
}
