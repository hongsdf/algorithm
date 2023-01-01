package test2;

import java.util.Arrays;
import java.util.Comparator;

public class p3 {
	public static void main(String[] args) {
		SolutionP3 m = new SolutionP3();
		//int arr[][] = {{1,1},{3,2},{4,1},{3,3}};
		//int arr[][] = {{1,4},{2,6},{4,7}};
		int arr[][] = {{1,2},{2,4},{2,2}};
		int answer = m.solution(arr);
		System.out.println(answer);
	}
}
class SolutionP3{
	public boolean visit[];
    public int solution(int [][] arr) {
        // 가능한  많은 팀이 회의 할수있는 경우
        // 각 팀은 시작 시각과 종료시각을 적어 제출
        // 한팀이 회의를 종료하고 나가 다음팀이 회의 를 준비하는 시간은 0으로 가정
        // 회의 시작시간과 끝나는 시간이 같을 수도 있다.
        // 100,000 * 100,000 = 10000000000

        //  1: [1,2]     [1,2]      [1,4]
        //  2: [2,4] - > [2,2]   -> [2,6]
        //  3: [2,2]     [2,4]      [4,7]
    	  int answer = 1;
    	// 사용 용도 체크
    	visit = new boolean[arr.length];
        // 끝점으로 정렬
        Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
        	
        });
        
        int next = arr[0][1]; //출발
        // 구현
        // 처음 한개 팀은 무조건 수용할수있다.
        for(int i = 1; i < arr.length; i++) {
        	if(next <= arr[i][0] ) {
        		answer++;
        		next = arr[i][1];
        	}
        	
        	
        }
        
       


        return answer;
    }
}