package Bit;

public class Bit1 {
	// 비트 연산 
	/*
	 * @비트 연산을 알고리즘에 사용하는 경우는 보통 부분집합을 사용
	 * 
	 */
	public static void main(String[] args) {
		int n = 4;
		System.out.println(1 << n); // 1 1 1 1 : 16가지 종류
		
		// 칼럼1 칼럼2 칼럼3 칼럼4
		//  o    o    x    o           1  1  0  1
		for(int i = 1; i < (1<<4); i++) {
			// 1의속성과 같은 칼럼이 있는 수들
			if((1 & i) != 0) {
//				System.out.println(i);
				 int cnt = countBits(i);
				 System.out.println(i+": 1의 갯수" + cnt);
			}
			else if((1 & i) == 0 ){
				System.out.println("1의 속성과 겹치지 않은 비트"+i);
			}
		}
		
		// 7에 0111에 맨앞자리 1의 속성 추가
		int find = 15;
		System.out.println( (~1 & find));
		
	}
	
	

	private static int countBits(int n) {
		// 1의 속성 갯수
		int cnt = 0;
		while(n != 0) {
			// 1의속성값을 포함하고 있을까?
			if((n & 1) != 0) {
				cnt++;
			}
			n = n >> 1; // 1100 -> 0110 ->0011
		}
		return cnt;
		
	}
}
