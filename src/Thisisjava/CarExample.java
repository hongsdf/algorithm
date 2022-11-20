package Thisisjava;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		car.setSpeed(60);
		int speed = car.getSpeed();
		System.out.println(speed);
		
		car.setStop(true);
		System.out.println(car.getSpeed());
		
	}
}
