package algorithm;
import java.util.*;

public class 주식가격 {
	public static void main(String[] args) {
		SolutioA2 m = new SolutioA2();
		int prices[] = {2,3,6,1,7};
		int[] result = m.solution(prices);
		for(int num : result) {
			System.out.printf("%d ",num);
		}
	}
}

class SolutioA2 {
    public List<Integer> list = new ArrayList<>();
    public int k = 0;
    public int[] answer ;
    public int[] solution(int[] prices) {
    	/* 
    	 * 해당 문제는 전봇대 문제랑 연관이 있다.
    	 * 
    	 * */ 
    	Queue<Integer> q = new LinkedList<>();
    	
    	
    	
    	Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
        	// stack을 사용하여 역방향 조회
        	// 1     2    3    2    3
        	//  <---   
        	while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // i번째 값이 <  제일 위의 값 작으면 
        		answer[stack.peek()] = i - stack.peek(); // 인덱스 거리 차이
        		stack.pop();
        	}
        	// 스택이 비어있거나, 하나의 인덱스가 끝나면
        	stack.push(i);
        }
        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        
      
       
        
        answer = new int[prices.length];
      
     
      
      
        return answer;
    }
    
//    public void solve(LinkedList<Integer> q){
//        // 목적 : curr보다 작은원소를 발견하는것
//        int curr = q.poll();
//        for(int i = 0; i<q.size(); i++){
//        	answer[k]++;
//            if(curr > q.get(i)) // 작은 원소를 발견
//                break;
//        }
//        k++;
//        if(2 > q.size()) return;
//        solve(q);
////        list.add(cnt); // 결과 배열 삽입
//        // base-case : q의 끝까지 살펴보거나 작은것을 발견하면 종료
//        
//    }
}



