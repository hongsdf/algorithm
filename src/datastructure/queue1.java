package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class queue1 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(3);
		q.add(1);
		q.offer(2);
		boolean flag = q.contains(3); //contains(a) : a를 포함하고 있는가?
		int num = q.peek();
		System.out.println(num);
		System.out.println(flag);
		q.remove(); //remove() : 큐의 가장 앞을 제거	
		int val = q.poll(); //첫번째 값을 제거하고 반환
		System.out.println(q);
		System.out.println(val);
	}
	

}
