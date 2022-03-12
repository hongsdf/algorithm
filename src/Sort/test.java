package Sort;

import java.util.*;

class Student0{ 
	private int id;
	private String fname;
	private double cgpa;
	public Student0(int id, String fname, double cgpa) {
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

class StudentComparator0 implements Comparator<Student0>{

	@Override
	public int compare(Student0 s1, Student0 s2) {

		double cgpa1 = s1.getCgpa();
		double cgpa2 = s2.getCgpa();

		if(Math.abs(cgpa1 - cgpa2)<.00000001){
			int fnameCom = s1.getFname().compareTo(s2.getFname());
			if(fnameCom==0){
				return s1.getId()-s2.getId(); 
			}
			return fnameCom;
		}

		return (cgpa1<cgpa2)?1:(cgpa1>cgpa2?-1:0);
	}

}

public class test
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student0> studentList = new ArrayList<Student0>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student0 st = new Student0(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
		Collections.sort(studentList, new StudentComparator0());
		for(Student0 st: studentList){
			System.out.println(st.getFname());
		}
	}
}