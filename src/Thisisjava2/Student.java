package Thisisjava2;

public class Student extends Person {
	public Student(String name, int stdNo) {
		super(name);
		this.stdNo = stdNo;
		// TODO Auto-generated constructor stub
	}

	public int stdNo;
	
	// student 객체에만 존재하는 메서드
	public void study() {
		System.out.println("학습중");
	}
}
