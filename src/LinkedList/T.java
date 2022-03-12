package LinkedList;


class T {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 // 처음 노드의 값은 0
		 ListNode node = new ListNode(0);
		 // 결과를 반환할 Listnode
		 ListNode ans = node; // 0  1 2 .. 여기 이해 필요함
//		                         0  7
		 //                      7  0 8 0
//		  8 0 7 0
		 
		 int sum = 0;
		
		 // 두 노드의 에서 꺼내 하나로 합치는 방법
		 while( l1 != null || l2 != null || sum > 0) {
			 if(l1 != null) {
				 sum += l1.val;
				 l1 = l1.next;
				 
			 }
			 // linkedList의 해당 노드의 값들을 꺼내고
			 if(l2 != null) {
				 sum += l2.val;
				 l2 = l2.next; // 다음 노드로 전진 시킴
			 }
			
			 node.next = new ListNode(sum % 10); // 7 0 8
			 sum /= 10; // 0 1 0
			 
			 node = node.next; // 다음 노드 진행
		 }
		 
		 // 핵심
		 return ans.next; // 0 7 0 8 로 들어가 있다. 
//		 그래서 0의 다음부터인 7 0 8이 출력된다
	 }
}
