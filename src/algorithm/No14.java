package algorithm;

public class No14 {
	public static void main(String[] args) {
		int input = 333091029;
		
		// 0 : 3 => 최빈수
		// 1 : 1
		// 2 : 1
		// 3 : 0
		// 4:  1
		// 5:  1
		// 6 : 0
		// 7 : 0
		// 8 : 0
		// 9 : 2
		
		int arr[] = new int[10];
		
		
		while(input > 0) {
			/* arr[input%10] : 10으로 나눈 나머지 숫자를 등장횟수 1증가 */
			arr[input%10]++;
			input /=10;
		}
		
		
		
		for(int i =0; i <=9; i++) {
			// arr[i] : 등장 횟수 
			System.out.println(i+" : "+arr[i]);

		}
		int cnt = 0 ; // 최빈수 등장횟수
		int cn = 0; // 최빈수
		
		// arr[] 배열의 저장공간은 계속 유효
		for(int i =0; i<10; i++) {
		if(cnt < arr[i]) { // 0 < 3
			cn = i;
			cnt = arr[i];
			}
		}
		System.out.println("최빈수는 : "+cn+" 입니다. 등장횟수 : "+cnt);
		
		
		
		
	}
}
