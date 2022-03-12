package Sort;

import java.util.Comparator;

public class comparator_2 {
	public static void main(String[] args) {
		Student3 s1 = new Student3(10, 1, "고길동");
		Student3 s2 = new Student3(20, 1, "초길동");
		Student3 s3 = new Student3(30, 2, "베길동");
		
		int ans = s3.compare(s1, s2);
		
		if(ans > 0) {
			System.out.println("s1 이 더 큽니다");
		}
		else if(ans == 0) {
			System.out.println("나이가 같다");
		}else {
			System.out.println("s2 가 더 크다");
		}
		
	}
}
class Student3 implements Comparator<Student3>{
	// 필요한 요소
	int age; // 나이
	int grade; // 학년
	String name; // 이름
	
	Student3(int age,int grade, String name){
		this.age = age;
		this.grade = grade;
		this.name = name; 
	}

	@Override
	public int compare(Student3 s1, Student3 s2) {
		if(s1.age > s2.age) {
			return 1;
		}else if(s1.age == s2.age) {
			return 0;
		}else {
			return -1;
		}
		
	}
	
}