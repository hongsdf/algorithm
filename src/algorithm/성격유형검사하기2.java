package algorithm;

import java.util.HashMap;
import java.util.Map;


class table{
	 Map<Integer,int[]> map;
	 int n;
	 public table(int n) {
		 this.map = new HashMap<Integer,int[]>();
		 
		 for(int i = 1; i <=n; i++) {
			 map.put(i, new int[2]);
		 }
	 }
	 
}

public class 성격유형검사하기2{
	public static void main(String[] args) {
		solutionA9 m = new solutionA9();
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		 int[] choices = {5, 3, 2, 7, 5};
		String answer = m.solution(survey, choices);
		System.out.println(answer);
	}
}



class solutionA9 {
	 public String solution(String[] survey, int[] choices) {
	        String answer = "";
	        // 타입 배열을 만들고 시작
	        char type[][] = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
	        Map<Integer,HashMap<Character,Integer>> table = new HashMap<Integer, HashMap<Character,Integer>>();
	        for(int i = 1; i<=4; i++) {
	        	Map<Character,Integer> map = new HashMap<Character,Integer>();
	        	for(int j = 0; j<1; j++) {
	        		map.put(type[i-1][0], 0);
	        		map.put(type[i-1][1], 0);
	        		
	        	}
	        	// 형 변환 (HashMap<Character,Integer>)
	        	table.put(i,(HashMap<Character,Integer>)map);
	        	
	        }
	        
	        // HashMap 삽입
	       
	        for(int i = 0; i <survey.length; i++) {
	        	// index번호 찾기
	        	char bi = survey[i].charAt(0); // 비동의 영역
	        	char dong = survey[i].charAt(1); // 동의 영역
	        	
	        	int index = 0;
	        	if(bi == 'R' || bi == 'T') {
	        		index = 1;
	        	}
	        	else if(bi == 'C' || bi == 'F') {
	        		index = 2;
	        	}
	        	else if(bi == 'J' || bi == 'M') {
	        		index = 3;
	        	}
	        	else if(bi == 'A' || bi == 'N') {
	        		index = 4;
	        	}
	        	HashMap<Character,Integer> map = table.get(index);
	        	int num = choices[i];
	        	// survey를 만들어야함
	        	if(num < 4) {
	        		map.put(bi , map.getOrDefault(bi,0) + (4-num));
	        	}else if(num > 4) {
	        		map.put(dong, map.getOrDefault(dong,0) + (num-4));
	        	}
//	        	map.put(choices[i], null);
	        	table.put(index,map);
	        }
	        
	        // 테이블에서 값 추출
	        // 1.테이블 인덱스를 가져와
//	        	Set<Integer>  index = table.keySet();
//	        	HashMap<Character,Integer> map = table.get(index);
	        	
	        	for(Integer i = 0; i <type.length; i++) {
	        	HashMap<Character,Integer> map = table.get(i+1); // 테이블의 인덱스번호(key값을 가져와)
	        	// 2값을 비교
	        	answer += map.get(type[i][0]) >= map.get(type[i][1])?  String.valueOf(type[i][0]): String.valueOf(type[i][1]);
	        }
	       
	       // answer
	        
	       
	        
	        
	        
	        
	        
	        
	        return answer; 
	 }
}
