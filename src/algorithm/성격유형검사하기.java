package algorithm;

import java.util.HashMap;

public class 성격유형검사하기 {
	public static void main(String[] args) {
		SolutionKakao1 m = new SolutionKakao1();
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		 int[] choices = {5, 3, 2, 7, 5};
		String answer = m.solution(survey, choices);
		System.out.println(answer);
	}
}
class SolutionKakao1 {
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 타입 배열을 만들고 시작
        char type[][] = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}}; 
        HashMap<Character,Integer> map = new HashMap<>();  
        // 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형
        // 단 ,, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형
        
        
        // "RT", "TR" 반대 개념 
        
        // 정답 값의 크기  - 4 크기로 고정
        
        // 비동의 , 동의
        
        // 표 초기화 == 16가지 경우를 세팅
        for(char c[] :type) {
        	map.put(c[0], 0);
        	map.put(c[1], 0);
        }
        
//        //  16가지 경우 세팅
//        map.put('A', 0);
//        map.put('N', 0);
//        map.put('J', 0);
//        map.put('M', 0);
//        map.put('C', 0);
//        map.put('F', 0);
//        map.put('R', 0);
//        map.put('T', 0);

        
        
        // 중복을 제거
        int index = 0;
        for(int i = 0; i<survey.length; i++){
        	char bidong = survey[i].charAt(0); // 비동의
        	char dong = survey[i].charAt(1); // 동의
        	// table 좌표 찾기
//            if('R' == survey[i].charAt(0) || 'T' == survey[i].charAt(0)){
//            	index = 1; // 몇번째 표인지
//            }
//            else if('C' == survey[i].charAt(0) || 'F' == survey[i].charAt(0)){
//            	index = 2; // 몇번째 표인지
//            }
//            else if('J' == survey[i].charAt(0) || 'M' == survey[i].charAt(0)){
//            	index = 3; // 몇번째 표인지
//            }
//            else if('A' == survey[i].charAt(0) || 'N' == survey[i].charAt(0)){
//            	index = 4; // 몇번째 표인지
//            }
            
            //  16가지 경우 세팅
//            map.put('A', 0);
//            map.put('N', 0);
//            map.put('J', 0);
//            map.put('M', 0);
//            map.put('C', 0);
//            map.put('F', 0);
//            map.put('R', 0);
//            map.put('T', 0);
 
            // 점수표 삽입 하는 과정
            // 
            int num = choices[i]; // 점수표
            	if(num > 4) { // 동의 영역
            		// 5 => 1
            		// 6 => 2 
            		// 7 => 3
            		map.put(dong,map.getOrDefault(dong, 0) + (num-4));
            		
            	}else if(num < 4) { // 비동의 영역
            		// 1 => 3
            		// 2 => 2
            		// 3 => 1
            		map.put(bidong,map.getOrDefault(bidong, 0) + (4-num));
            	}
            }
        	// 표 완성 
        	// R /T
        	// C /F
	        // M /J
        	// A /N
//        	if(map.get('R') >= map.get('T')) {
//        		answer += String.valueOf("R");
//        	}else {
//        		answer += String.valueOf("T");
//        	}
//        	
//        	if(map.get('C') >= map.get('F')) {
//        		answer += String.valueOf("C");
//        	}else {
//        		answer += String.valueOf("F");
//        	}
//        	
//        	answer += map.get('M') >= map.get('J')? "M":"J"; 
//        	answer += map.get('A') >= map.get('N')? "A":"N"; 
//        	
        	
        	for(char c[] :type ) {
        		answer += map.get(c[0]) >= map.get(c[1])? String.valueOf(c[0]):String.valueOf(c[1]); 
        	}
        	
        return answer;
    }
}