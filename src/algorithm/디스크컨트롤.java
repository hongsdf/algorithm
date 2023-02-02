package algorithm;

import java.util.*;
public class 디스크컨트롤 {
	public static void main(String[] args) {
		SolutionK3 m = new SolutionK3();
		// int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		 int[][] jobs = {{0, 3}, {1, 8}, {10, 5}}; // 5
		
		int answer = m.solution(jobs);
		System.out.println(answer);
	}
}
class SolutionK3 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int N = jobs.length; // 처리해야할 프로세스
        int endpoint = 0;
        int index = 0; // jobs의 인덱스 번호
        
        // 요청되는 시점에 대한 정렬
        Arrays.sort(jobs,(a,b)-> (a[0] - b[0]));
        // 우선순위 큐를 생성 (작업의 소요시간이 짧은 순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        // 로직 구현
        
        // 모든 프로세스를 처리하면 종료 
        while(N --> 0){
            
            while(index < jobs.length && jobs[index][0] <= endpoint){
                // 요구되는 시점이 endpoint보다 작은 경우들을 모두 큐에 담는다.
                pq.add(jobs[index]);
                index++;
            }
            
            if(pq.isEmpty()){
                endpoint = jobs[index][0]; // 프로세스 처리가 남았으나, 큐에 없는 경우 index위치 프로세스를 추가한다.
            }else{
            	int [] curr = pq.poll();
            	answer += curr[1] + endpoint - curr[0]; 
            	endpoint += curr[1]; 
               
            }
            
        }
        // 요청되는 끝점보다 작은 값들을 모두 큐에 넣는다.
        
        // 조건 1. 큐의 값이 비어 있다면
            // 처음값이 출발지점이 된다.
        // 조건 2. 큐의 값이 비어 있지 않다면
        // 정렬 기준에 따라 처음 원소를 꺼내 로직을 수행한다.
        
        
        return (int) Math.floor(answer/jobs.length);
    }
}