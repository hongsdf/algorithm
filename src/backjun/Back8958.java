package backjun;

import java.util.Scanner;

public class Back8958 {

	public static void main(String[] args) {
		// "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String arr[] = new String[n];
	
		for(int i = 0; i<n;i++) {
			int tot = 0;
			int cnt = 0;
//			sc.next();// : 한줄을 입력
//			sc.nextInt(); // 정수 한줄 입력
			arr[i] = sc.next(); // n 의 객수에 맞는 배열 수생성
			for(int j =0; j <arr[i].length(); j++) {
//				arr[i].charAt(i) char -> String : 문자 (asc코드) -> 문자열
			if(arr[i].charAt(j) == 'O') {
				cnt++;
				tot += cnt;
			}else {
				cnt = 0;
			}
	
			}
			System.out.println(tot);
		}
		
		
		
	}

}
