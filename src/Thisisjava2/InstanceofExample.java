package Thisisjava2;

public class InstanceofExample {
	public static void personInfo(Person person) {
		System.out.println("name :"+person.name);
		person.walk();
		
		if(person instanceof Student) {
			Student student = (Student) person;
			System.out.println("학생번호"+student.stdNo);
			student.study();
		}
		
	}
	
	public static void main(String[] args) {
		// Person p1 = new Person("홍진호");
		//p1.walk();
		personInfo(new Person("홍진호"));
		
		personInfo(new Student("쉬리",30));
		
	}
}
