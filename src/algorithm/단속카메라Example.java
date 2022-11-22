package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라Example {
	public static void main(String[] args) {
		Solution5 m = new Solution5();
		int routes[][] = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		int ans = m.solution(routes);
		System.out.println(ans);
		// 정렬을 하여 범위안에 있는지 체크하는 방법
		
	}
}


class Solution5 {
    public int solution(int[][] routes) {
        Arrays.sort(routes,new Comparator<int[] >(){
           public int compare(int[]o1, int[] o2){
               if(o1[1] > o2[1]) return 1; // 오름차순으로 정렬
               return -1;
           } 
        });
        
        int answer = 0;
       
        int z = 0;
        int curr = 0;
        while(z < routes.length) {
        	if(z <routes.length ) {
        	  curr = routes[z][1];
        	}
        	z+=1;
        	while(z < routes.length && routes[z][0] <= curr && curr <= routes[z][1]) {
        		z++;
        	}
        	answer++;
        }
        
        
        
        // routes[i][0] <= curr && curr <= routes[i][1]
        // 범위내에 존재하면 다음 인덱스로 접근
        
        // 존재하지 않으면 answer ++; // 카메라가 필요한 시점이다.
        
        
       
        
        return answer;
    }
}