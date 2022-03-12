package backjun;

import java.util.Comparator;

public class comparator {
	public static void main(String[] args) {
		Student2 st1 = new Student2(20, 1, "홍길동");
		Student2 st2 = new Student2(21, 2, "길동");
		Student2 st3 = new Student2(23, 3, "초길동");
		
		// st2,st3를 비교한다  이때 st1은 의미 없다
		int ans = st1.compare(st2, st3);
		// st1을 비교하고 싶다면
//		int ans = st1.compare(st1, st3);
		
		if(ans > 0) {
			System.out.println("st2가 더 크다");
		}else if(ans < 0) {
			System.out.println("st3가 더 크다");
		}
		else {
			System.out.println("같다");
		}
	

	
	}
	 
}
class Student2 implements Comparator<Student2>{
	// 필요한 요소
	int age; // 나이
	int grade; // 학년
	String name; // 이름
	
	Student2(int age,int grade, String name){
		this.age = age;
		this.grade = grade;
		this.name = name; 
	}
	
	
	@Override
	public int compare(Student2 o1, Student2 o2) { // comparable()과 다르게 두객체를 비교하는것 
		if(o1.age > o2.age) {
			return 1;
		}
		else if(o1.age == o2.age) {
			return 0;
			
		}else return -1; 
		
		
	
	}
}
	
	
	

	

