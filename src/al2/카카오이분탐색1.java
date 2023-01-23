package al2;
import java.util.*;

public class 카카오이분탐색1 {
	public static void main(String[] args) {
		SolutionK30 m = new SolutionK30();
		int n = 6;
		int times[] = {3,3,10};
		long answer = m.solution(n, times);
		System.out.println(answer);
	}
}
class SolutionK30 {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 목적 : 모든 사람의 걸리는 최소 시간 구하기
        // n : 입국심사를 기다리는 사람수 
        // times[] : 심사위원 배열
        
        // long타입 : 1000경 넘어간다.
        //1,000,000,000,000,000,000 (100경)
        
        // 구현
        // 최소시간, 최대 시간
        Arrays.sort(times);
        long start = 0; long end = (long)n * times[times.length-1];
        
        while(start <= end){
            long mid = (start + end)/2;
            long sum = 0;
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i]; // 절반의 시간으로 처리할수있는 갯수
            }
            if(sum < n){ // 아직 처리해야될 인원이 남은 경우
                start = mid + 1;
               
                
            }else{ // 시간이 너무 많이 할당된경우
                end = mid - 1;
                answer = mid;
            }
            
        }
        
        
        return answer;
    }
}