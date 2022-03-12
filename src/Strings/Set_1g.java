package Strings;

import java.util.HashSet;
import java.util.TreeSet;

public class Set_1g {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(10);
		set.add(9);
		set.add(123123);
		set.add(23);
		set.add(1);
		System.out.println(set);
		
		
		TreeSet<Integer> treeset = new TreeSet<>();
		treeset.add(1);
		treeset.add(10);
		treeset.add(9);
		treeset.add(123123);
		treeset.add(23);
		treeset.add(1);
		System.out.println(treeset);
		
		}
	
}
