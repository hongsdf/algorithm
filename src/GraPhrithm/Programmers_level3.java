package GraPhrithm;
import java.util.*;


public class Programmers_level3 {
	
	
	public static void main(String[] args) {
		Solution3_1_3 m = new Solution3_1_3();
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog" }; 
		m.solution("hit", "cog", words);
	}
}
class Solution3_1_3 {
	int answer = 51; // 문제에서 words의 길이는 50개라고 한다. 50개를 모두 거쳐 변환할수 있다고 하면 초기값 설정
	boolean visit[];
    public int solution(String begin, String target, String[] words) {
    	// 백트레킹을 사용이유? 모든 경우를 탐색이 가능하다 (각 위치의 뒤로 순환하며 레밸 별로 조합이 가능)
//    	 => O O O O
//	      	=> O O O X
//	    		  => O O X O
//	    		  => O O X X
//	    		  		 	=> O X O O
//	    		  		 	=> O X O X
//	    		  		 	=> O X X O
//	    		  		 	=> O X X X
//	    		  		 	
//    							=> X O O O
//    							=> X O O X
//    							=> X O X O
//    							=> X X O O 
//    							=> X X O X
//    							=> X X X O
//    							=> X X X X
    	// hit -> hot -> dot -> dog -> cog
//    	              -> lot -> log -> cog
    	
    	// hit -> hot    -> dot  		-> dog
    	// 							 			->	cog
    	//                    		    -> log 
    	//                                    
    	//                           			-> cog
    	//                 	dog
    	//               	cog
    	//                 :    
    	
    	//     -> dot
   	    //     -> dog
    	//     -> cog
    	//         :
    	visit = new boolean[words.length]; // 각 문자를 뒤집기 위한 체크
    	backTrake(begin,target,words,0);
    	
    	
    	return answer == 51? 51:answer ;
    }
    // 시작지점이 변경되는 백트레킹방법
	private void backTrake(String begin, String target, String[] words, int cnt) {
		if(begin.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// 순서가 있다(왜냐면 dog,log,dot.. 어디서 부터 시작하는지에 따라 answer가 달라지므로)
	    // 순열이므로 시작위치점들 세팅 
		for(int i = 0; i < words.length; i++) {
			if(!visit[i] && check(begin,words[i])) { // (현재위치, 비교대상) : (check ) 한칸 차이난다고 하면
				visit[i] = true;
				// 시작위치가 변경된다 *이것이 핵심
				backTrake(words[i],target,words,cnt+1);
				visit[i] = false;
			}
		}
		
		
	}

	private boolean check(String key, String begin) {
		int cnt = key.length();
		for(int i = 0; i <key.length(); i++) {
			if(key.charAt(i) == begin.charAt(i)) {
				cnt--;
			}
		}
		
		return cnt == 1? true:false ;
		
	}
}