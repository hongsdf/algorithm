package algorithm;

public class No8 {
	public static void main(String[] args) {
		int in = 3;
		
		int account = 1; // 1로 설정해야 곱셈 시 유지
//		3! = 3 * 2 * 1
		// 방법1
		for(int i = in; i >=1; i--) {
			// 저장공간 account 변수
			account = account * i; // 3 * 1 , 2 * 1, 1 * 1
		}
		System.out.println("방법1"+account);
	
		account = 1;
		// 방법2
		for(int i =1; i <= in ; i++) {
			account = account * i;
		}
		System.out.println("방법2"+account);
	}
}
