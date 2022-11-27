package Thisisjava;

public class ChildExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
		
		Parnet parent = child ; // Child로 생성된 번지수를 저장한다.
	//	if(child == parent) 를 비교하는 것은 번지수를 비교하는것 true반환
		
		parent.method1();
		parent.method2(); // 다형성개념이 등장한다. 자식에서 재정의한 메서드가 실행
		
		// parent.method3(); Parnet안에는 method3메서드가 없어서 컴파일 에러
	}

}
