package algorithm;

import java.util.*;

public class Menu_Kakao__Map_recurive_ {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("È«±æµ¿1", 1);
		map.put("È«±æµ¿2", 2);
		map.put("È«±æµ¿3", 3);
		// default ¼³Á¤
		map.getOrDefault("È«±æµ¿1", 4);
		
		System.out.println(map.get("È«±æµ¿1"));
		
		
		// entry È°¿ë ¹ý
		for( Map.Entry<String,Integer> entry  : map.entrySet()) {
			if( entry.getValue() >= 2) {
				System.out.println(entry.getKey() );
			}
		}
		
	}
}
