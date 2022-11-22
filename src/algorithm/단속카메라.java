package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	public static void main(String[] args) {
		Solution4 m = new Solution4();
		int routes[][] = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		int ans = m.solution(routes);
		System.out.println(ans);
	}
}

class Solution4 {
    public int solution(int[][] routes) {
        Arrays.sort(routes,new Comparator<int[] >(){
           public int compare(int[]o1, int[] o2){
               if(o1[0] > o2[0]) return -1; // 오름차순으로 정렬
               return -1;
           } 
        });
        
        
        int answer = 0;
        int maxlength = -1;
        int maxIdx = 0; // 최대 길이 인덱스
        int firstIdx = 0; //초기 최대길이 index;
        
        
        // 10,000대 차량
        // 가장 길이가 긴 크기 넘버를 찾는다 i
        for(int i = 0 ; i < routes.length; i++){
            int start = routes[i][0]; // 시작점
            int end = routes[i][1]; // 도착지점
            int length = end - start + 1;
            if(length > maxlength){
                maxlength = length;
                maxIdx = i;
                firstIdx = i; // 초기 최대 길이 index
            }
        }
        // 총 범위를 찾는다.
        
        
        // maxIdx를 찾으면 비교해야할 대상 [시작점][도착지점]  부호 주의
        // 시작점 왼쪽끝을 찾아본다. 
        for(int i = 0; i < routes.length ; i++){
            if(routes[maxIdx][0] > routes[i][0] ){ // 값이 왼쪽에 있는 값들중
                if(routes[maxIdx][0] < routes[i][1] ){ // 도착지점이 범위내에 있다면
                    continue;
                } else{
                    answer++; // 범위내에 없다면 cnt증가
                    maxIdx = i;     //기준점 변경
                } 
            }
        }
        maxIdx = firstIdx; //다시 maxIdx이 초기 index으로 돌아온다.
        
        // 오른쪽 지점 찾기
        for(int i = 0; i <routes.length; i++){
            if(routes[maxIdx][0] <= routes[i][0]){ //오른쪽지점이 있다면
                if(routes[maxIdx][1] > routes[i][0]){ // 범위안에 존재 한다면 
                    continue;
                }else{
                    answer++;
                    maxIdx = i; 
                }
            }
        }
        
        // 시작지점보다 왼쪽에 있는 값이 있다면  기준 i와 발견된 지점의 도착점이 범위안에 있다면 스팁, 없다면 +1 을 하고 발견된 지점이 기준이 되며 진행한다.
        
        
        // 도착지점 오른쪽을 찾아본다.
        
        return answer;
    }
}