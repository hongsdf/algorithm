package Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;


public class TreeMap1 {
	public static void main(String[] args) {
		// key와 value의 타입으로는 기본 타입(byte, short, int, float, double, boolean, char)을 사용할 수없고,
//		클래스 및 인터페이스 타입, 제너릭만 사용 가능하다.
		Map<String,Integer> TreeMap2 = new TreeMap<String,Integer>();
		TreeMap<String,Integer> TreeMap = new TreeMap<String,Integer>();
		
		Map<String,Integer> tm = new HashMap<>();
		// TreeMap의 모든 값을 가져와 tm1을 생성 (<key, value Generic 타입은 서로 같아야한다>)
		Map<String,Integer> tm1 = new HashMap<>(TreeMap);
		TreeMap<Integer,String> tm2 = new TreeMap<Integer,String>(){{
			put(1,"a");
			put(5,"c");
			put(2,"b");
		}};
		
		System.out.println("tm2 : "+tm2);
		// TreeMap 추가
		TreeMap.put("사과",1);
		TreeMap.put("수박",30);
		TreeMap.put("돼지고기",260);
		
		System.out.println(TreeMap) ;
		
		// TreeMap 제거
//		TreeMap.remove("사과");
//		System.out.println(TreeMap) ;
		
		
		Integer n = TreeMap.get("사과");
		System.out.println(n);
		System.out.println(TreeMap.firstEntry());
		System.out.println(TreeMap.lastKey());
		System.out.println(TreeMap.firstKey());
		
		Set<Entry<String,Integer>> set = TreeMap.entrySet() ;
		
		for(Entry<String, Integer> e:set) {
			System.out.println(e.getKey()+" : "+ e.getValue());
		}
		System.out.println();
		// Iterator 반복자 : entry전체를 하나로 가져오기
		Iterator<Entry<String,Integer>> ent = TreeMap.entrySet().iterator();
		while(ent.hasNext()) { 
			System.out.println(ent.next());
		}
		System.out.println("ceilingEntry  :  전달된 키와 같으면 출력  없으면-> 전달된 키보다 큰 키값들중에서 가장 작은 키의 entry반환 ");
		Entry<String,Integer> en = TreeMap.ceilingEntry("포");
		
			System.out.println(en);
		System.out.println("ceilingKey : 전달된 키값들중 큰 키들에서 가장작은 키를 반환");
		String s = TreeMap.ceilingKey("수");
		System.out.println(s);
		
		boolean flag = TreeMap.containsKey("수");
		System.out.println(flag);
		
		
		boolean flag2 = TreeMap.containsValue(30);
		System.out.println(flag2);
		
		System.out.println("replace  : key와 값을 대체");
		TreeMap.replace("수박", 100);
		System.out.println(TreeMap);
		
		
		
		
		// treemap 정렬하기위한 생성 
		NavigableMap<String, Integer > navi = new TreeMap<>();
		navi.put("A", 1);
		navi.put("b", 3);
		navi.put("B", 2);
		navi.put("C", 5);
		
		System.out.println(navi);
		System.out.println(navi.descendingKeySet());
		System.out.println();
		// SortedMap<K,V> : 해당 MAP에서 fromKEY부터 TOkey까지 반환함 단, toKEY는 포함 x
		 TreeMap<Integer, String> tm11 = new TreeMap<Integer, String>();
		 SortedMap<Integer, String> sm = new TreeMap<Integer, String>(); // 부분 map생성
	      tm11.put(18, "violet");
	      tm11.put(12, "red");
	      tm11.put(14, "violet");
	      tm11.put(16, "green");
	      tm11.put(20, "blue");
	      
	      System.out.println(tm11);
	      
	      System.out.println("Gett a portion of TreeMap: ");
	      sm = tm11.subMap(12, 18); // 부분 map을 가져오는 방법
	      System.out.println("Sub map values are: " + sm);
		
	      System.out.println("====");
	      
	      TreeMap<Integer, String> t1 = new TreeMap<>();
	      t1.put(1, "에코");
	      t1.put(3, "트레이서");
	      t1.put(5, "겐지");
	      t1.put(7, "둠");
	      System.out.println(t1);
	      SortedMap<Integer, String> st1 = new TreeMap<>();
	      st1 = t1.subMap(1, 5); // key값 조정
	      System.out.println(st1);
	}
	
	

}
