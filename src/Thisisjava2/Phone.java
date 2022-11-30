package Thisisjava2;

public abstract class Phone { // abstract 선언된 클래스는 객체로 생성할수없다.
	// 필드 선언
	String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	// 메서드 블록
	public void turnOn() {
		System.out.println("전원을 켭니다");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다");
	}
}
