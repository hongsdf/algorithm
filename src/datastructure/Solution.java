package datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Student {
	int id;
	String name;
	double cgpa;

	Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	int getID() {
		return id;
	}

	String getName() {
		return name;
	}

	double getCgpa() {
		return cgpa;
	}

}
class STComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getCgpa() == o2.getCgpa()) {
			if(o1.getName().equals(o2.getName())) {
//				return o1.getID() - o2.getID();
				return Integer.compare(o1.getID(), o2.getID());
			}else {
				return o1.getName().compareTo(o2.getName());
			}
		}
		return Double.compare(o1.getCgpa(), o2.getCgpa());
		
	}
	
}


//class StudentComparator implements Comparator<Student> {
//    @Override
//    public int compare(Student o1, Student o2) {
//        if (o1.getCGPA() == o2.getCGPA()) {
//            if(o1.getName().equals(o2.getName())) {
//                return Integer.compare(o2.getID(), o1.getID());
//            } else {
//                return o1.getName().compareTo(o2.getName());
//            } 
//        }
//        return Double.compare(o2.getCGPA(), o1.getCGPA());    
//    }
//}

class Priorities {
     List<Student> getStudents(List<String> events) {
//        PriorityQueue pq = new PriorityQueue<>(events.size(), new StudentComparator());
        PriorityQueue p = new PriorityQueue<>(events.size(), new STComparator());
//        PriorityQueue pm = new PriorityQueue<>();
        for (String event: events) {
            String parts[] = event.split(" ");
            // ENTER STUDENT 1.0 1
            if (parts[0].equals("ENTER")) {
                Student stu = new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2]));
                p.add(stu);
            } else {
                if (!p.isEmpty()) {
                   p.poll();
                }     
            }
        }
        List<Student> list = new ArrayList<>();
        while(!p.isEmpty()) {
        	list.add((Student) p.poll());
        }
		return list;
    }
 }




//class Priorities {
//	List<Student> getStudents(List<String> events) {
//		// event  // ENTERD 12  JOHN  4.5 
//		Queue<List<String>> q = new LinkedList<>();
//		q.add(events);
//		//확인 
//		// add작업중 들어올때마다 우선순위로 정렬한다
     	// 정렬 기준
        //  cgpa >  name >id
//		// served를 만나면 가장 첫번째 요소를 제거 한다
//		// 남은 이름을 출력한다
//		return null;
//
//	}
//
//}

public class Solution {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();
	private final static Priorities pro = new Priorities();
	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = pro.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
	
}