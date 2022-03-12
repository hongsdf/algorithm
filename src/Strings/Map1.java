package Strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class Map1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		Map<String,Integer> hashTable = new Hashtable<>();
//		Map<String,Integer> Properties = new Properties<String,Integer>();
		Map<String,Integer> TreeMap = new TreeMap<>();
		Map<String,Integer> LinkedHashMap = new LinkedHashMap<>();
		
		map.put("A", 90);
		map.put("B", 80);
		map.put("C", 79);
		
		boolean res1 = map.containsKey("A");
		boolean res2 = map.containsValue(90);
		
		map.get("B");
		map.get("D");
		
		if(map.isEmpty()) {
			System.out.println(" 비어 있음");
		}
		
	
		Set<String> key = map.keySet();
		for(String k: key) {
			System.out.println(k);
		}
		System.out.println();
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Set<Entry<String, Integer>> entry = map.entrySet();
		for(Entry<String, Integer> e : entry) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		// collections.value() :  모든 값들을 출력
		System.out.println(map.values());
		// 모든 entry(key, value) 삭제
//		map.clear();
		// getOrDefault(key,value) : 해당 key 값이 있으면 그대로 출력 없으면 value로 반환 단 map에 저장되지는 않는다.

		System.out.println();
		Integer flag = map.getOrDefault("D", 1);
		
		System.out.println(flag);
		System.out.println( map);
		
		System.out.println("putIfAbsent : key값이 있던 없던 get , key가 있으면 value를 반환하고 없으면 key와value를 map에 추가");
			map.putIfAbsent("G", 2);
		System.out.println(map);
//		Object getOrDefault(Object key, Object defaultValue)
	}
	
}
