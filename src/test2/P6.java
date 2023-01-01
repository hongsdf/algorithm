package test2;

interface I1{
	void m1();
}
interface I2 extends I1{
	void m2();
}
interface I3{
	void m3();
}
class A implements I3{

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}
	
}
class B extends A implements I2{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}
	
}

public class P6 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		I1 i1 = b;
		I2 i2 = a;
		I3 i3 = b;
		a =b;
	}
}
