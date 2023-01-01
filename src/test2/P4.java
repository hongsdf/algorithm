package test2;

class Card{
	static int cnt;
	int data;
	Card(int data){
		this.data = data;
		cnt++;
	}
}
class Person{
	int no = 10;
	String name;
	Person(int no){
		this.no = no;
		System.out.println("Person(int no) 호출됨");
	}
	Person(int no,String name){
		this(no);
		this.name = name;
		System.out.println("Person(int no,String name) 이 호출됨");
	}
}
public class P4 {
	public static void main(String[] args) {
//		Card car1 = new Card(1);
//		Card car2 = new Card(1);
//		Card car3 = new Card(1);
//		
//		System.out.println(Card.cnt);
		
//		try {
//			System.out.print(10/0);
//			System.out.print("a");
//		}catch(Exception e) {
//			System.out.print("b");
//		}finally {
//			System.out.print("a");
//		}
//		System.out.print("d");
		
		Person p = new Person(100,"김철수");
		System.out.println(p.no);
	}
	
	
	
}
