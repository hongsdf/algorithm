package Programmers;
import java.util.*;

public class 최소직사각형 {
	public static void main(String[] args) {
		Solution1B m = new Solution1B();
		// int sizes[][] = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		// int sizes[][] = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
//		 int sizes[][] = {{ 10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		// int sizes[][] = {{2,27}, {3,26}, {1,24}, {9,18}};
		 int sizes[][] = {{8,17}, {5,13}, {9,12}, {27,3}}; 
		int answer = m.solution(sizes);
		
		System.out.println(answer);
	}
}

class Solution1B {
	int w; 
	int h;
    public int solution(int[][] sizes) {
        int answer = 0;
       
        Arrays.sort(sizes,new Comparator<int[]>() {
        	
        	public int compare(int o1[], int o2[]) {
        		if(o1[1] == o2[1]) return o2[0] - o1[0];
        		else return o2[1] - o1[1];
        	}
        });
        
        w = sizes[0][0]; h = sizes[0][1];
        for(int i = 1; i <sizes.length; i++){
            check(sizes[i]); // 포함되는가 체크
            
            
            
        }
        
        
        // 모든 경우를 다 살펴봐야됨
        // 틀안에 들어 올수 있게 원본 -> 뒤집어 보기
        
        /*
        [[10, 7], -> 7,10
         [12, 3], -> 3,12
         [8, 15], : 120
         [14, 7], : 98 -> 7,14
         [5, 15]]
        
        
        */
        //70
        // 
        
         /*
        [[10, 7], -> 7,10       [8, 15]
         [12, 3], -> 3,12       [5, 15]    
         [8, 15], : 120         [14, 7] => [7,14]
         [14, 7], : 98 -> 7,14  [10, 7] =>
         [5, 15]]               [12, 3]
        
        
        [[14, 4],    [6, 16]             [7,19]
         [19, 6],    [7, 11] -> [11, 7]
         [6, 16],    [18, 7] -> [7, 18]
         [18, 7],    [19, 6] -> [6,19]
         [7, 11]]    [14, 4] -> [4,14]
        
        
        */
        
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