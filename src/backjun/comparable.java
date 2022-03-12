package backjun;
public class comparable{
	public static void main(String[] args) {
//		Student st1 = new Student(30, "홍길동");
//		Student st2 = new Student(20,"니코");
		
		// int형 범위를 벗어나는 경우
		int max = Integer.MAX_VALUE; //  2,147,483,647(2^31)-1
		int min = Integer.MIN_VALUE; // -2,147,483,648 ( 2^31)
		Student st1 = new Student(1, "홍길동");
		Student st2 = new Student(min,"니코");
		
		
		int ans = st1.compareTo(st2); // 1 - (-2,147,483,648) = 양수값 예상
		
		if(ans > 0) {
			System.out.println("st1 이 더 크다");
		}
		else if(ans ==0) {
			System.out.println("같다");
		}
		else {
			System.out.println("st2가 더 크다 ");
		}
	}
}








class Student implements Comparable<Student> {
		// 필요한 자료들
		int age; // 나이
		String name; // 이름
		
		Student(int age,String name) {
			this.age = age;
			this.name = name;
	
		
}

	

	@Override
	public int compareTo(Student o) {
//		if(this.age > o.age) return 1;
//		else if(this.age == o.age) return 0;
//		else return -1;
			
		return this.age-o.age;
		// 만약 int 형 범위를 벗어나는 경우
		
	}
}
