package algorithm;

import java.util.HashMap;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		Solution1 m = new Solution1();
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		m.solution(participant, completion);
	}
}

class Solution1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        // 참가 명단에서 모든 선수들을 1로 체크한다.(출발준비상태를 의미) *동명이인인경우 +2
        for(int i = 0; i < participant.length; i++){
            String worker = participant[i];
            map.put(worker, map.getOrDefault(worker, 0)+1);
        }
        // 완주한 명단에서 참가명단과 비교하여 완주하면 0으로 바꾼다
        for(String completionWorker: completion){
            map.put(completionWorker,map.get(completionWorker) - 1);
        }
        //다시 참가자명단알 살펴보고 0이 아닌 선수가 있을시 반환한다
        for(String worker : map.keySet()){
            if(map.get(worker) != 0){
                return worker;
            }
        }
        
        
        return participant[participant.length-1] ; // 마지막 선수 
    }
}