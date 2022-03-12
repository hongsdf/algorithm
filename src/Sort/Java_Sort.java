package Sort;

import java.util.*;
import java.math.*;
class Student5{
	private int id;
	private String fname;
	private double cgpa;
  
	public Student5(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
	
	
}
class Student5Comparetor implements Comparator<Student5>{

//	@Override
//	public int compare(Student5 s1, Student5 s2) {
//
//		double cgpa1 = s1.getCgpa();
//		double cgpa2 = s2.getCgpa();
//
//		if(cgpa1 == cgpa2){ // 같지 않은조건 (0)이면 실행되는 부분 d1 == d2가 같을때만 실행
//			int fnameCom = s1.getFname().compareTo(s2.getFname());
//			if(fnameCom==0){
//				return s1.getId()-s2.getId(); 
//			}
//			return fnameCom;
//		}
//
//		return (cgpa1<cgpa2)?1:(cgpa1>cgpa2?-1:0);
//	}	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int compare(Student5 o1, Student5 o2) {
		double d1 = o1.getCgpa(); // 0.0001 1.2
		double d2 = o2.getCgpa(); // 0.02 
		
		if(d1 == d2) { // d1 == d2 경우만 실행
			 int fn = o1.getFname().compareTo(o2.getFname()); //오름 차순
			 if(fn  == 0 ) {
				 return o1.getId() - o2.getId(); // 오름차순
			 
			 }
			return fn;
			
		}
		// d2 = 500.0 d1 = 100
		// d2 != d1인 경우만 실행 1. d1> d2 , 2. d1 < d2 
		return (d1 < d2) ?  1 : (d1 > d2 ? -1 : 0); // d1 > d2 참이면 1 ,아니면 (d1 > d2 ? )메서드 실행
		// 3 가지 조건을 한번에 확인 하기 위해
		// (cgpa1<cgpa2)?1:(cgpa1>cgpa2?-1:0);
	}
	
}


//Complete the code
public class Java_Sort{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student5> studentList = new ArrayList<Student5>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student5 st = new Student5(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
		// 필수
		Collections.sort(studentList, new Student5Comparetor()); // Student5Comparetor 정렬기준으로 정렬;
		
      	for(Student5 st: studentList){
			System.out.println(st.getFname());
		}
	}
}



