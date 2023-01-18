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
	Map<String,List<Integer>> map = new HashMap<>();
    int answer[];
    public int[] solution(String[] info, String[] query) {
        answer = new int[info.length];
        INFO_INPUT(info);
        for(String key :map.keySet()){
            Collections.sort(map.get(key));
        }
        QUERY_INPUT(query);  
        return answer;
    }
    public void INFO_INPUT(String[] info){
        for(int i = 0; i <info.length; i++){
            String p[] = info[i].split(" ");
            makeSentence(0,"",p); // 재귀함수구현
        }
    }
    
    public void makeSentence(int depth,String str,String p[]){
        if(depth == 4){
            if(!map.containsKey(str)){
                List<Integer> list = new ArrayList<>();
                map.put(str,list);
            }
            map.get(str).add(Integer.valueOf(p[4]));
            return;
        }
        makeSentence(depth+1,str+"-",p);
        makeSentence(depth+1,str+p[depth],p);
        
        
    }
    public void QUERY_INPUT(String[] query) {
        for(int i = 0; i <query.length; i++){
            query[i] = query[i].replaceAll(" and ","");
            String str[]= query[i].split(" ");
            answer[i]=map.containsKey(str[0])? binarySearch(str[0],Integer.parseInt(str[1])) : 0 ;
            
        }
    }
    
    public int binarySearch(String key, int val){
        
        List<Integer> list = map.get(key);
        int start = 0; int end = list.size()-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(list.get(mid) < val){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return list.size() - start;
        
        
    }
}