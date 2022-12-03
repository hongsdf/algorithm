package algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 소수찾기 {
	public static void main(String[] args) {
		SolutionA7 s7 = new SolutionA7();
		String numbers = "011";
		int cnt = s7.solution(numbers);
		System.out.println(cnt);
	}
}
class SolutionA7 {
    int answer = 0;
    public boolean visit[];
    public Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
    
        // 순서가 존재하는 모든 조합을 찾는다.
        
        // 백트레킹
        char c[] = numbers.toCharArray();
        visit = new boolean[numbers.length()];
        // 원소를 하나씩 꺼내 조합을 찾는다.
        String temp = "";
        dfs(c,temp); // 로직구현
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
        	int num = it.next();
        	if(check(num)) answer++;
        }
        
        // 선택 여부 + 순서 여부 
        // 초대 시간 복잡도 7^7 == 823,543
        
        
        // 검증단계
        // check() - 소수인지 아닌지 판별
        // 조합 배열
        
        return answer;
    }
        
    public boolean check(int n){
        if(n <= 1) return false;
    	for(int i = 2; i <= (int) Math.sqrt(n); i++){ 
            if(n%i == 0){
                return false; // 소수가 아니다
            }
        }
        return true; // 소수다
    }
    
    public void dfs(char c[],String temp ){
        // 목적 뿌리 끝까지 탐색
        // 탈출조건 뿌리 끝까지 탐색하면 종료
    	if(c.length == temp.length()) return;
    	
    	
        for(int i = 0; i <c.length; i++){
            if(!visit[i]){
                visit[i] = true;
                temp += c[i]; // 한글자 대입
                // 중복 확인
                if(!set.contains(temp)) {
        			set.add(Integer.parseInt(temp));
        		}
//                boolean flag = check(Integer.parseInt( temp)); //소수인지 아닌지
//                if(flag) answer++;
                dfs(c,temp);
                temp = temp.substring(0,temp.length()-1); // 다시 초기화
                visit[i] = false;
            }
        }
    }
}