package algorithm;
import java.util.*;


public class 단어변환 {
	public static void main(String[] args) {
		SolutionB2 m = new SolutionB2();
		String begin = "hit";
		String target = "cos";
		String[] words = {"hot", "dot", "dog", "log", "cog","cos"};
		int answer = m.solution(begin,target,words);
		System.out.println(answer);
	}
}


class SolutionB2 {
    public int answer = Integer.MAX_VALUE;
    public boolean visit[];
    
    public int solution(String begin, String target, String[] words) {
        // 목적 :  begin에서 target으로 변환하는 가장 짧은 변환 과정 
        // 조건1 : 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
        // 조건2: words에 있는 단어로만 변환할 수 있습니다.
        
        // 문제 이해
        // begin이 target으로 변경되야 종료 , 단 words안의 단어로만 변경이 가능
        
        // 구현
        // 재귀함수
        // 단어 변환은 한 단어만 다른것으로 변환이 가능하다(단어길이는 모두 동일)
        // begin에서 한 단어만 다른것을 배열로 담는다.
        visit = new boolean[words.length+1];
        visit[0] = true; // begin 방문표시
        String[] newWords = new String[words.length+1];
        newWords[0] = begin;
        for(int i = 1; i <newWords.length; i++) {
        	newWords[i] = words[i-1];
        }
        
        
        solve(begin,0,target,newWords);
            
           
            
        
        // 배열로 담기것을 재귀함수를 한다.
        
        //이때 이미 배열로 구한 경우에 대해서는 메모이제이션기법으로 저장해둔다.

        return answer== Integer.MAX_VALUE? 0:answer;
    }
    public void solve(String start,int cnt,String target,String[] words){
        
    	// 탈출조건: 전에 탐색햇던 값은 다시 탐색하지 않는다.
    	
    	
        for(int i = 0; i < words.length; i++){ // 50 * 50 * 50
            if(visit[i]) continue;
         
            String str = words[i];
        	
            int count = 0;
            boolean flag = check(start,str);
            
            
            if( flag && !visit[i]) {
            	if(str.equals(target)) {
            		answer = Math.min(answer,cnt+1);
            		return;
            	}
            	visit[i] = true;
            	solve(str,cnt+1,target,words);
            	visit[i] = false;
            }
          
            
            	
            
        }
        
        
    }
	private boolean check(String start, String str) {
		int count = 0;
		for(int j = 0; j <str.length(); j++){
            if(start.charAt(j) == str.charAt(j)) continue;
            else{
            	count++;
            	if(count > 1) return false;
            }
        }
		return true;
		
	}
    
}