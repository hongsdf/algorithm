package algorithm;

public class No6 {
// 최대 공약수 구하기
	/* 핵심 요점 정리
	 * 두수 중 큰수 와 작은수를 구별
	 * (경우의 수)
	 * num1 > num2
	 * num1 == num2
	 * num1 이 num2 에 포함 될 경우 (4 , 8)
	 * 
	 */
	public static void main(String[] args) {
		
		int num1 = 5;
		int num2 = 3;
		
//		최대 공약수 : 2
		
//		2,4 
		int big;
		int small;
		
		int gcd =1; //최대 공약수 기본 초기값
		
		if(num1 >num2) {
			big = num1;
			small = num2;
		}else {
			big = num2;
			small = num1;
		}
		
		
//		1.num1 > num2 경우
//		6 10 == 7
		
		
//		2.num1 == num2
		
//		3.num1이 num2에 포함될경우
//		4 8  ==4
		
		for(int i = 1; i <=small ;i++) {
			if(big % i ==0 && small % i ==0) {
				// 최대 공약수 갱신
				gcd = i;
			}
		}
		System.out.println(gcd);
	}
}
