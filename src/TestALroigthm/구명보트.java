package TestALroigthm;
import java.util.*;

public class 구명보트 {
	public static void main(String[] args) {
		Solution1A m = new Solution1A();
		int[] people = {30,30, 50,80,30, 80, 50};
		int limit = 100;
		int answer = m.solution(people, limit);
		System.out.println(answer);
	}
}

class Solution1A {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); 
        Stack<Integer> st = new Stack<>();
        // st.push(people[0]);
        /**
         * 조건을 잘만들어야됨
         * 생각
         * 조건1. 2개가 차면 무조건 출발 시키기 st 모두 다 비우기
         * 조건2-1 2자리가 아니고 st.peek() + i번째 요소가 <= limit이면 담을 수 잇다.
         * 조건2-2  st.peek() + i번째 요소 > limit이면 출발
         * 
         * 정리 출발 조건 : 2자리 이거나 || st.peek() + i >= limit 
         * else 출발을 안시킴
         */
        for(int i = 0; i<people.length; i++){
           if(st.isEmpty()){
               st.push(people[i]);
           }else{
               if(st.size() == 2){
                   st.pop(); st.pop(); answer++;
               } 
               else if(st.peek() + people[i] <= limit){ 
                  st.push(people[i]);
                  continue;
               }else{
                   st.pop();
                   answer++; 
               }
               st.push(people[i]);
            }
        }
        // 목적 : 최소한 구명보트 갯수 구하기
        // 마지막 사람 구하기
        if(!st.isEmpty()){
            answer++;
       }
        return answer;
    }
    
}