package Thisisjava;

public class ChildExample2 {
	public static void main(String[] args) {
		Parnet parent = new Child(); // 부모 클래스보다 작은객체로 생성가능
		parent.field = "val";
		
		parent.method1();
		
		
		parent.method2(); // Override 메서드 (다형성)
		
		// parent.field2 = "data"; //  Parnet 객체안에는 field2라는 필드가 없다
		// Parnet.method3();// //  Parnet 객체안에는 method3()라는 매서드가 없다
		
		// 강제 타입 변환
		// field2,method3()를 사용하기 위해서
		Child child = (Child)parent;
		child.field2 = "child2";
		child.method3();
	}
}
