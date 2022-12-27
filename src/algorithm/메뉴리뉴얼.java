package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 메뉴리뉴얼 {
	public static void main(String[] args) {
		SolutionC1 m = new SolutionC1();
		//String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		//String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] orders = {"XYZ", "XWY", "WXA"};
		//int[] course = {2,3,4};
		//int[] course = {2,3,5};
		int[] course = {2,3,4};
		String[] answer = m.solution(orders, course);
		Arrays.sort(answer);
		for(int i = 0; i< answer.length; i++) {
			if(i == answer.length-1) { 
				System.out.printf("%s",answer[i] );
			} else {
				System.out.printf("%s",answer[i]+"," );
			}
		}
	}
}

class SolutionC1 {
    public Map<String,Integer> map = new HashMap<>();
    public List<String> list = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        // 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성
        
        
        // 조건 :  코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
        // 조건 :  최소 2명 이상의 메뉴조합에 대해서만 후보에 참여
        
        // 구현
        // 완전탐색으로 조합을 만든다 2~N개
        for(int i = 0; i <orders.length; i++){
            // orders[i] : 주문 리스트
            int size = orders[i].length();
            // 정렬
            
            boolean visit[] = new boolean[size];
            // 조합
            for(int j = 2; j <= size; j++){
                // 현재 깊이,시작점,찾아야하는 뿌리 깊이, 해당 배열, 임시저장공간
            	String temp = "";
                dfs(0,0,j,orders[i],temp,visit);
            }
        }
        
        // map이 완성 되면 결과를 찾아야한다.
        
        
        // 1 map 정렬이 필요하다.
        
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(map.entrySet());
      //  entryList.sort(Map.Entry.comparingByValue()); // value로 정렬한다.
        // 마지막 원소부터 순환
        
        for(int j = 0; j<course.length; j++) {
        	int max = -1;
        	for(int i = entryList.size()-1; i>=0; i--) {
        		Entry<String, Integer> entry = entryList.get(i);
        		String key = entry.getKey();
        		if(key.length() == course[j]) {
//        			int max = entry.getValue(); // 최대값지정
        			if(max < entry.getValue()) {
        				max = entry.getValue();
        				
        			}
        			
        		}	
        	}

        	Iterator<String> set = map.keySet().iterator();
        	while(set.hasNext()) {
        		String key = set.next();
        		if(key.length() == course[j] && map.get(key) == max && map.get(key) != 1) {
        			list.add(key);
        		}
        		
        		
        		
        	}
        }
        
//        // menu 크기가 course 안에 있으면 리턴
//        for(int i = 0; i<course.length; i++){
//            Iterator<String> menu =  map.keySet().iterator();
//            int max = -1;// 같은 크기 메뉴라도 최고주문한 메뉴체크하기 위한 최대값
//            while(menu.hasNext()) {
//            	String menuList = menu.next();
//            	if(menuList.length() == course[i] && map.get(menuList) >= max){
//            		if(max < map.get(menuList) ) {
//            			max = map.get(menuList);
//            		}
//            		list.add(menuList);
//            	}
//            }
//            
//        }
 
        String[] answer = new String[list.size()];
        for(int i = 0; i< answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public void dfs(int depth,int start,int M,String order,String temp,boolean visit[]){
        // M의 뿌리 까지 탐색하기
        if(depth == M){
        	char c[] = temp.toCharArray();
        	Arrays.sort(c);
        	temp = String.valueOf(c);
        	map.put(temp, map.getOrDefault(temp, 0)+1);
            return;
        }
        // 탐색
        for(int i = start; i<order.length(); i++){
            if(!visit[i]){
                visit[i] = true; // 사용
                temp += String.valueOf(order.charAt(i)); // 메뉴 추가
                dfs(depth+1,i,M,order,temp,visit);
                visit[i] = false;
                temp = temp.substring(0,temp.length()-1);
            }
        }
    }
}