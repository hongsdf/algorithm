package BackBasic;

import java.util.*;

class Solution1 {
	public int[] solution(String[] id_list, String[] report, int k) {
		// ��� �迭����
		int ans[] = new int[id_list.length];
		// �ٽ�
		// ����ġ ����

		// �Ű��� ����� �������� �Ű� �Ҽ� ������, �ߺ��� �ȵȴ�(set)
		HashMap<String, HashSet<String>> reportmap = new HashMap<>();
		// �Ű� ���� ����� Ƚ���� ���� map<string,Integer >
		HashMap<String, Integer> repotInfoMap = new HashMap<>();
		// �Ű��� ���� ����
		// ������ �Ű��� ������ ���ٸ� �߰�
		for (String s : report) {
			String reportUser = s.split(" ")[0];
			String sUser = s.split(" ")[1];
			boolean flag = false;

			if (reportmap.containsKey(reportUser)) { // ������ �߰� �׸��� �ִٸ�
				if (reportmap.get(reportUser).contains(sUser)) {
					// �ߺ��� �Ű����̶��
					flag = true; // �ߺ��Դϴ�.
				}else { // �ű� �׸��� �߰��Ǵ� ���
					reportmap.get(reportUser).add(sUser);
					
				}
			} else { // ������ �߰� �׸��� ���� ���
				reportmap.put(reportUser,new HashSet<String>(){{
					add(sUser);
				}});
					 
				

			}
			if(flag) { // �ߺ� �Ǿ��ٸ� 
				continue ;
				
			}else if(repotInfoMap.containsKey(sUser)) {
				repotInfoMap.put(sUser,repotInfoMap.getOrDefault(sUser, 0) + 1 );
			}else {
				repotInfoMap.put(sUser, 1) ;
			}
		}
		// �ִٸ� �߰� ����
		
		// ���� Ȯ��
		// �Ű��� ����� ������ ���� ������ cnt�� ����
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
