package GraPhrithm;

import java.util.*;

public class Programmer3 {
	public static void main(String[] args) {
		Solution3_1 m = new Solution3_1();
		m.solution(24, 24);
	}
}
class Solution3_1 {
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int min = 0;
        if(brown > yellow ){
            min = yellow;
        }else{
            min = brown;
        }
        
        int sum = brown+yellow;
        // ¼ÒÀÎ¼ö
        Queue<int[]> q = new LinkedList<>();
        
        int Row = 0;
        for(int i = 1; i <= sum; i++){
            if(sum%i ==0){
               Row = sum/i;
                q.add(new int[]{Row,i});
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int num = (curr[0] -2) * (curr[1]  -2); 
            if(min == num){
                answer[0] = curr[0];
                answer[1] = curr[1];
            }
        }
        
        
        
        
        
        
        return answer;
    }
}