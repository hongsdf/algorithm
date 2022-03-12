package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class ComparatorStringlength implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// 문자열 길이가 같은 경우
		if(o1.length() == o2.length()) { 
			// compareTo : 문자열은 기본적으로 내장 되어있음 o1.compareTo(o2) 하게 되면 사전순으로 정렬이 됨
			// o1 > o2 : 오름 차순
			// o2> o1 : 내림 차순
			return o1.compareTo(o2);
		// 문자열 길이가 다른
		}else {
			// 그러면 길이로 정렬하라
			return o1.length() - o2.length();
		}
		
	}
	
}


public class Back1181 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		String str[] = new String[n];
		// 중복 변수를 없애기 위해 set 사용
		Set<String> set = new HashSet<>();
		for(int i =0; i<n; i++) {
			String s = br.readLine();
			if(!set.contains(s)) {
				set.add(s);
			}
		}
		
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
	
//		for(int i =0; i <n; i++) {
//			str[i] = br.readLine();
//		}
		// 새로운 정렬 기준 생성
//		Arrays.sort(str,new ComparatorStringlength() {
//		
//		
//		});
		// set을 정렬하기 위해선 list로 구현해야한다
		List<String> list = new ArrayList<String>(set);
		// 그래서 list 정렬
		Collections.sort(list, new ComparatorStringlength());
		
//		for(int i =0; i <n; i++) {
//		
//			System.out.println(str[i]);
//		}
		for(String s: list) {
			System.out.println(s);
		}
	}
}
