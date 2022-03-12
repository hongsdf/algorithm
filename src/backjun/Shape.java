package backjun;

public class Shape {
	public static void main(String[] args) {
		
		Rectangle a = new Rectangle(10, 20);
		childRectangle cr = new childRectangle(20, 30);
		System.out.println(a.size());
		System.out.println(cr.size());
		
		
	
		
		
	}

}
class childRectangle extends Rectangle{

	
	// 부모상속 받음
	childRectangle(int width, int height) {
		super(width, height); // 부모 생성자를 그대로 사용
		
	}

	int depth =30;
	
	int size() {
		return width * height * depth;
	}
	
	
	
}

class Rectangle{
	int width;
	int height;
	
	Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	int size() {
		return width * height;
	}
}



