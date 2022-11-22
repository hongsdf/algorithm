package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라Example2 {

}

class Solution7 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,new Comparator<int[] >(){
           public int compare(int[]o1, int[] o2){
               if(o1[0] > o2[0]) return 1; //  종료시점 기준으로 오름차순으로 정렬
               return -1;
           } 
        });
        // 종료 시점으로 정렬하는 이유: 하나의 길만 존재한다하여도 카메라 하나는 필요하다 그때 종료
        // 시점에 카메라를 설치하고 다음 카메라의 시작점과 도착지점을 살펴보는 식으로 하자
        int camera = -9999999;
        for(int i = 0; i < routes.length; i++){
            if(camera <  routes[i][0]){ // 처음 길의 출발지점에 하나 카메라를 설치한다.
                
                
                camera = routes[i][1]; // 다음 카메라를 설치할때는 처음 길의 도착지점 된다
                answer++;
            }    
        }
        
       
        return answer;
    }
}