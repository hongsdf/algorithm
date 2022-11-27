package Thisisjava2;

import Thisisjava.A;

public class D extends A{
	public D() {
		// 생성자 상속받는것은 가능
		super(); // protected A() {} 선언가능
	}
	
	protected void method() {
		this.field = "val";
		this.method();
	}
	
	public void method2() {
		// A a = new A(); // 직접 객체 생성 불가능
	}
}
