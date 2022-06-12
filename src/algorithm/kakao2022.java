package algorithm;

import java.util.*;

// 역 관계를 표현 기법 

// (중복 제외) 

// 신고한 사람 목록
// 신고 당한 목록

class Kakao1 {
    public int[] solution(String[] id_list, String[] report, int k) {  
        // 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
        // 신고한 목록 := report
        
        // 신고 당한 목록생성 := a <- b,c 했을때 b,c에는 메일이 간다.
        
        // 중복된 신고내역은 제외
        
        // 한사람이 여러사람을 신고 할수 있지만, 동일한 사람은 1번 취급
        // HashSet<String>() := 동일한 사람을 신고 할수 없다
        HashMap<String,HashSet<String>> reportMap = new HashMap<>();
        
        // 신고 당한 목록
        HashMap<String,HashSet<String>> ret = new HashMap<>() ;
        
        // 신고 목록 (report) 받기
        for(String s : report){
           String[] str  = s.split(" ");
            if(!reportMap.containsKey(str[0])){
                reportMap.put(str[0],new HashSet<>());
            }
            reportMap.get(str[0]).add(str[1]);
            
            //신고 당한 목록 역 관계 표현
            
            if(!ret.containsKey(str[1])){
                ret.put(str[1],new HashSet<>());
            }
            ret.get(str[1]).add(str[0]);
        }
        
        int answer[] = new int[id_list.length];
        
        for(int i = 0; i <id_list.length; i+=1){
            String user = id_list[i];
            if(!reportMap.containsKey(user)) continue; // 신고한 내용이 없다면
            
            for(String p1 : reportMap.get(user)){
                if(ret.get(p1).size() >= k){
                    answer[i]+=1;
                }
            }
        }
        
        
        
        return answer;
    }
}