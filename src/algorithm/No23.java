package algorithm;

import java.util.*; 

public class No23 {
	public static void main(String[] args) {
		
		// 내가 생각한 방법
		String n = "ABCDEF";
		// FEDCBA
		char c;
		c = n.charAt(0);
//		System.out.println(c);
		
		for(int i = n.length()-1; i >= 0; i--) {
			c = n.charAt(i);
			System.out.print(c);
		}
		System.out.println("=============");
		
		// 다른 풀이법
		String n2 = "ABCDEF";
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		System.out.println(list);
		
		for(int  i = list.size()-1; i >=0 ; i--) {
			System.out.print(list.get(i));
		}
		
		
		
		list.add(0, "2");
		list.clear();
		list.add(n2);
		System.out.println(list);
		char b;
		
		
	}
}
