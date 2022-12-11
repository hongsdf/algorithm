package algorithm;

import java.util.*;

public class 두큐합만들기 {
	public static void main(String[] args) {
		SolutionA13 m = new SolutionA13();
		int[] queue1 = {1, 1};
		int[] queue2 = {1, 5};
		int answer = m.solution(queue1, queue2);
		System.out.println(answer);
	}
}


class SolutionA13 {
	public long num1 = 0;
	public long num2 = 0;
	public long avg = 0;
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        
        // 목적 : 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수
        
        // 큐안에 삽입
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        // q1
        for(int a : queue1){
            q1.add(a);
            num1 += a;
        }
        // q2
        for(int b : queue2){
            q2.add(b);
            num2 += b;
        }
        // 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1
        // 두수의 합이 홀수인경우
        if((num1 + num2)%2 == 1) return -1;
        // 정답 
        if(num1 == num2) return 0;
        
        // 두수의 평균
         avg = (num1 + num2)/2;
        // 다음과 같이 2가지 방법
        int answer1 = solve1(q1,q2); // 로직 구현 (교차 방법)
       // int answer2 = solve2(); // 로직 구현 (한곳에 몰아 넣기 방법)
       
        
        return answer = Math.min(answer1,answer);
    }
    public int solve1(Queue<Integer> q1, Queue<Integer> q2){
        int cnt = 0;
        while(num1 != num2){
            if(num1 > num2){
                while(num1 > num2 && q1.size() != 1){
                    int num = q1.poll();
                    q2.add(num);
                    num1 -= num;
                    num2 += num;
                    cnt++;
                }
                if(num1 == num2){
                    return cnt;
                }else if(q1.size() == 1 && num1 > avg){
                    return -1;
                }
            }else{
                while(num2 > num1 && q2.size() != 1){
                    int num = q2.poll();
                    q1.add(num);
                    num2 -= num;
                    num1 += num;
                    cnt++;
                }
                if(num1 == num2){
                    return cnt;
                }else if(q2.size() == 1 && num2 > avg){
                    return -1; // 만들지 못한다.
                }
            }
        }
		return cnt;
    }
    
}