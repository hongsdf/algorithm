package GraPhrithm;

import java.util.*;
public class ProgammersG1 {
	public static void main(String[] args) {
		SolutionG m = new SolutionG();
		int numbers[] = {1,1,1,1,1};
		m.solution(numbers, 3);
	}
}
class SolutionG {
    int answer = 0;
    public int solution(int[] numbers, int target) { 
  
        combine(numbers,0,0,target);
        
        
        
        
        return answer;
    }
    
    void combine(int[] numbers,int pos, int num ,int target){
        // 백트레킹 : 끝까지 다 확인하고 돌아온다
    	// 원래는 포함o,포함x ==>여기서는 +,-로 구분
    	if(pos >= numbers.length) {
    		if(num == target)  answer++;
    		return;
    	}
    	
    	
    	num += numbers[pos]; // + 더해보기
    	combine(numbers,pos+1,num,target);
    	num -= numbers[pos]; // 복원

    	num += numbers[pos] * -1;
    	
//    	numbers[pos] = numbers[pos] * -1; // 아예 배열자체를 바꾸는 것이 아닌
//    	num += numbers[pos] * -1; // - 로 더해 본다 // numbers[]배열이 바뀌지는 않는다.
    	combine(numbers,pos+1,num,target);
         
        
    }
    
}