package Thisisjava;

public class Computer extends Calculator{
	@Override
	public double areaCircle(double r) {
		// TODO Auto-generated method stub
		// 100줄
		super.areaCircle(r); // 부모쪽 100줄을 그대로 사용하고 밑에추가
		
		return Math.PI * r *r;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
