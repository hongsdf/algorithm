package algorithm;

public class Student {
	
	private String name; // 학생 이름
	private String no; // 학번
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	// 생성
	public Student(String i, String no) {
		super();
		this.name = i;
		this.no = no;
	}
	
	
	
	
}
