package al2;

public class 조이스틱 {
	public static void main(String[] args) {
		SolutionK1 m = new SolutionK1();
		String name = "JEROEN"; // 5
		int answer = m.solution(name);
		System.out.println(answer);
	}
}
class SolutionK1 {
    public int solution(String name) {
        int answer = 0;
        
        // 조건 커서 이해하기
        // 상 : [] 한칸 상향 조정한다.
        // 하 : [] 한칸 아래로 조정
        // 좌 : [] -> []  커서 이동
        // 우 : [] <- [] 커서 이동
        
        // 살펴보기
        // 좌우 살펴보기
        char names[] = name.toCharArray();
        int n = names.length;
        int move = names.length-1;
        for(int i = 0; i < n; i++) {
        	// 좌우 움직임 
        	
        	// 해결방법
        	// 각 원소마다 앞,뒤 체크를 할것이다. 앞에서 부터하는 것이 최소일까? 뒤부터하는 것이 최소일까? 그냥 순차적으로 하는 것이 최소일까?
        	int start = i + 1;// 초과범위 생성
        	
        	while(start < n && names[start] == 'A') {
        		start++;
        	}
        	
        	// 앞 ,뒤,순차적
        	move = Math.min(move, Math.min(i * 2 + n - start, i + (n-start) * 2));
        	
        	
        			
        	
        	if(names[i] - 'A' >= 'Z'-names[i] + 1) {
        		answer += 'Z'-names[i] + 1;
        	}else {
        		answer += names[i] - 'A';
        	}
        	
        	
        	
        }
        
        
        
        
        
    
        return answer + move;
    }
}