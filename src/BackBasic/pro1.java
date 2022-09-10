package BackBasic;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 신고 결과 하기
        HashMap<String,HashSet<String>> map = new HashMap<>();
        // 신고 결과 받기
        HashMap<String,Integer> result = new HashMap<>();
        
       // map 초기화
        for(int i = 0; i < id_list.length; i++) {
        		HashSet<String> id = new HashSet<>(); //신고한 id
        		map.put(id_list[i], id);
        		result.put(id_list[i], 0);
    		   
    		   
    	   }
        // 신고 내역 받기
        for(String str : report) {
        	String[] str1 = str.split(" ");
        	String key = str1[0];
        	String value = str1[1];
        	map.get(key).add(key) ;
        	
       }
        
        // 정지 메일 결과 
        for(String key : map.keySet()) {
        	HashSet<String> key1 = map.get(key);
        	if(key1.size() >= k) {
        		for(String key2 : key1) {
        			result.put(key2, result.get(key2)+1);
        		}
        
        		// 정답
        		for(int i = 0; i <id_list.length ; i++) {
        			answer[i] = result.get(id_list[i]);
        			System.out.println(answer[i]);
        		}
        
        
        return answer;
        }
}
        
public class pro1 {
	public static void main(String[] args) {
		Solution m = new Solution();
		String id_list[] = {"muzi", "frodo", "apeach", "neo"};
		String report[] = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		int[] result = m.solution(id_list, report, k);
		
		for(int a :result) {
			System.out.println(a);
		}
	}
}
    



