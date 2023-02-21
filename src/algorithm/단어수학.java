package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 단어수학 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char alphabet[][] = new char[N][10];
		for(int i = 0; i <N; i+=1) {
			String str = br.readLine();
			char c[] = str.toCharArray();
			for(int j = 0; j < c.length; j++) {
				alphabet[i][10 + j - c.length] = c[j];
			}
		}
		
		// ABCDEFGHIJ
		// 0123456789
//		Comparator<Character> compartor = (s1,s2) -> s2.compareTo(s1);
		Map<Character,Integer> map = new HashMap<>();
		// 로직 구현
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j <N; j++) {
				if(alphabet[j][i] != 0) {
					char c = alphabet[j][i];
					// 열에 가장 많이 등장한 알파벳
					map.put(c,map.getOrDefault(c,0)+(int)Math.pow(10-i,3));
					
					
				}
			}
		}
		// map을 value값으로 정렬
		Map<Character,Integer> result = reverseMapByValue(map);
		Map<Character,Integer> alpha = new HashMap<>();
		int num = 9;
		Iterator<Character> it = result.keySet().iterator();
		while(it.hasNext()) {
			char key = it.next();
			alpha.put(key, num--);
			
		}
		
		// 원소를 다 대입했다면
		
		// 결과 찾기
		int sum = 0;
		for(int i = 0; i<N; i++) {
			String temp = "";
			for(int j = 0; j<10; j++) {
				char c = alphabet[i][j];
				if(alpha.containsKey(c)) {
					temp += String.valueOf(alpha.get(c));
				}
			}
			sum += Integer.parseInt(temp);
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static Map<Character, Integer> reverseMapByValue(Map<Character, Integer> map) {
		List<Map.Entry<Character, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
	}
}
