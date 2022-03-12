package LinkedList;

public class T1 {
	private static void printNode1(ListNode r) {
		while( r != null) {
			System.out.print(r.val);
			r = r.next;
		}
		// Exception in thread "main" java.lang.Error: Unresolved compilation problem: 클래스명 일치 패키명과 [projcet --> clean] 
	}

	public static void main(String[] args) {
		SolutionA m = new SolutionA();
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(4,l3);
		ListNode l1 = new ListNode(2,l2);
		
		ListNode m3 = new ListNode(4);
		ListNode m2 = new ListNode(6,m3);
		ListNode m1 = new ListNode(5,m2);
		
		ListNode r = m.addTwoNumbers(l1,m1);
		printNode1(r);
	}
}
class SolutionA{
	// 두 LIST노드를 가져와서 하나로 합치기
	// 그리고 역순으로 출력하기
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = new ListNode(0); // 이 곳에 List노드 두개를 합칠 공간이다.
		ListNode temp = p; //원본 복사본
		int sum = 0;
		while(l1 != null || l2 !=null ) {
			int n = sum;
			if(l1 != null) {
				n += l1.val;
				l1 = l1.next;
				
			}
			
			if( l2 != null) {
				n += l2.val;
				l2 = l2.next;
				
			}
			if(n >= 10) {
				p.next = new ListNode(n - 10); // 한자릿수 올라갔다
				sum = 1; //한자리수올라갔다.
			}else {
				p.next = new ListNode(n) ;
				sum = 0; // 이걸 해줘야함
			}
			p = p.next;
			
			if( sum == 1) {
				p.next = new ListNode(1);
			}
		}
		return temp.next;
	}
}

//while(l1 != null) {
//	sum += l1.val;
//	l1 = l1.next;
//}
//
//while(l2 !=null) {
//	sum += l2.val;
//	l2 = l2.next;
//}
//// 999 + 999 =   1998
//if(sum > 0) {
//	// 역순으로 출력할수있는 새로운 방법
//	p.next = new ListNode(sum %10); //8 9 9 1
//	
//	
//	
//	if(sum > 10) {
//		sum /= 10;
//	}
//	
//	p = p.next; //p 전진 시키기
//	
//}
//
//
//return temp.next; // sum ==0 이면 temp --> p(0)이므로
////return 0;