package Thisisjava2;

public class CarExample {
	public static void main(String[] args) {
		// car객체 생성
		Car car = new Car();
		// 타이어 장착
		car.tire = new Tire(); // tire필드는 Tire객체이다. 타이어를 만들고 나면 
		car.run();
		// 한국타이어로 타이어를 장착하면
		car.tire = new HankookTire();
		car.run();
		
		car.tire = new GumhoTire();
		car.run();
	}
}
