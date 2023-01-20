package al2;

import java.util.*;

public class 카카오이분탐색 {
	public static void main(String[] args) {
		SolutionsK2 m = new SolutionsK2();
		int n = 6;
		int times[] = {7, 10};
		// int times[] = {3, 3, 4}; // 8
		// int times[] ={5,5,2,1}; // 4
		//  1    A3 B3 C4
		//  2    A3 B3 C4
		//  3    A3 B3 C4
		//  4    D3 E3 C4
		//  5    D3 E3 F4
		//  6    D3 E3 F4
		//  7    0  0  F4
		//  8    0  0  F4
		
		// 3 3 4     - 1
		// 6           -2
		
		long answer = m.solution(n, times);
		System.out.println(answer);
	}
}
class SolutionsK2 {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 목적 : 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
        // 심사관 : 100,000
        // 시간복잡도 O(N) || O(NlogN)
        Arrays.sort(times); // 심사관 정렬
        // 새로운 공간 생성
        int score[] = new int[times.length];
        
        if(score[0] == 0){
            score[0] = times[0];        
        }
        // 7,0  -1
        // 7,10 -2
        // 14,10 -3
        // 14,20 - 4
        // 21,20 - 5
        // 28,20 - 6
        
       
        for(int i = 0; i <n-1; ){ // n 명 심사
            for(int j = 0; j < times.length-1; j++){ // 심사
                // 심사관을 찾아
//            	Arrays.sort(score, Collections.reverseOrder());;
                if(times[j]+score[j] > times[j+1] + score[j+1]){
                    score[j+1] += times[j+1];
                    i++;
                }else if(times[j]+score[j] == times[j+1] + score[j+1]) {
                	
                	continue;
                }
                else{
                    score[j] += times[j];
                    i++; 
                    break; // 다시 앞에 부터 확인하기 위해
                }
               
                
                // 1 2 5 5
                // A1 B2 0 0  - 1
                // C1 B2 0 0  - 2
                // D1 E2 0 0  - 3
                // F1 E2 0 0  - 4
               
                
                
            }
        }
        Arrays.sort(score);
        answer = score[score.length-1];
        
        
        
        
        
        return answer;
    }

	
}