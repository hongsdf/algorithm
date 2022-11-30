package Thisisjava2;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		
		driver.drive(taxi);
		driver.drive(bus); // 매개변수안에 Vehicle vehicle객체를 상속하는 자식클래스가 들어갈수있다. 실행되는 메서드는 재정의된 메서드 실행
		
	}
}
