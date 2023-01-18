package algorithm;

import java.util.*;
public class 신고결과받기 {
	public static void main(String[] args) {
		SolutionK2 m = new SolutionK2();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
	//	String[] id_list = {"con", "ryan"} ;
	//	String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int ans[] = m.solution(id_list, report, k);
		for(int a : ans) {
			System.out.println(a);
		}
	}
}


class SolutionK2 {
    public Map<String,Set<String>> map = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        // 목적 : 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발
        
        // 조건1
        // 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다
        
        // 조건2
        // 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다
        
        
        // 조건3
        // 이용자id와 신고한id는 공백(스페이스)하나로 구분되어 있습니다.
        
        
        // 구현
        int n = id_list.length;
      
        // List<muzi> := {"frodo,apeach,neo"};
        
        // map세팅
        for(String id :id_list){
            Set<String> set = new HashSet<>();
            map.put(id,set);
        }
        
        
        for(String repo : report){
            String[] rep = repo.split(" ");
            String A = rep[0]; // 신고자
            String B = rep[1]; // 신고 당한자
        
            // MAP 생성
            reports(A,B); // 신고 결과 반영
           
            
        }
        
        // muzi : {apech}
        // frodo : {muzi,apeach}
        // neo : {frodo,muzi}
        // apeach  : {}
        
        HashMap<String,Integer> reportMap = new HashMap<>();
        Iterator<String> it = map.keySet().iterator();
        
        while(it.hasNext()){
           String reporters = it.next();
           Set<String> set = map.get(reporters);
           if(set.size() >= k ){
               for(String re :set){
                   reportMap.put(re,reportMap.getOrDefault(re,0) + 1);
               }
              
           }
            
        }
        // 정답
        int[] answer = new int[n];
        for(int i = 0; i <n; i++) {
        	String user = id_list[i];
        	if(!reportMap.containsKey(user)) {
        		answer[i] = 0; 
        	}else {
        		answer[i] = reportMap.get(user);
        	}
        }
        
        
//        Iterator<String> it2 = reportMap.keySet().iterator();
//        int a1 = 0;
//        while(it2.hasNext()){
//           String reporter = it2.next();
//           int val = reportMap.get(reporter);
//            answer[a1++] = val;
//        }
        return answer;
    }
    
    public void reports(String A, String B){
    	Set<String> set = map.get(B);
       // List<String> list2 = new ArrayList<>();
        set.add(A);
       // set.add(list2);
        map.put(B,set); // frodo - neo
    }
}