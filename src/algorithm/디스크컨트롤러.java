package algorithm;
import java.util.*; 

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		SolutionK7 m = new SolutionK7();
		 int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		// int[][] jobs = {{0, 3}, {1, 8}, {10, 5}}; // 5
		
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
        int index = 0; // job 인덱스
        int endpoint = 0; // 끝점
        int count = 0 ; // 모든 요청에 대한 인덱스
        // 요청시점으로 정렬
        Arrays.sort(jobs,new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {		
				return o1[0]- o2[0];
			}
		
        });
        
        PriorityQueue<Pointw> pq = new PriorityQueue<>(new Comparator<Pointw>(){
            public int compare(Pointw o1, Pointw o2){
                    return o1.end - o2.end;
             
            }
        
        }); // 소요시간이 짧은 순으로 정렬
        
        while(count < jobs.length){
        
          // 요청을 전부 받는다 --> 그중 작업소요시간이 가장 짧고, 요청시점이 되는 시점을 선택한다.        
          while(index < jobs.length && jobs[index][0] <= endpoint){
                pq.add(new Pointw(jobs[index][0],jobs[index][1]));
                index++;
          }
          // 처리할수 있는 모든 지점들이 들어가잇고 pq에 의해 정렬된다.
          // 요청을 받지 못한 상태
          if(pq.isEmpty()){
                endpoint = jobs[index][0];  
              
          }else{
        	  Pointw curr = pq.poll();
            // endpoint = curr.end;
            answer +=  curr.end + endpoint - curr.start; // 전체시간 - 요청시점 == 요구되는 시간
            endpoint += curr.end;
            count++;
            
           
            
          }
          
          
        }
        
        
        
        return (int) Math.floor(answer/jobs.length);
    }
}