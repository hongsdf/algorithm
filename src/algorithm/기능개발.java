package algorithm;
import java.util.*;

public class 기능개발 {
	public static void main(String[] args) {
		SolutionA1 m = new SolutionA1();
		//int progresses[] = {93, 30, 55};
		int progresses[] = {95, 90, 99, 99, 80, 99};
		
		//int speeds[] = {1, 30, 5};
		int speeds[] = {1, 1, 1, 1, 1, 1};
		int ans[] = m.solution(progresses, speeds);
		for(int num : ans) {
			System.out.printf("%d ",num);
		}
	}
}

class Pointer{
    int idx; // 번호
    int val; 
    public Pointer(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}

class SolutionA1 {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> st = new Stack();
        List<Integer> res = new ArrayList<>(); // 결과를 담을 리스트
        List<Pointer> list = new ArrayList<>();
        
        for(int i = progresses.length-1 ; i >= 0; i--){
            st.push(progresses[i]); // 역순으로 삽입
        }
        
        int z = 0; // speeds의 인덱스 번호
        while(!st.isEmpty()) {
            int curr = st.pop();
            if((100 - curr) % speeds[z] == 0){
                int day = (100 - curr) / speeds[z];
                list.add(new Pointer(z,day));
            }else{
                // 100 - 30 % 30
                int day = (100 - curr) / speeds[z];
                day++;
                list.add(new Pointer(z,day));
            }
            z++;
                    
        }
        int cnt = 0; //하루밤에 완성되는 갯수
        // list가 완성되면
        int i = 0;
        for(; i <list.size();  ){
             Pointer curr  = list.get(i);
             cnt++;
             for(int j = i+1; j<list.size(); j++){
                 Pointer next = list.get(j);
                 if(curr.val >= next.val){
                     cnt++;
                     // 마지막 원소까지 살펴 봤다면
                     if(j == list.size()-1) {
                		 i = list.size();
                		 break;
                     }
                 }else{
         
                		 i = j-1;
                		 break;                		 
                	 
                 }
                 
             }
            
             res.add(cnt);
             cnt = 0;
             i++;
        }
        int[] answer = new int[res.size()];
        for(int k = 0; k < res.size(); k++){
            answer[k] = res.get(k);
        }
            
        return answer;
    }
}