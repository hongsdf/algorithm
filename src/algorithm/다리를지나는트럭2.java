package algorithm;

import java.util.LinkedList;

public class 다리를지나는트럭2 {
	public static void main(String[] args) {
		SolutionA12 m = new SolutionA12();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		int answer = m.solution(bridge_length,weight,truck_weights);
		System.out.println(answer);
	}
}
class SolutionA12 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
    	// 다리를 앞에서 부터 트럭을 꺼내므로 큐 사용
    	LinkedList<Integer> q = new LinkedList<>();
    	int sum = 0; // 다리에 올라와있는 무게
    	
//    	// truck_weights 지점을 큐에 생성
//        LinkedList<Integer> truck = new LinkedList<>();
//        for(int i = 0; i<truck_weights.length; i++){
//            truck.add(truck_weights[i]);
//        }
    	
    	
    	for(int truck : truck_weights) {
    		while(true) {
    		// 1. 다리에 트럭이 없는 경우
    		if(q.isEmpty()) {
  
    			q.add(truck);
    			sum += truck;
    			answer++;
    			break;
    		}
    		else if(q.size() == bridge_length) {
				// 올라온 다리 --> 목적지
				sum -= q.poll(); // 목적지 전달
			}else {
    			// 2. 다리에 트럭이 있는 경우
	    			// 2-1. 모든 트럭이 다리에 올라온경우
    				if(sum + truck > weight) {
    					// 올라온 다리 --> 목적지
    					q.add(0); // 의미 : 한칸을 사용한다
    					// 트럭은 순차적으로 처리하므로 7다음 4를 처리해야한다 이 과정에서 _ _ 중 2칸을 7이 모두 차지하므로 나머지한칸에 대해 공백으로 처리하기 위해 0으로 함
    					answer++;
    				}else {
    					
    					q.add(truck);
    					sum += truck;
    					answer++;
    					break;
    				}
	    			// 2-2. 올라올 트럭이 무게 초과하는 경우
	    			// 2-3. 올라올 트럭이 무게 허용 범위
    			
    			}
    	
    		
    		}
    	
    	
    	}
    	// 마지막 원소는 bridge_length만큼 이동
		return answer + bridge_length;
    	
    	}
    
    }

