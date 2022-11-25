package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 주식가격2 {
	public static void main(String[] args) {
		SolutioA3 m = new SolutioA3();
		int prices[] = {1, 2, 3, 2, 3}; // n! 시간복잡도 x 
		int[] result = m.solution(prices);
		for(int num : result) {
			System.out.printf("%d ",num);
		}
	}
}
class SolutioA3 {
    public List<Integer> list = new ArrayList<>();
    
    public int[] solution(int[] prices) {
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < prices.length; i++){
            q.add(prices[i]);
        }
        int cnt = 0; // 갯수
        
        
       
        
        
        
 
        int[] answer = new int[list.size()];
        for(int i = 0; i <list.size();i++) {
        	answer[i] = list.get(i);
        }
        
 
        return answer;
    }
    
    public void solve(int curr,LinkedList<Integer> q,int cnt){
        // 목적 : curr보다 작은원소를 발견하는것
        cnt = 0;
        for(int i = 0; i<q.size(); i++){
            if(curr > q.get(i)){ // 작은 원소를 발견
                cnt = 1;
                break;
            }else{
                cnt++;
            }
        }
        list.add(cnt); // 결과 배열 삽입
        // base-case : q의 끝까지 살펴보거나 작은것을 발견하면 종료
        
    }
}
