package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	public void SetNext(ListNode node) {
		this.next = node;
	}
}
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		 nodeListreverse(l1);
//		 nodeListreverse(l2);
//    	
//    	
//    	return l2;
//        
//    }
//
//	
//}


public class leetcode1 {
	public static void main(String[] args) {
//		ListNode n3 = new ListNode(3);
//		ListNode n2 = new ListNode(4, n3);
//		ListNode n1 = new ListNode(2, n2);
//		
//		ListNode m3 = new ListNode(4);
//		ListNode m2 = new ListNode(6, m3);
//		ListNode m1 = new ListNode(5, m2);
		
		
		////2번 케이스
//		ListNode n1 = new ListNode(0);
//		
//		
//		ListNode m1 = new ListNode(0);
		
		
		////3번 케이스
//		ListNode n6 = new ListNode(9);
//		ListNode n5 = new ListNode(9, n6);
//		ListNode n4 = new ListNode(9, n5);
//		ListNode n3 = new ListNode(9, n4);
//		ListNode n2 = new ListNode(9, n3);
//		ListNode n1 = new ListNode(9, n2);
		ListNode n6 = new ListNode(9);
		ListNode n5 = new ListNode(9);
		ListNode n4 = new ListNode(9);
		ListNode n3 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		ListNode n1 = new ListNode(9);
		
		n1.SetNext(n2);
		n2.SetNext(n3);
		n3.SetNext(n4);
		n4.SetNext(n5);
		n5.SetNext(n6);
		
		
//		
		ListNode m4 = new ListNode(9);
		ListNode m3 = new ListNode(9, m4);
		ListNode m2 = new ListNode(9, m3);
		ListNode m1 = new ListNode(9, m2);
		
		
		
		//////
//		List<Integer> temp1 = printNode2(n1);
//		Collections.reverse(temp1);
//		///////
//		List<Integer> temp2 = printNode2(m1);
//		Collections.reverse(temp2);
		
		
		
		///////
//		System.out.println();
//		int temp2[] = printNode2(m1);
//		int reversetemp2[] = reverse(temp2);
//		for(int i =0 ; i <reversetemp2.length; i++) {
//			if(reversetemp2[i] != 0)
//			System.out.print(reversetemp2[i]);
//		}
//		
		///////
		
//		n1 = nodeListreverse(n1);
//		printNode(l1);
		
//		n2 = nodeListreverse(m1);
//		printNode(l2);
		
		System.out.println("최종 결과본");
		ListNode a = addTwoNumbers(n1,m1);
		printNode(a);
//		System.out.println(a);
		// 2 4 3
//		printNode(n1);
//		printNode(m1);
	}
	private static int[] reverse(List<Integer> temp1) {
		// TODO Auto-generated method stub
//		
		int reversetemp1[] = new int[temp1.size()];
		
		int j =0;
		for(int i = temp1.size() -1 ; i >=0; i--) {
		
			reversetemp1[j++] = temp1.get(i);
		}
		
		return reversetemp1;
		
		
		
		
	}
	public static ListNode  addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> result1 = new ArrayList<Integer>();
		ListNode p = new ListNode();
		l1 = nodeListreverse(l1);
		l2 = nodeListreverse(l2);
		String sum = printNode(l1);
		String sum2 = printNode(l2);
		int result = Integer.parseInt(sum)+Integer.parseInt(sum2);
    	System.out.println("여기"+result);
		int i =1;
		
    	while(result > 0) {
    		int a = result %10;
    		
    		result = result/10;
    		
    	}
    	if(result1.isEmpty()) {
    		result1.add(0);
    	}
    		
		
    	
    	
    	
    	
    	return p;
        
    }

	private static ListNode nodeListreverse(ListNode node) {
		if(node == null || node.next == null) return node;
		ListNode p = nodeListreverse(node.next);
		node.next.next = node;
		node.next = null;
		return p;
			
	
		
		
		
		
		
	}
	private static String printNode(ListNode node) {
		String sum = "";
		while( node != null) {
//			System.out.print(node.val);
			sum += String.valueOf(node.val);
			node = node.next;
		}
		return sum;
		
	}
	
	private static List<Integer> printNode2(ListNode node) {
		List<Integer> temp = new ArrayList<Integer>();
		int i =0;
		while( node != null) {
//			System.out.print(node.val);
			temp.add(i, node.val);
			node = node.next;
			i++;
		}
		return temp;
		
	}
	
}

