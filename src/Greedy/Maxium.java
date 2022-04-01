package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maxium {
	public static void main(String[] args) {
		Result m = new Result();
		List<Integer> list = new ArrayList<Integer>(Arrays.asList());
		List<Integer> ans = m.maximumPerimeterTriangle(list);
		System.out.println(ans.get(0) == -1? -1:ans);
			
	}
} 

class Result {

	// 수정 전
	public static List<Integer> maximumPerimeterTriangle1(List<Integer> sticks) {
		// 1 2 3,4,6,7
		for(int i =0; i<sticks.size()-3; i++) {
			List<Integer> arr = sticks.subList(i, i+3); // 이건 안된다 
			// 이유?
			// 정렬되었다고 해더 1,2,3 순서대로만 살피는 것이 아닌
			// 1,2,4 띄워 넘어 확인 가능 => 1,2,6...
			/// 그래서 다르게 생각하자
			for(int j = 0; j<arr.size(); j++) {
				
			}
		}
		
		
		return sticks;
	}
	
	// 수정 후 
	public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
		// 1 2 3,4,6,7
		// 3중 for문 생각
		// for(1문) : 배열에서
		// for(2문) : (j)하나의 포인터
		// for(3문) : j를 움직니는 작업
		
		int max = 0;
		List<Integer> temp = new ArrayList<>();
		for(int i = 0; i<=sticks.size() -3 ; i++) {
			for(int j = i+1; j<=sticks.size()-2; j++) {
				for(int k = j+1; k <= sticks.size()-1; k++) {
					if(sticks.get(i) <= sticks.get(j) + sticks.get(k)) {
						int result = sticks.get(i) + sticks.get(j) + sticks.get(k) ;
						if(max < result) {
							max = result;
							if(temp.isEmpty()) {
								temp.add(sticks.get(i));
								temp.add(sticks.get(j));
								temp.add(sticks.get(k));
							}else {
								temp.clear();
								temp.add(sticks.get(i));
								temp.add(sticks.get(j));
								temp.add(sticks.get(k));
							}
								
						}
					}
				}
			}
		}
		if(max == 0) return Arrays.asList(-1);
		else return temp;
	}
	
	

}