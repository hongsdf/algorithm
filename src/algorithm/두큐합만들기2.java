package algorithm;

import java.util.*;
	// 습득한것
	// 두개의 큐를 같게 만들면 한쪽 만 확인하면된다
	
	//	num1 == num2 를 avg로 만들기위해
	//	if(num1 == avg) 와 같을경우는 => 자동으로 num2 == avg가 된다.
	//  즉, 두개의 구조문제에서는 한쪽만 고려하는 방향을 생각해보자
	
	
	// 두개의 포인터 사용
	// p1,p2이 같은 공간안에 움직인다.(공간의 범위는 큐size() * 2)
	


	class SolutionA15 {
	    public long num1 = 0;
	    public long num2 = 0;
	    public long avg = 0;
	    public LinkedList<Long> q1 = new LinkedList<>();
	    public LinkedList<Long> q2 = new LinkedList<>();


	    public int solution(int[] queue1, int[] queue2) {
	        int answer = -2;

	        // 목적 : 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수 만들기
	        // 만들지 못할 경우 -1

	        // 큐 구현 q1, q2
	        for(long a : queue1){
	            num1 += a;
	            q1.add(a);
	        }

	        for(long b : queue2){
	            num2 += b;
	            q2.add(b);
	        }
	        if((num1 + num2)%2 == 1 ) return -1; // 홀수 이면
	        avg = (num1 + num2)/2;
	        int p1 = 0; int p2 = 0; int mid = q1.size() * 2;
	        while(p1 <=  mid && p2 <= mid){
	            if(num1 == avg) return p1 + p2;  // 한쪽이 절반이 되었다면 - 한쪽만 확인하면 반대는 저절로 되었다. 두개 중 하나선택
	            if(num1 < avg){
	                long num = q2.poll();
	                q1.add(num);
	                num1 += num;
	                num2 -= num;
	                p2++; // 작업 횟수
	            }else{
	                long num = q1.poll();
	                q2.add(num);
	                num1 -= num;
	                num2 += num;

	                p1++;

	            }

	        }


	        return -1;
	    }
	}
	
	
	
	
	// 두큐의 평균값을 구한다 avg
	
	// 병합정렬처럼 두큐의 인덱스를 만든다.
	// idx1 - 큐1에서 출발, idx2 - 큐2에서 출발  ~ 배열의 *2크기까지 진행가능
	//진행하다 한쪽의 값 이 avg이랑 같아지면 그때 idx + idx2 을 리턴
	
	// worst-case는 두 큐를 전부 바꾸는 것 => 600,000 * 2 = 12,000,000
	// [교차방법]
	// 한쪽이 avg 넘으면 
	// 반대쪽 진행
	
	
	
	

