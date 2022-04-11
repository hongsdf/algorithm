package GraPhrithm;

import java.util.*;


public class Programmers_level3_2 {
	public static void main(String[] args) {
		Solution3_3_2 m = new Solution3_3_2();
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		m.solution(tickets);
	}
}

class Solution3_3_2 {
	boolean visitied[];
	String[] answer = {};
    public String[] solution(String[][] tickets) {
      
        Arrays.sort(tickets,new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0])) {
					return o1[1].compareTo(o2[1]) ;
				}
				return o1[0].compareTo(o2[0]);
				
			}

			
        	
        });
        
        // 시작점 찾기
//        int idx = 0;
        List<String> list = new ArrayList<>();
        visitied = new boolean[tickets.length];
        list.add("ICN"); // 넣고 시작 시작점이 ICN 고정이므로
        backTrake("ICN",list,tickets,0); // 시작지점, 저장공간, 티켓, cnt(티켓 갯수 == tickets.len)
        
        
        return answer;
    }

	private void backTrake(String start, List<String> list, String[][] tickets, int cnt) {
		if(answer.length > 0) return; // answer가 이미 완성되면 백트레킹을 돌아도 여기는 변경 되지 않는다.
		
		if(cnt == tickets.length) { // 티켓을 사용하면 그때 answer에 담기 list크기 만큼
			answer = new String[list.size()];
			for(int i = 0; i <list.size(); i++) {
				answer[i] = list.get(i);
			}
			
			return; // 끝내면 다시 돌아감
		}
		
		
		
		
		for(int i = 0; i <tickets.length; i++) {
			// 처음 시작점고 같은 행을 찾는다 && 방문하지 않은 티켓
			if(tickets[i][0].equals(start) && !visitied[i]) {
				visitied[i] = true; // 티켓 사용
				list.add(tickets[i][1]); // 도착점 저장하고
				backTrake(tickets[i][1],list,tickets,cnt+1); // 도착점이 시작점이 된다. cnt++
				visitied[i] = false; // 티켓 사용 해지
				list.remove(list.size() -1); // 저장공간 -1
				
				
			}
			
		}
	}
}   