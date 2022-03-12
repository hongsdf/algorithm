package Strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSet1 {
	public static void main(String[] args) {
		
		Set<String> hashSet = new HashSet<String>();
		Set<String> treeSet = new TreeSet<String>();
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		
		System.out.println("hashSet : 중복x , 정렬 x -> 기본적인 set 가장 빠름");
		hashSet.add("a");
		hashSet.add("b");
		hashSet.add("c");
		
		System.out.println(hashSet);
		Iterator<String> iter = hashSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("treeSet :  이진 트리 탐색법 --> 오름차순 자동정렬");
		treeSet.add("abccc");
		treeSet.add("ab");
		treeSet.add("ac");
		treeSet.add("ad");
		System.out.println(treeSet);
		Iterator<String> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
				
		linkedHashSet.add("w");
		linkedHashSet.add("a");
		linkedHashSet.add("c");
		linkedHashSet.add("b");
		linkedHashSet.add("b");
		
		System.out.println("linkedHashSet 입력순서대로 저장" );
		Iterator<String> it = linkedHashSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
				

			
//		System.out.println();
//
//		// set에선 동일 객체 저장 불가
//		linkedHashSet.add("a");
//		linkedHashSet.add("a");
//		linkedHashSet.add("c");
//		linkedHashSet.add("b");
//				
//		Iterator<String> linkedIter = linkedHashSet.iterator();
//				
//		while(linkedIter.hasNext()) {
//			System.out.println(linkedIter.next());
//		}
	}

}
