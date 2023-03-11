package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 양궁대회 {
	public static void main(String[] args) {
		SolutionC1 m = new SolutionC1();
		int n = 5;
		int info[] = {2,1,1,1,0,0,0,0,0,0,0};
		int [] answer = m.solution(n,info);
		for(int a : answer) {
			System.out.print(a +" ");
		}
	}
}
//처음 dp문제라고 생각을 하였다 => 방법이 있을거 같긴하다.
//n개로 최고의 점수를 내는 곳에 화살을 쏘는것이여서 n번째마다 최적의 해를 구하는 것이라고 생각햇다.

// 백트레킹 문제
// 백트레킹이란 모든 경우의수를 구하는 완전탐색문제
// 디버깅 모드에서 {4,1,0,0,0,0....}
//			   {4,0,1,0,0.......}
//			   {4,0,0,1,0.......}


class SolutionC1 {
	int N;
	int ryan[];
	int apeach[];
	int max = -1;
	List<int[]> answer = new ArrayList<>();
    public int[] solution(int n, int[] info) {
       ryan = new int[11];
       N = n;
       apeach = info.clone(); // 값만 복사,해쉬코드는 복사되지 않는다.
       dfs(0,0); // 화살수, 출발지점
       if(answer.isEmpty()) return new int[] {-1};
       Collections.sort(answer,new Comparator<int []>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			for(int i = 10; i >= 0; i--) {
				if(o1[i] != o2[i]) return o2[i] - o1[i];
			}
			return 0;
		}
    	   
       });
     
       
       
       
       
        return answer.get(0);
    }
    public void dfs(int L, int S) { // L := 화살 카운트, S는 출발점
    	if(L == N) { // 과녁을 다 카운트 만큼 다 쐇다면
    		int a = 0; // 어피치
    		int r = 0; // 라이언
    		for(int i = 0; i < 11; i++) {
    			if(apeach[i] == 0 && ryan[i] == 0) continue; // 둘다 0점이면 skip
    			if(apeach[i] < ryan[i]) r += 10- i;
    			else a += 10- i;
    		}
    		if(r > a) { // 라이언이 이긴 경우
    			int diff = r-a;
    			if(diff > max) {
    				max = diff; // 최고 점수 갱신
    				answer.clear();
    				answer.add(ryan.clone());
    			}
    			else if(diff == max) answer.add(ryan.clone());// 점수가 같은것중 아래 점수가 많은 것으로 갱신된다.
    		}
    		
    	}else {
    		for(int i = S; i< 11 ; i++) { // S번째 부터 11번재 앞에서 하나씩 넣어본다.
    			ryan[i]++;
    			dfs(L+1,i);
    			ryan[i]--;
    		}
    	}
    }
}