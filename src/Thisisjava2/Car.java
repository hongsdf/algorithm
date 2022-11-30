package Thisisjava2;

public class Car {
	public Tire tire; // 타이어를 장착할수있다.
	//일반타이어
	//한국타이어
	//금호타이어
	
	// 다형성 사용방법은 똑깥지만 다른 결과가 발생한다.
	// 구현방법
	// 오버라이딩과 자동타입변환이 활용된다.
	
	public void run() {
		tire.roll();
	}
}
