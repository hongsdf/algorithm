package BackBasic;

import java.util.*;

class Solution1 {
	public int[] solution(String[] id_list, String[] report, int k) {
		// 결과 배열생성
		int ans[] = new int[id_list.length];
		// 핵심
		// 스위치 관계

		// 신고한 사람은 여러명을 신고 할수 있으나, 중복은 안된다(set)
		HashMap<String, HashSet<String>> reportmap = new HashMap<>();
		// 신고 당한 사람의 횟수를 측정 map<string,Integer >
		HashMap<String, Integer> repotInfoMap = new HashMap<>();
		// 신고한 맵을 세팅
		// 기존에 신고한 내용이 없다면 추가
		for (String s : report) {
			String reportUser = s.split(" ")[0];
			String sUser = s.split(" ")[1];
			boolean flag = false;

			if (reportmap.containsKey(reportUser)) { // 기존에 추가 항목이 있다면
				if (reportmap.get(reportUser).contains(sUser)) {
					// 중복된 신고내역이라면
					flag = true; // 중복입니다.
				}else { // 신규 항목이 추가되는 경우
					reportmap.get(reportUser).add(sUser);
					
				}
			} else { // 기존에 추가 항목이 없는 경우
				reportmap.put(reportUser,new HashSet<String>(){{
					add(sUser);
				}});
					 
				

			}
			if(flag) { // 중복 되었다면 
				continue ;
				
			}else if(repotInfoMap.containsKey(sUser)) {
				repotInfoMap.put(sUser,repotInfoMap.getOrDefault(sUser, 0) + 1 );
			}else {
				repotInfoMap.put(sUser, 1) ;
			}
		}
		// 있다면 추가 생성
		
		// 보고 확인
		// 신고한 사람의 내역을 보며 보고의 cnt을 증가
		for (String user : repotInfoMap.keySet()) {
			int result = repotInfoMap.get(user);
			if(result >= k) {
				for(int i = 0; i < id_list.length; i++) {
					if(reportmap.get(id_list[i]) == null) {
						ans[i] = 0;
					}else if(reportmap.get(id_list[i]).contains(user)) {
						ans[i]++;
					}
				}
			}
		}
		

		return ans;
	}
}

public class pro2 {
	public static void main(String[] args) {
		Solution1 m = new Solution1();
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		int[] result = m.solution(id_list, report, k);
	}
}
