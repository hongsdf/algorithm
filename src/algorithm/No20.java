package algorithm;

public class No20 {
	
	
	/*
	 * 요점 정리
	 * 메서드 타입과 반환타입이 같아야 한다
	 * 그리고 매개변수로 int(String)형 받더라도 매서드 타입과 반환타입은 반드시 일치
	 * 내부 기능에서는 String,boolean,int 전부 사용 가능하다 => 매서드 타입과 반환형만 일치하면 된다 
	 * 
	 * 
	 * */
	
	
	// method 
	
	public static int three369(int n) {
		int cnt = 0;
		
		while(n > 0) {
			// String o = "helloword";  내부 클래스에서 여러 타입 변수 사용 가능
			if(n%10 ==3 || n% 10 == 6 || n % 10 == 9) 
				cnt++;
			// System.out.print(o);
				n /= 10;
			
			
		
		}
		return cnt;
	}
	
	
	
	public static void main(String[] args) {
		/* 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 14 15 짝 17 18 짝 20 21 22 짝 24 25 짝 27 28 짝
		 * 짝 짝 짝 짜짝(33) 짝 짝 짝짝(36) 짝 짝 짝짝(39) 40 41 42 짝
		 * 
		 * */
		
		for(int i = 1; i <= 100; i++) {	
			 int v = three369(i);
			 
			 if(v == 0){
				 System.out.print(i+" ");
			 }
			 else{
				 for(int j = 0;  j < v; j++) {
					 System.out.print("짝");
				 }
				 System.out.print(" ");
			 }
			
		}
	}
}
