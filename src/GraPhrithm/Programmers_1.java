package GraPhrithm;

import java.util.*;

public class Programmers_1 {
	public static void main(String[] args) {
		Solution m = new Solution();
		int [] answers = {1,2,3,4,5};
		m.solution(answers);
	}
}

class Solution {
//     List<List<Integer>> list = new ArrayList<>();
//    
//    List<Integer> student1 = Arrays.asList(1, 2, 3, 4, 5);
//    List<Integer> student2 = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
//    List<Integer> student3 = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

	static int[][] arr = new int[][] { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
	static int max = -1;
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	public int[] solution(int[] answers) {
//		int[] answer = {};
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			// ÇÐ»ý 1
			int size = arr[i].length;

			
			int cnt = 0;
			int j = 0;
			for (int k = 0; k < answers.length;) {
				if(j == size) { 
					j = 0;
				}
				
				
				if(answers[k++] == arr[i][j++]) {
					cnt++;
					
				}
				
			}
			map.put(i, cnt);
			max = Math.max(max, cnt) ;

		}
		int idx = 0;
		for(Map.Entry<Integer,Integer> ent : map.entrySet()) {
			if(ent.getValue() == max) {
				int num = ent.getKey() + 1;
//				answer[idx++] = num;
				ans.add(num);
			}
		}
		
		 
		int[] answer = new int[ans.size()];
		
		for(int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
		}

		return answer;
	}
}