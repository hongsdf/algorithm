package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 최소직사각형2 {
	public static void main(String[] args) {
		SolutionA2 m = new SolutionA2();
		int sizes[][] = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		int ans = m.solution(sizes);
		System.out.println(ans);

	}
}
class SolutionA2 {
	int w; 
	int h;
    public int solution(int[][] sizes) {
        int answer = 0;
       
       /**
        *  [15,8] 에서 [14,9]랑 비교한다.
        *  15 vs 14 -- o
        *  8 vs 9 -- x
        *  
        *  결론 뒤집어 볼 필요가 없다.
        *  
        *  
        *  그래서
        *  w랑 [1] 과 [0]번 중 최대값이랑 비교
        *  h랑 [1] 과 [0]번 중 최소값이랑 비교
        *  
        * 
        *  직선으로 이해하면
        *  () := 출발지점 ():= 도착지점
        *  
        *  ---------------------------
        *  8         15
        *  
        *  
        *  ---------------------------  (14,9)
        *  8 (9)     14  15
        *  
        *  
        *  
        *  ---------------------------  (2,16)
        *  8 (9)     14  15 (16)
        * 
        */
        
        w = sizes[0][0]; h = sizes[0][1];
        for(int i = 1; i <sizes.length; i++) {
        	int size[] = sizes[i];
        	int max = Math.max(size[0], size[1]);
        	int min = Math.min(size[0], size[1]); // 뒤집기
        	
        	w = Math.max(max, w);
        	h = Math.max(min, h);
        }
        
        
      
        
        return w * h;
    }
    
    public void check(int [] arr){
        // 현재 범위에 들어가냐
        if(arr[0] <= w && arr[1] <= h){
            return;
        }
         // 뒤집어서 체크
        if(arr[1] <= w && arr[0] <= h){	
        	return ;
        }
        // 
        if(arr[1] >= w && arr[0] >= h) {
        	w = arr[1];
        	h = arr[0];	
        	return;
        }
        // 들어x
        
        else {
        	if(w >= arr[1]) {
        		if(h < arr[0]) {
        			h = arr[0];
        		}
        	}else {
        		w = Math.max(Math.min(arr[1], arr[0]),w);
        	}
        
        }
        
    }
}