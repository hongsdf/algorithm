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
		// Arrays.sort() :�� Ȱ���Ҽ� �ִ� ��� => int[],char[],short[],long[],double[]
		// primativeŸ�Թ迭
		int arr[] = { 0, 9, 1, 8, 4, 33, 63, 90 }; // 0,9,1,4,8,33 ,63,90
		Arrays.sort(arr, 2, 5); // ���� ����(2,5)
		// Ÿ�� Ȯ��
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
		// �����ϱ� ���ؼ� char[] �迭�� �������Ѵ�
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
		System.out.println("���� :" + list);

		// �ٸ� list
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 9, 8, 0, 0));
		Collections.sort(list2);
		System.out.println(list2.getClass().getSimpleName());
		System.out.println("����:" + list2);


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

		// Set<Integer> 2��°
		Set<Integer> set3 = new LinkedHashSet<>(Set.of(3, 1, 4, 6, 7));
		Iterator<Integer> iter3 = set3.iterator();
		while (iter3.hasNext()) {
			System.out.print("���" + iter3.next() + "\n");
		}

		// Set<Integer> LinkedHashSet �Էµ� ������� ����
		Set<Integer> set4 = new LinkedHashSet<>();
		set4.add(0);
		set4.add(9);
		set4.add(8);
		set4.add(3);
		set4.add(6);
		set4.add(1);
		
		Iterator<Integer> iter4 = set4.iterator();
		while (iter4.hasNext()) {
			System.out.print("���:" + iter4.next() + "\n");
		}
		System.out.println(set4.getClass().getSimpleName());
		
		
		// Map<String,Integer>
		Map<String,Integer> map1 = new HashMap<String, Integer>(Map.of("name",1,"name2",2));
		// entry�� �ҷ�����
		Set<Entry<String, Integer>> entry1 = map1.entrySet();
		System.out.println(entry1);
		// Iterator�� �ҷ�����
		Iterator<Entry<String,Integer>> itermap1 = entry1.iterator();
		while(itermap1.hasNext()) {
			System.out.println(itermap1.next());
		}
		
		// key�� ��������
		Set<String> mapkey = map1.keySet();
		//Ȯ�� ��ķ� ������
		for(String key : mapkey ) {
			System.out.println("��� -"+key);
			
			
		}
		
		
		// value�� ��������
		Collection<Integer> arr1 = map1.values();
		for(int a : arr1) System.out.println(a);
		
		
		// map treeMap 
		Map<String,Integer> TREEmap2 = new TreeMap();
		TREEmap2.put("name30", 30);
		TREEmap2.put("name4", 4);
		TREEmap2.put("name9", 9);
		TREEmap2.put("name8", 8);
		
		// entry�� �ҷ�����
		Set<Entry<String, Integer>> entry2 = TREEmap2.entrySet();
		System.out.println(entry2);
		
		// 2���� map����
		List<HashMap<String, Integer>> map2d = new ArrayList<HashMap<String, Integer>>();
		// 1���� �迭�� ���� ����
		HashMap<String, Integer> map1d1 = new HashMap<String, Integer>(Map.of("name1",1,"name3",3));
		HashMap<String, Integer> map1d2 = new HashMap<String, Integer>(Map.of("name2",2,"name4",4));
		
		// 1���� �迭���� 2������ �߰�
		map2d.add(map1d1);
		map2d.add(map1d2);
		
		
		System.out.println("2���� �迭 " +map2d);
		
		// getOrDefault  value�� �������� �޼��� �ش�Ű���� ������ ���� ������ ���� �����
		int n = map1d1.getOrDefault("name5", 5);
		System.out.println(n);
		
		// ������ �� add
		map1d1.put("name5",map1d1.getOrDefault("name5", 5));
		System.out.println("map1d1�߰� �Ѱ�"+map1d1);
		
		System.out.println(map1d1.getClass().getSimpleName());
		
		System.out.println(map2d.getClass().getSimpleName());
		
		
	}
	
}
