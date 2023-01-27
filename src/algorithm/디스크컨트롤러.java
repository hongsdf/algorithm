package algorithm;
import java.util.*; 

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		SolutionK7 m = new SolutionK7();
		// int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int[][] jobs = {{0, 3}, {1, 8}, {10, 5}}; // 5
		
		int answer = m.solution(jobs);
		System.out.println(answer);
	}
}
class Pointw{
    int start;
    int end;
    
    public Pointw(int start, int end ){
        this.start = start;
        this.end = end;
    }
}
class SolutionK7 {
	public int solution(int[][] jobs) {
        int answer = 0;
        int N = jobs.length-1;
        // 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수
        
        // 무조건  1번 원소부터 시작
        // 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
        
        // 구현
        // 우선순위 큐를 생성 Pointw<start,end,distance>
        
        // distance로 정렬 disttance = start + end
        
        PriorityQueue<Pointw> pq = new PriorityQueue<>((a,b) -> (a.end - b.end));
        
        for(int i = 1; i < jobs.length; i++){
            int job[] = jobs[i];
            pq.add(new Pointw(job[0],job[1]));
        }
        
        // 정렬 완료
        // 처음 원소 
        int job[] = jobs[0];
        int start = job[0]; int end = job[1]; 
        answer += end;
        // [[0, 3], [2, 6]] , [1, 9]
        // int[][] jobs = {{0, 3},{10, 5} ,{1, 8}}; // 5
        while(N --> 0){
            Pointw curr = pq.poll();
            int dist = end + curr.end;
            answer += dist - curr.start;
            end = dist;
        }
        
        
        return answer/jobs.length;
    }
}