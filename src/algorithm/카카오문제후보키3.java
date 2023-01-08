package algorithm;
import java.util.*;

public class 카카오문제후보키3 {
	public static void main(String[] args) {
		SolutionC8 m = new SolutionC8();
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
	//	String[][] relation = {{"100","ryan","music","2","a"},{"200","apeach","math","2","b"},{"300","tube","computer","3","c"},{"400","con","computer","4","d"},{"500","muzi","music","3","e"},{"600","apeach","music","2","e"}};
	//	String[][] relation = {{"100","ryan","music","1"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","ryan","music","3"},{"600","muzi","music","2"}};

		int answer = m.solution(relation);
		System.out.println(answer);
	}
}

class SolutionC8 {
    int N;
    int M;
    int answer = 0;
    public int solution(String[][] relation) {
        // 비트 연산 사용 : 부분집합문제에 적합
        // 불을 키다 or 불을 끄다 (해당 속성  or 해당 속성 x)
        N = relation.length;
        M = relation[0].length;
        List<Integer> candidates = new LinkedList<>(); // 비트 연산을 하기 위한 배열 선언
        for(int i = 1; i < (1 << M); i++){
            // M == 4일때 16가지 부분집합의 유일성을 체크
            if(check(relation,i) == true){
                candidates.add(i);
            }
        }
        
        // 유일성
        
        
        // 정렬 (속성의 갯수가 적은 순으로 정렬 부분집합중 1의 갯수가 적은것 : 
        // 1은 해당 속성이 필요하다. 0은 해당 속성이 필요 x)
        Collections.sort(candidates,new Comparator<Integer>(){
        int countBits(Integer n){
            int cnt = 0;
            while(n !=0){
               if((n & 1) != 0){
                  cnt++;
               } 
               n = n >> 1; // 1111 -> 0111 -> 0011 -> 0001 :오른쪽으로 하나씩 밀어낸다.(불을끈다)
            }
            return cnt;
        }
            
            
            public int compare(Integer o1, Integer o2){ 
                int x = countBits(o1);
                int y = countBits(o2);
                if(x > y){
                    return 1;
                }else if(x < y){
                    return -1;
                }else{
                    return 0;
                }
                
            }
        });
        // 최소성
        while(candidates.size() != 0){
            int n = candidates.remove(0); // 첫번째 원소는 무조건 포함
            answer++;
            for(Iterator<Integer> it = candidates.iterator(); it.hasNext(); ){
                // 부분집합을 오름차순으로 정렬하여 해당되는 부분집합을 삭제한다.
                int c = it.next();
                if((n & c) == n){ // n의 포함되는 원소들은 모두 삭제(최소성)을 만족하기 위해
                    it.remove();
                }
              
            }
        }
        
        
        
        return answer;
    }
    
    public boolean check(String[][] relation,int subset){
        // 2가지 튜플을 비교
        // 2중 for문으로 구현
        for(int i = 0; i<N-1; i++){
            for(int j = i+1; j <N; j++){
                // 한행씩 비교(튜플)
                boolean flag = true;
                for(int a = 0; a < M; a++){
                    // 해당 되는 속성만 비교
                    if((subset & 1 << a) == 0) continue; // 해당 속성과 관련이 없는 것
                    if(relation[i][a].equals(relation[j][a]) == false){ // 유일성을 만족
                        // ryan <--> apeach
                        flag = false;
                        break;
                    }
                }
                if(flag) return false;
            }
        }
        return true;
    }
}