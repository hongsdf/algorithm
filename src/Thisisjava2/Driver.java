package Thisisjava2;

public class Driver {
	
	public void drive(Vehicle vehicle) {
		vehicle.run();
		if(vehicle instanceof Bus ) { // vehicle의 객체타입의 bus라면 타입변환한ㄷ
			Bus bus = (Bus)vehicle;
		}
	}
}
