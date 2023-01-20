package algorithm;

public class 조이스틱 {
	public static void main(String[] args) {
		SolutionC2 m = new SolutionC2();
		String name = "JEROEN";
		int answer = m.solution(name);
		System.out.println(answer);
		System.out.println(answer == 10? "true":"false");
	}
}
class SolutionC2 {
    public int solution(String name) {
        // 커서 독립적
        int answer = 0;
        int move =  name.length()-1;//좌우 로 이동하는 거리
        
        int n = name.length();
        for(int i = 0; i <n; i++){
            int target = name.charAt(i);
            
            answer += Math.min(target-'A','Z'-target +1); // 앞에서 접근, 뒤에서 접근중 작은값으로 
            
            // A 연속된구간 찾기 (2구간부터가 연속이므로
            // 사이 값 구하기 J|AA|NN
            int start = i+1; // JAAN 1,2  3
            // AAABBBAAAA // 2
          
            while(start < n && name.charAt(start) == 'A'){
                 start+=1;
            }
               
            
            // AJJAAAN  
            // [J] [A] [A] [N] 이동시 최소거리 
            // JANAAN
            move = Math.min(move,(i*2) + n - start ); 
            
            
            
            // 처음 부터 맨 뒤부터 탐색하는 경우
            move = Math.min(move,i +  (n - start)*2);
        }
            
        
        
        
        return answer + move;
    }
}