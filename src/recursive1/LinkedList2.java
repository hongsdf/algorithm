package recursive1;

class NODE1{
	int val;
	NODE1 next; 
	
	NODE1(int val){
		this.val = val;
	}
//	NODE1(NODE1 next,int val){
//		this.val = val;
//	}
	
	public void SetNext(NODE1 node) {
		this.next = node; //1.setNext(2)
	}
	
	public NODE1 getNode() {
		return next;
	}
}




public class LinkedList2 {
	public static void main(String[] args) {
		NODE1 n1 = new NODE1(1);
		NODE1 n2 = new NODE1(2);
		NODE1 n3 = new NODE1(3);
		NODE1 n4 = new NODE1(4);
		NODE1 n5 = new NODE1(5);
		
//		NODE1 n11 = new NODE1(n2,5);
		
		n1.SetNext(n2);
		n2.SetNext(n3);
		n3.SetNext(n4);
		n4.SetNext(n5);
		
		printedLinkedList(n1);
		// µÚÁý±â
		printedLinkedListReverse(n1);
	}

	private static void printedLinkedListReverse(NODE1 node) {
		if(node == null || node.next == null) {
//			System.out.println();
//			System.out.print(node.val+" ");
			return;
		}
		
		 printedLinkedListReverse(node.next);
		 // printedLinkedListReverse(1.next)
		 // printedLinkedListReverse(2.next)
		 // printedLinkedListReverse(3.next)
//	*	 // printedLinkedListReverse(4.next)
//	*	 // printedLinkedListReverse(5)
		 node.next.next = node; // 4 --> 3
		 node.next = null;
		 System.out.println();
		 System.out.print(node.val+" ");
		
	}

	private static void printedLinkedList(NODE1 node) {
		// TODO Auto-generated method stub
//		NODE1 N = node.getNode();
//		System.out.println(N.val);
		
//		NODE1 tmp = node;
//		while(tmp != null) {
//			System.out.print(tmp.val+" ");
//			tmp = tmp.getNode();
//		}
		while(node != null) {
			System.out.print (node.val+" ");
			node = node.getNode();
			
		}
		
		
	}
}
