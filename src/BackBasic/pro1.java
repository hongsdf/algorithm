package BackBasic;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // �Ű� ��� �ϱ�
        HashMap<String,HashSet<String>> map = new HashMap<>();
        // �Ű� ��� �ޱ�
        HashMap<String,Integer> result = new HashMap<>();
        
       // map �ʱ�ȭ
        for(int i = 0; i < id_list.length; i++) {
        		HashSet<String> id = new HashSet<>(); //�Ű��� id
        		map.put(id_list[i], id);
        		result.put(id_list[i], 0);
    		   
    		   
    	   }
        // �Ű� ���� �ޱ�
        for(String str : report) {
        	String[] str1 = str.split(" ");
        	String key = str1[0];
        	String value = str1[1];
        	map.get(key).add(key) ;
        	
       }
        
        // ���� ���� ��� 
        for(String key : map.keySet()) {
        	HashSet<String> key1 = map.get(key);
        	if(key1.size() >= k) {
        		for(String key2 : key1) {
        			result.put(key2, result.get(key2)+1);
        		}
        
        		// ����
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
    



