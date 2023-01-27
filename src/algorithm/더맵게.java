package algorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 더맵게 {

}
class SolutionKW {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 매운맛을 만드는 방법
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
        
        // 구현 
        // 들어오는 순서대로 정렬되기 위해 우선순위큐생성
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a - b)); // 오름차순정려
        while(true) {
        	int num1 = pq.peek();
        	if(num1 >= K) {
        		break;
        	}
        	
        	int n1 = pq.poll();
        	int n2 = pq.poll();
        	
        	int n3 = n1 + (n2*2);
        	pq.add(n3);
        	answer++;
        	if(pq.size() == 1) return -1;
        }
            
        // 맨앞 원소 체크
            
        // k이하이면
        // 앞두개 조작
            
      // 맨앞 원소 체크
            
        return answer;
    }
}