package algorithm;

import java.util.*;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		SolutionA11 m = new SolutionA11();
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		int answer = m.solution(bridge_length,weight,truck_weights);
		System.out.println(answer);
	}
}


class SolutionA11 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 목표 : 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
        // 조건 : 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
        
        // 다리에 올라갈 수 있는 트럭 수 bridge_length
        // 다리가 견딜 수 있는 무게 weight
        // 트럭 별 무게 truck_weights
        
        // 구현
        // 도착 다리
        
        // 건너는 다리 q 생성
        
        // 초당
        // 두가지 작업이 존재
        
//        // truck_weights 지점을 큐에 생성
//        LinkedList<Integer> truck = new LinkedList<>();
//        for(int i = 0; i<truck_weights.length; i++){
//            truck.add(truck_weights[i]);
//        }
        // 중간지점 다리
        LinkedList<Integer> MidBridge = new LinkedList<>();
        
        // 도착지점
        List<Integer> pointBridge = new ArrayList<>();
        
        
        int sum = 0; // 다리를 건너는 트럭에 올라가있는 트럭 무게
        
        for(int  truck : truck_weights) {
        while(true){
            
            // 1. 대기 -> 다리를 건너는 트럭
        	
            if(MidBridge.isEmpty()){
            	sum += truck;
            	answer++; // 초 증가
                MidBridge.add(truck);
            }else {
            	// 2 .다리를 건너는 트럭 -> 다리를 지난 트럭
            	
            	
            	answer++;
                int curr = MidBridge.poll();
                pointBridge.add(curr);
                sum -= curr;
            }
            
           
            
            
            // 종료 조건
            if(pointBridge.size() == truck_weights.length){
                break;
            }
            
        }
        
        }
        
        
        
        return answer + bridge_length;
    }
}