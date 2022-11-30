package Thisisjava2;

public class HankookTire extends Tire {
	// Tire설계도에서 Tire 필드를 재정의 
	
	@Override
	public void roll() {
		System.out.println("한국타이어 회전합니다");
	}
}
