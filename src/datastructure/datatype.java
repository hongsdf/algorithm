package datastructure;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class datatype {
	public static void main(String[] args) {
		// Arrays.sort() :을 활용할수 있는 경우 => int[],char[],short[],long[],double[]
		// primative타입배열
		int arr[] = { 0, 9, 1, 8, 4, 33, 63, 90 }; // 0,9,1,4,8,33 ,63,90
		Arrays.sort(arr, 2, 5); // 범위 지정(2,5)
		// 타입 확인
		System.out.println(arr.getClass().getSimpleName());
		for (int a : arr)
			System.out.println(a);

		// float
		float f1[] = { 1, 2.2f, 3.5f, 6.9f, 90.5f };
		Arrays.sort(f1);
		System.out.println(f1.getClass().getSimpleName());
		for (float f : f1) {
			System.out.println(f);
		}

		// string[]
		String s[] = { "abcw", "123", "vbbca", "abvc" };
		Arrays.sort(s);
		System.out.println(s.getClass().getSimpleName());
		for (String w : s) {
			System.out.println(w);
		}

		// String
		String s1 = "1on0901w";
		// 정렬하기 위해선 char[] 배열로 만들어야한다
		char c[] = s1.toCharArray();
		Arrays.sort(c);
		System.out.println(c.getClass().getSimpleName());
		System.out.println(c);

		// List
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(9);
		list.add(8);
		list.add(0);
		list.add(0);
		Collections.sort(list);
		System.out.println("정렬 :" + list);

		// 다른 list
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 9, 8, 0, 0));
		Collections.sort(list2);
		System.out.println(list2.getClass().getSimpleName());
		System.out.println("정렬:" + list2);

		// List<Stirng>
		List<String> slist1 = new ArrayList<>(Arrays.asList("1", "2", "abc", "9"));
		Collections.sort(slist1);
		System.out.println(slist1);

		// Set<Integer>
		Set<Integer> set1 = new HashSet<>(Set.of(3, 1, 4, 6, 7));
		Iterator<Integer> iter = set1.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + "\n");
		}
		Set<Integer> set2 = Set.copyOf(set1);
		System.out.println("set2" + set2);

		// Set<Integer> 2번째
		Set<Integer> set3 = new LinkedHashSet<>(Set.of(3, 1, 4, 6, 7));
		Iterator<Integer> iter3 = set3.iterator();
		while (iter3.hasNext()) {
			System.out.print("출력" + iter3.next() + "\n");
		}

		// Set<Integer> LinkedHashSet 입력된 순서대로 받음
		Set<Integer> set4 = new LinkedHashSet<>();
		set4.add(0);
		set4.add(9);
		set4.add(8);
		set4.add(3);
		set4.add(6);
		set4.add(1);
		
		Iterator<Integer> iter4 = set4.iterator();
		while (iter4.hasNext()) {
			System.out.print("출력:" + iter4.next() + "\n");
		}
		System.out.println(set4.getClass().getSimpleName());
		
		
		// Map<String,Integer>
		Map<String,Integer> map1 = new HashMap<String, Integer>(Map.of("name",1,"name2",2));
		// entry로 불러오기
		Set<Entry<String, Integer>> entry1 = map1.entrySet();
		System.out.println(entry1);
		// Iterator로 불러오기
		Iterator<Entry<String,Integer>> itermap1 = entry1.iterator();
		while(itermap1.hasNext()) {
			System.out.println(itermap1.next());
		}
		
		// key만 가져오기
		Set<String> mapkey = map1.keySet();
		//확장 행렬로 가져옥
		for(String key : mapkey ) {
			System.out.println("출력 -"+key);
			
			
		}
		
		
		// value만 가져오기
		Collection<Integer> arr1 = map1.values();
		for(int a : arr1) System.out.println(a);
		
		
		// map treeMap 
		Map<String,Integer> TREEmap2 = new TreeMap();
		TREEmap2.put("name30", 30);
		TREEmap2.put("name4", 4);
		TREEmap2.put("name9", 9);
		TREEmap2.put("name8", 8);
		
		// entry로 불러오기
		Set<Entry<String, Integer>> entry2 = TREEmap2.entrySet();
		System.out.println(entry2);
		
		// 2차원 map정렬
		List<HashMap<String, Integer>> map2d = new ArrayList<HashMap<String, Integer>>();
		// 1차원 배열을 먼저 생성
		HashMap<String, Integer> map1d1 = new HashMap<String, Integer>(Map.of("name1",1,"name3",3));
		HashMap<String, Integer> map1d2 = new HashMap<String, Integer>(Map.of("name2",2,"name4",4));
		
		// 1차원 배열들을 2차원에 추가
		map2d.add(map1d1);
		map2d.add(map1d2);
		
		
		System.out.println("2차원 배열 " +map2d);
		
		// getOrDefault  value를 가져오는 메서드 해당키값이 있으면 쓰고 없으면 새로 만든다
		int n = map1d1.getOrDefault("name5", 5);
		System.out.println(n);
		
		// 가져온 것 add
		map1d1.put("name5",map1d1.getOrDefault("name5", 5));
		System.out.println("map1d1추가 한것"+map1d1);
		
		System.out.println(map1d1.getClass().getSimpleName());
		
		System.out.println(map2d.getClass().getSimpleName());
		
		
	}
	
}
