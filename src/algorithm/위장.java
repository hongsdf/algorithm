package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class 위장 {
	public static void main(String[] args) {
		Solution2 m = new Solution2();
		String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"},
				{"crow_mask", "face"},{"smoky_makeup", "face"},{"blue_sunglasses", "face"}};
		int ans = m.solution(clothes);
		System.out.println(ans);	
		
		
		
	}
}


class Solution2 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // [ 1개 이상 30개 이하, 의상의 종류]로 이루어져 있습니다.
        // 문자열한줄씩 가져와서 map안에 대입
        
        // map<의상의 종류,Integer> 구성
        for(String[] cloth : clothes){
            String B = cloth[1];
            map.put(B,map.getOrDefault(B,0)+1); 
        }

     // 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext())
            answer *= it.next().intValue() + 1; // 아무것도 입지 않는 케이스 +1

        return answer - 1; // 아무종류의것도 입지 않은케이스 -1
        
        
    }
}