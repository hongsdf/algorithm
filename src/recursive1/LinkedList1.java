package recursive1;

class Node{
	int val; // 값
	Node next; // 다음 노드를 가르키는 포인터
	// 노드 새성자
	public Node(int val){
		this.val = val;
	}
	// 다음 노드 설정
	public void SetNext(Node node) {
		this.next = node;
	}
	// 다음노드 가져오기
	public Node getNext() {
		return next;
	}
}


public class LinkedList1 {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
//		Node n6 = new Node(6);
//		
		n1.SetNext(n2);
		n2.SetNext(n3);
		n3.SetNext(n4);
		n4.SetNext(n5);
//		n5.SetNext(n6);
		
		// 노드를 출력하는 printLinklist()메서드 
		printLinklist(n1);
		System.out.println();
		Node reversed = reverseList(n1);
		System.out.println("뒤집기");
		printLinklist(reversed);
		
		
	}
	// 노드 뒤집기 메서드
	private static Node reverseList(Node n1) {
		if(n1 == null || n1.next == null ) {
			System.out.println("n: "+n1.val);
			return n1; // base - case // 5
		}
		Node p = reverseList(n1.next); // 2  3  4 5
		n1.next.next = n1; // 5.next = 4; 5가 4를 가르킴
		n1.next = null; //4.next = null 없음
		
		// reverseList(5)
		// reverseList(4.next == 5) return  5;
		
		// reverseList(3.next == 4) -- > p == 4, 4.next = 3, 3.next = null
		// reverseList(2.next == 3) --> p == 3, 3.next = 2, 2.next = null
		// reverseList(1.next == 2) --> p == 2, 2.next = 1, 1.next = null
		// reverseList(n1 == 1) --> p == 1
		
		
		
		
		
		// 	reverseList(5); return 5 //탈출
		//  reverseList(4.next == 5) --> p = 4
		//  reverseList(3.next == 4) --> p = 3, 4.next = 3, 3.next = null
		//  reverseList(2.next == 3) --> p = 2, 3.next = 2, 2.next = null 
		//  reverseList(1.next == 2) --> p = 1, 2.next = 1, 1.next = null
		 
		// ---------------------------
		
		
		
		
		// reverseList(4.next == 5) --> return n1 == 5 
		// 										 --> p = 5 (n1 = 4) --> (4.next) 5.next = 4; --> 4.next = null(가르키는 거 없애
		
		System.out.println("n1 :"+n1.val);
		
		
		// reverseList(3.next == 4)  --> p =4 (n1 =3)  (3.next)4.next = 3; 3.next = null
		// reverseList(2.next == 3) --> p = 3 (n1 =2)  (2.next)3.next = 2; 2.next = null 
		// reverseList(1.next == 2) --> p = 2 (n1 =1)  (1.next)2.next = 1; 1.next = null 
		
		return p; // 5 4 3 2 
	}

	private static void printLinklist(Node node) {
		Node tmp = node;
		while(tmp != null) {
			System.out.print(tmp.val +" ");
			tmp = tmp.getNext();
		}
		
	}
}
