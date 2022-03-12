package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class No1_StudentInfo {
	public static void main(String args[]) {
		Student stu1 = new Student("홍길동","001");
		Student stu2 = new Student("고길동","002");
		Student stu3 = new Student("롱길동","003");
		
		ArrayList<Student> list = new ArrayList<>(); // 학생클래스의 arrylist를 list로 저장
		
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
//		System.out.println(list.add(stu2));
		
		
//		
//		for(Student st : list) {
//			System.out.println(st.getName()); // 학생 이름 가져오기
//			System.out.println(st.getNo()); // 학번 가져오기
//		}
//		
//		 'y' or 'n' 기능
		Scanner sc = new Scanner(System.in);
		
		
		
			
		while(true) {
			System.out.println("검색하시려면 y 아니면 n을 입력하세요");
			String in = sc.next();
			
			if(in.equals("y")) {
				System.out.println("검색을 시작합니다");
				System.out.println("학생이름을 검색하시오");
				boolean flag = false;
				String name = sc.next();
					for(Student st : list) {
						if(st.getName().equals(name)) {
							System.out.println(name + "의 학번은 : "+ st.getNo() + "입니다");
							flag = true; // flag가 true가 아니면 연속으로 검색 x
						}
						
						
					}
				if(!flag) { // flag : 확인여부 => !flag : false
					System.out.println("해당 학생없음"); break;
				}
			}
			else if(in.equals("n")) {
				break;
			}
			
		}
		System.out.println("종료");
	}
}
