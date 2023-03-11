package Programmers;
import java.util.*;

public class 양궁대회2 {
	public static void main(String[] args) {
		Solution m = new Solution();
		int n = 5;
		int info[] = {2,1,1,1,0,0,0,0,0,0,0};
		int [] answer = m.solution(n,info);
		for(int a : answer) {
			System.out.print(a +" ");
		}
	}
}

class Solution {
    int ryan[];
    int apeach[];
    
    List<int[]> answer = new ArrayList<>();
    int max = -1;
    
    public int[] solution(int n, int[] info) {
        ryan = new int[11]; // 라이언 배열
        apeach = info.clone(); // info배열의 요소만 복사
        dfs(0,0,n); // 화살 수, 과녁 위치
        if(answer.isEmpty()) return new int[]{-1}; // 값이 없다면 -1 리턴
        Collections.sort(answer,new Comparator<int[]>(){
            
            public int compare(int o1[], int o2[]){
                for(int i = 10; i >= 0; i--){
                    if(o1[i] != o2[i]) return o2[i] - o1[i];
                }
                return 0;
            }
        });
        // 백트레킹 := 모든 원소를 탐색할것이다.
        
        
        return answer.get(0);
    }

    public void dfs(int count,int point, int n){ // 과녁을 쏘는 메서드:=> 한 과녁에 모든 화살을 쏜다.
        if(count == n){ // 과녁을 다 쐈다면
            int ryanPoint = 0; // 라이언
            int apeachPoint = 0; // 어피치
            for(int i = 0; i <11; i++){
                if(apeach[i] == 0 && ryan[i] == 0) continue; // 계산 필요가 없다.
                if(apeach[i] < ryan[i]) ryanPoint += 10 - i; // 점수 획득
                else apeachPoint += 10 - i;
            }
            
            // 정답은 ryan이 이기는 경우만 구한다.
            if(ryanPoint > apeachPoint){
                int diff = ryanPoint - apeachPoint; // 두 점수 차이
                if(diff > max) {
                    max = diff;
                    answer.clear(); // 정답값 갱신을 위해 없애기
                    answer.add(ryan.clone()); // 라이언 배열값 복사
                }
                else if(diff == max) answer.add(ryan.clone()); // 정답값 여러개 넣기
                
            }
        }else{
            for(int i = point; i <11; i++){
                ryan[i]++; 
                dfs(count+1,i,n);
                ryan[i]--;
            }
        }
        
        
    }
    
}