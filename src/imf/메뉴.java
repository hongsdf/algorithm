package imf;
import java.util.*;

public class 메뉴 {
	public static void main(String[] args) {
		Solution1 m = new Solution1();
		//String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		//int[] course = {2, 3, 4};
		int[] course = {2, 3, 4};
		String[] orders =  {"XYZ", "XWY", "WXA"} ; 
		String answer[] = m.solution(orders, course);
		for(String str :answer) {
			System.out.print(str+" ");
		}
	}
}

class Solution1 {
    public Map<String,Integer> map = new LinkedHashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for(String str : orders) {  // map작성 i번째 사람이 완성할수 잇는 모든 조합
            char c[] = str.toCharArray();
            boolean[] visit = new boolean[c.length];
            
            for(int j = 2; j <= c.length; j++)
            	dfs(0,c,0,j,"",visit); // 모든 조합 찾기    	
            
        }
        // map 순환
        for(int num : course){
            Iterator<String> it = map.keySet().iterator();
            int max = 1;
            while(it.hasNext()){
                String key = it.next();
                if(key.length() == num){
                    max = Math.max(max,map.get(key));
                }
                
            }
            Iterator<String> it2 = map.keySet().iterator();
            while(it2.hasNext()){
                String key = it2.next();
                if(key.length() == num && map.get(key) == max){
                   list.add(key);
                }
                
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
        
    }
    public void dfs(int start,char c[], int depth, int M ,String temp,boolean visit[]){
    	if(depth == M){//만들어야하는 조합
           if(temp.length() >= 2){
               map.put(temp,map.getOrDefault(temp,0) + 1);
             }
           return;
          }
        
        
        for(int i = start; i <c.length; i++){
            if(!visit[i]){
                visit[i] = true; // 글자 사용
                temp += String.valueOf(c[i]);
                dfs(i,c,depth+1,M,temp,visit);
                temp = temp.substring(0,temp.length()-1);
                visit[i] = false;
            }
        } 
    }
    
    
}