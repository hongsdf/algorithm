package algorithm;
import java.util.*;

public class 여행경로 {
	public static void main(String[] args) {
		SolutionB31 m = new SolutionB31();
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] answer = m.solution(tickets);
		for(String str:answer) {
			System.out.print(str+" ");
		}
	}
}


class SolutionB31 {
    public boolean visit[];
    public List<String> list = new ArrayList<>();
    public String[] answer = {};
    public String[] solution(String[][] tickets) {
        // 목적 : 주어진 항공권을 모두 이용하여 여행경로를 만드는 것
        // tickets의 각 행 [a, b]는 a 공항에서 --> b 공항
        // 조건1 : 주어진 항공권은 모두 사용해야 합니다.
        // 조건2 : 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로 선택
        
        // 구현
        // 정렬을 한다.
       
        //  시작점 --> 도착점 으로 되어있을때 끝점이 결국 중요하다.(끝점으로 부터 다시 출발하기 때문)
//        Arrays.sort(tickets,new Comparator<String[]>()){
//            
//            public int compare(String[] o1,String []o2){
//                if(o1[1].equals(o2[1])){
//                    return o1[0].compareTo(o2[0]);
//                }
//                return o1[1].compareTo(o2[1]);
//            };
//          
//        }
    	Arrays.sort(tickets,new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) {
					return o1[0].compareTo(o2[0]);
				}
				return o1[1].compareTo(o2[1]);
			}
		
    	});
    	
        visit = new boolean[tickets.length]; // 해당 티켓 사용여부 확인
        String start = "ICN";
        list.add(start);
         solve(start,tickets,0);

        return answer;
    }
    public void solve(String start,String[][]tickets,int cnt){
    	// 이미 답을 구했다면  
    	if(answer.length != 0) return;
    	
        // 탈출조건 모든 티켓을 다 사용하면
    	if(cnt == tickets.length) {
    		answer = new String[list.size()];
    		for(int i = 0 ; i <list.size(); i++) {
    			answer[i] = list.get(i);
    		}
    		return;
    	}
         // 출발지 찾기
        for(int i = 0; i <tickets.length; i++ ){
            if(!visit[i]){
                if(tickets[i][0].equals(start)){
                    visit[i] = true; // 티켓 사용
                    String destination=tickets[i][1];
                    list.add(destination);
                    solve(destination,tickets,cnt+1);
                    visit[i] = false;
                    list.remove(list.size()-1); //마지막 원소 삭제
                }
            }
          
        }
    }
    
   
}