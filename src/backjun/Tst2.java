package backjun;

public class Tst2 {
	public static void main(String[] args) {
		int max = Integer.MAX_VALUE; //  2,147,483,647
		int min = Integer.MIN_VALUE; // -2,147,483,648
		
		System.out.println("max : " +max);
		System.out.println("min : " +min);
		
		
		System.out.println("===에러 발생======");
		
		
		
		System.out.println("에러 max : " +(max+1)); //overflow : int형 상한선을 벗어나 잘못된 값 출력
		System.out.println("에러 min : " +(min-1)); // underflow : int형 하한선을 벗어나 잘못된 값 출력
		
	}
	
	
}
