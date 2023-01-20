package al2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAKAOBLINDRECRUITMENT순위검색 {
	public static void main(String[] args) {
		SolutionK2 m = new SolutionK2();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int answer[] = m.solution(info, query);
		for(int num :answer) {
			System.out.println(num);
		}
	
	}
}
class SolutionK2 {
	int answer[];
    HashMap<String,List<Integer>> map = new HashMap<>();
	public int[] solution(String[] info, String[] query) {
		answer = new int[query.length];
	
        
        modifyedInfo(info); // info 수정
        for(String key : map.keySet()){
            Collections.sort(map.get(key)); // val 정렬 
        }
        
        modifyedQuery(query); // query수정
        
        
        
        
        
        
        
		
		return answer;
		
	}
    private void modifyedInfo(String[] info){
        for(int i = 0; i<info.length; i++){
           String str[] = info[i].split(" ");
            // info 배열의 원소를 하나씩 저장
            // java backend junior pizza
            // java--- 150
            // -backend-- 150
            // --junior- 150
            // ---pizza 150
            // --juniorpizza 150
            //      :
            // javabackendjuniorpizza 150
            
            // java backend junior chicken 80
            // java--- [150,80]
            // -backend-- [150,80]
            // --junior- [150,80]
            //       :
            // java backend junior chicken 80
            makeSetance(0,"",str); // 재귀함수 구현
            
            
            
        }
    }
    
    private void modifyedQuery(String[] query){
        // 완성된 map에서 query 살피기
        for(int i = 0; i <query.length; i++){
            String replacequery = query[i].replaceAll(" and "," ");
            String str[] = replacequery.split(" ");
            answer[i] = map.containsKey(str[i]) ? binarySearch(str[0],Integer.valueOf(str[4])) : 0;
        }
        
    }
    
    public void makeSetance(int depth,String str,String info[]){
        if(depth == 4){
            if(!map.containsKey(str)){
                List<Integer> list = new ArrayList<>();
                map.put(str,list);
            }
            map.get(str).add(Integer.parseInt(info[4])); // 값을 추가 
            // ex) java--- = [150] -> java--- = [150,80] 80을 추가 작업
                
            return;
        }
        
        // 2가지를 탐색
        makeSetance(depth+1,str+"-",info);
        makeSetance(depth+1,str+info[depth],info);
    }
    
    private int binarySearch(String str,int score){
        List<Integer> list = map.get(str);
        int start = 0; int end = list.size()-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(list.get(mid) < score){
                start = start + 1;
            }else{
                end = end - 1;
            }
        }
        return list.size() - start;
        
    }
}