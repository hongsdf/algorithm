package algorithm;

import java.util.*;

// 핵심개념
/* 2D : List<Map<String,Integer>> list_map */
// 1D : Map<String,Integer> 먼저 생성
// for(){ list_map.add() <-- Map을 넣어야한다
// for(){ list_map.add(new HashMap<String,Integer>())

/*map.entry활용방법*/
// list_map.get(row).get(sb.toString()) : sb == "AB"라면 ("AB":1) 값을 추출
// list_map.get(row) 는 List의 행
               // .get(sb.toString()) 은 list행안에는 map들로 구성되어있다 ==> 그 map들 중 sb(키 값)
// 확장 반복문
	// list_map.get(row).entrySet() : list의 행의 원소들을 entry로 묶는다
	// for( Map.Entry<String,Integer> entry :list_map.get(row).entrySet() )


// 각 자리를 포함할것인가 ? 아닌가?
//	ABCD가 있으면 각 자리인 A를 포함체크-> B포함체크-> C 포함체크-> D포함 체크( 2^n) 16가지
//	포함한다고 해서 pos이 이동하지 않는 것은 아니다
//	*재귀함수
//	combine(c,pos+1,sb.append(c[pos]))  pos+1 위치이동 과 현재 위치 추가 (독립적)

public class Menu_Kakao__Map_recurive_2 {
	public static void main(String[] args) {
		Solution3 m = new Solution3();
		
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] ans = m.solution(orders,course);
		for(String a :ans) System.out.print(a+" ");
	}
}
class Solution3 {
	
	List<Map<String,Integer>> list_map = new ArrayList<Map<String,Integer>>();
	int[] MaxCnt = new int[11];
	
	/* 
	 * course : 내가 궁금한 횟수
	 */
	
	
    public String[] solution(String[] orders, int[] course) {
        // 2d 설정 : "ABCGF" -> 1,2,3,4 설정 할수 있고
    			 //  "AC" -> 1,2,3,4 설정 가능
    	         // "CDE"  -> 1,2,3,4 설정 가능
//    	["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
//    	[2,3,4]
//    	["AC", "ACDE", "BCFG", "CDE"]
        
    	
    	for(int i=0;i<11; i++) {
    		list_map.add(new HashMap<String,Integer>());
    	}
    	
    	
    	
        
        // 오름차순 정렬
        for(String order:orders) {
        	char c[] = order.toCharArray();
        	Arrays.sort(c);
        	// order 하나 살펴보기 *StringBuilder()에 대해 알아보기 == String
        	comb(c,0,new StringBuilder());
        }
    	List<String> list = new ArrayList<>();
        for(int cours :course) {
        	for(Map.Entry<String,Integer> entry : list_map.get(cours).entrySet() ){
        		if(entry.getValue() >= 2 && entry.getValue() == MaxCnt[cours]) {
        			list.add(entry.getKey());
        		}
        	}
        }
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for(int i =0; i<list.size(); i++) {
        	answer[i] = list.get(i);
   
        }
        return answer;
    }

	private void comb(char[] c, int pos, StringBuilder sb) {
		// 재귀 식으로 구현
		if(pos >= c.length) { // 해당 "ABCD"를 다 살피기
			int size = sb.length(); // 다 살폈을때 길이
			if(size >= 2) { // 2이상이면 
				int cnt = list_map.get(size).getOrDefault(sb.toString(),0) + 1;
				list_map.get(size).put(sb.toString(), cnt);
				MaxCnt[size] = Math.max(MaxCnt[size], cnt);
			}
			return;
		}
		
		
		// pos+1 포지션을 이동 시키고, 일단 지금의 포지션값을 포함시킨다
		comb(c,pos+1,sb.append(c[pos])); // 해석 :  c배열에서 ABC-> B값을 포함시킨다면 -> A( c[pos] )+B = AB
		// 초기화 해주어야함 (복원) AB가 이미 들어 있으므로
		sb.setLength(sb.length()-1); //AB -> A로  배열원소를 자르기 => 길이 축소
		// 일단 포지션을 이동하고 포함 시키지 않는다
		comb(c,pos+1,sb); // 포함 시키지 않는 경우
		
	}
}