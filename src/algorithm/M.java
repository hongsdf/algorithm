package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class M {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		map.put("ABC", 1);
		map.put("ABC", 2);
		map.put("ABC", 3);
		
		
		List<Map.Entry<String, Integer>> entry = new ArrayList<>(map.entrySet());
		
		
		for(int j = 0; j <=3; j++) {
			int max = -1;
			for(int i = 0; i <entry.size(); i++) {
				Entry<String, Integer> ent = entry.get(i);
				
				if(max < ent.getValue()) {
					max = ent.getValue();
				}
				
			}
			for(int i = 0; i <map.size(); i++) {
				Iterator<String> iter = map.keySet().iterator();
				while(iter.hasNext()) {
					String key = iter.next();
					if(key.length() == j && map.get(key) == max) {
						list.add(key);
					}
				}

			}
			
			
			
			
		}
		for(String str :list) {
			System.out.printf("%s", str);
		}
		
		
		
		
	}
}
