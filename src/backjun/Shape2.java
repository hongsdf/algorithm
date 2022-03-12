package backjun;

public class Shape2 {
	public static void main(String[] args) {
	Rectangle2 b1 = new Rectangle2();
	
	// 익명 객체 : 클래스이름을 정의 하지 않고 매서드를 구현한것 (단 생성자는 있으면 안됨) => 즉 같은 클래스이면서 다른기능을 추가 하고 싶을때
	Rectangle2 b = new Rectangle2() {
		int n = 2;
		
		int size() {
			return n * width * height;
		}
	};
	int res = b1.size();
	System.out.println(res);
	
	int ans = b.size();
	System.out.println(ans);
	
	
	}
}
class Rectangle2{
	int width =30;
	int height = 100;
	
	int size() {
		return width * height;
	}
}