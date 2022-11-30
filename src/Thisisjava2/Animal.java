package Thisisjava2;

public abstract class Animal {
	public void breathe() {
		System.out.println("숨을 쉰다");
	}
	public abstract void sound(); // abstract 매서드는 {}가 없다 무조건 자식클래스에서 재정의해야한다.	
}
