package algorithm;

public class No32 {
	/*return을 void 함수에서  사용하는 경우(조건문) 탈출한다,*/
	static void num(int x) {
		if(x/10 == 0) {
			System.out.println(x);
			return; // * 탈출한다는 의미 
		}
		// 재귀함수의 탈출조건이 되기 까지 stack 으로 함수가 쌓이게 된다
		// stack 이란 후입선출
		// num(2) 에서 탈출조건이 풀리게 된다 => 그러면 역으로 num(23) -> num(231)로 올라가며 출력하게된다.
		num(x/10); // num(231) - num(23) - num(2)
		// num(2) 이후로 함수 풀림
		System.out.println(x%10); // 함수가 풀린후 실행이된다.
		
		//2
		//3
		//1
		//2
		
	}
	
	
	public static void main(String[] args) {
		/*입력된 수를 높은 자릿수 부터 출력하시오
		2312

		정답:
		2
		3
		1
		2
		*/
		
		int n = 2012;
		
		
		num(n);
	}
}
