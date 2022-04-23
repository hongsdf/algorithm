package algorithm;

import java.util.*;

class Solution {
   
    public int[] solution(int[] progresses, int[] speeds) {
       // 작업량을 만들어야한다 공식
       List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
       Stack<Integer> stack = new Stack<>();
       
        /* 	스택을 사용하는 이유? 
         	앞의 기준원소로 부터 (특정기준)을 가지고 뒤에 원소를 지울때 사용하는 원리
         	배열을 사용하면 확인했다 하고, 사용한 원소는 지워야하므로 까다롭다.
         	시간이 복잡도가 o(n^2)된다.
         	
         	
         	보통 스택의 방향은
         	앞 -> 뒤 갈때 특정기준을 조건에 맞은면 계속 적용한다.
         	ex) 
         	5 2 3 4
         	
         	5 ---->4
         	  2--->4
         	    3->4
         	       4
         	       
         	배열로 구현하면 이렇게
         	문제점은 확인한 원소는 지워햐하는데
         	list.set(i,0) 이런씩으로 세팅하고 if(list.get(i) !=0 이 아니면 이런씩으로 세팅을 해야한다.
         	복잡해 진다.
         	그래서 stack을 이용하자
         	
         	다시 말하자면
         	stack은 앞에서 뒤로 진행하며 
         	특정기준을 가지고 앞에서부터 뒤에 있는 원소를 적용해나아가며 풀이하기에 용이하다.(확인하며 지우기도 가능하다)
         	O(n)
         	
         	
         	for(int i = 0; i <list.size(); i++) {
         		for(int j=i; j<list.size(); j++) {
         		
         		}
         	}
         	
          
         */
        
        
        
        // 거꾸로 삽입해야한다. 스택을 사용하기 위해
        for(int i = progresses.length - 1; i >= 0; i--) {
            // 공식
            // (100 - 작업진도) / 작업속도 =  작업 일 수
            int cnt  = (100 - progresses[i]) / speeds[i];
            if( (100 - progresses[i]) % speeds[i] != 0 ){
                cnt++;
            }
            stack.add(cnt);
        }
        
        // 작업일수 리스트를 만들었다면 일수에 잇는것을 체크
        // 핵심원리 : 앞에 잇는 원소는 (기준) 뒤에 있는 원소가 작으면 데리고 나간다
        // 리스트에 저장순서가 어차피 앞의 원소인것을 증명한다.
        // 앞에 순서 고려 x
        
        // stack 기준 처음은 뽑아 낸다
        int standard = stack.pop();
        int num = 1;
        
        while(!stack.isEmpty()){
          
            if(standard >= stack.peek()){
               num++; // 작은 원소있으면 cnt++
               stack.pop(); //확인햇다 지우기(배열을 사용 하는것보다 좋은점)
            }
            else{
                standard = stack.pop(); // 큰원소로 기준을 바꾼다.
                // 지금까지 존재한 num을 저장
                result.add(num);
                num = 1; //  num 초기화
                
            }
            
        }
        //stack을 구현하면 비워져 잇는지확인 필요(남은 원소 출력)
        result.add(num);
        
        
        
        
        
        int[] answer = new int[result.size()];
        for(int i = 0; i <result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}