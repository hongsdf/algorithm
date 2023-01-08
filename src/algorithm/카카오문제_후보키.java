package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// 내가 구현한 로직 32.0/100.0
// 1.먼저 하나의 칼럼이 유일성을 만족하는지 체크 visit배열 설정
// 2.visit[i] == true이면 하나의 속성으로 유일성을 만족하지 못하므로 다른 속성과 합쳐야한다.
// 3. 2개~ N개까지 합쳐야 할수 있으므로 재귀함수를 구현해야된다고 생각함.


public class 카카오문제_후보키 {
	public static void main(String[] args) {
		SolutionC7 m = new SolutionC7();
//		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
//		String[][] relation = {{"100","ryan","music","2","a"},{"200","apeach","math","2","b"},{"300","tube","computer","3","c"},{"400","con","computer","4","d"},{"500","muzi","music","3","e"},{"600","apeach","music","2","e"}};
		String[][] relation = {{"100","ryan","music","1"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","ryan","music","3"},{"600","muzi","music","2"}};

		m.solution(relation);
	}
}
class SolutionC7 {
    public int N;
    public int M;
    public int cnt = 0;
    boolean visit[];
    String [][] arr;
    boolean flag = false;
    int answer = 0;
    boolean check = false; // 유일성을 만족하기 위한 플래그 변수
    public List<Integer> list = new ArrayList<>();
    public Set<String> set = new LinkedHashSet<>();
    public HashMap<Integer,List<String>> list2 = new HashMap<>(); // 문자열 튜플 이어붙이기
    public boolean flag2 = false;
    public int solution(String[][] relation) {
        // 인적사항을 정리하는 업무를 담당
        // 후보키 : 데이터베이스 릴레이션의 튜플을 유일하게 식별할수 있는 속성
        // 유일성(uniqueness) 
        // 최소성 : 즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다.
        // 목적 : 후보 키의 최대 개수
        
        N = relation.length; // 행 // 6
        M = relation[0].length; // 열 // 4
        arr = new String[M][N]; // 새로만든 배열
        visit = new boolean[M];
        // 1 . 정렬
        
        // 주어진행 [N][M] --> [M][N] 데이터로 만들기
        for(int i = 0; i <M; i++){
        	boolean flag = true;
            for(int j = 0; j <N; j++){
                arr[i][j] = relation[j][i];
            }
            // 즉시 한행 정렬 합니다.
            Arrays.sort(arr[i]);
            
            // 만약 원소중 같으 것이 존재하지 않으면 O
            for(int j = 0 ; j < arr[i].length-1; j++) {
            	
            	if(arr[i][j].equals(arr[i][j+1])) {
            		flag = false;
            		visit[i] = true;
            		cnt++; // 살펴볼 갯수
            		break;
            	}
            }
            if(flag) {
            	answer++; // 후보키 찾음
            }

        }
        // 구현
        for(int j = 0; j< visit.length; j++) {
        	for(int i = 2; i <= cnt; i++) {
        		if(visit[j]) {
        			check = false;
        			list.add(j);
        			boolean check2 = solve(1,j,i,relation,"");
        			if(check2) {
        				for(int a : list) {
        					visit[a] = false;
        				}
        				answer++;
        			
        			}
        			list.clear();
        		}
        	}
        }
        
      
      
        
        // 3. 탐색이 안된 열중 재귀함수로 구현(조합)
        
        // 3-1. 조합구현중 열을 이어붙여 다음과 같은게 나오면 false
        
   
        return answer;
    }
	private boolean solve(int depth, int start, int cnt,String [][] relation,String temp) {

		for(int i = 0; i <N; i++) {
			List<String> list3 = new ArrayList<>();
			list3.add(relation[i][start]);
			//list3 = list2.get(i);
			list2.put(i, list3);
		}
		// 두개의 행을 끝까지 이어 붙이기
		for(int i = start+1; i<M; i++) {
			flag2 = true;
			
			if(visit[i]) {
				depth++;
				
					for(int j = 0; j <N; j++) {
						//list2.add(relation[j][start]);
						List<String> list3 = new ArrayList<>();
						list3 = list2.get(j);
						// 체크가 필요 누적값중 중복되는 값이 있는가?
						list3.add(relation[j][i]);
						list2.put(j, list3);
						isCheck(list2,j); 
						//list2.clear();
					}
					
				
			}
			if(flag2) {
				list.add(i);
			}
			
			if(depth == cnt) {
				if(list.size() == cnt) {
					return true;
				}else {
					return false;
				}
			}
				
			
			
		}
		return false;
		
	}
	private void isCheck(HashMap<Integer,List<String>> map,int i) {
		
			List<String> list3 = map.get(i);
			String temp = "";
			for(String str :list3) {
				temp += str;
			}
			if(set.contains(temp)) {
				flag2 = false;
			}else {
				set.add(temp);
			}
			
		
		
		
	}
	
}