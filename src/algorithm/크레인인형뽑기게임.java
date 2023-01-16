package algorithm;

import java.util.*;
public class 크레인인형뽑기게임 {
	public static void main(String[] args) {
		SolutionK1 m = new SolutionK1();
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		int answer = m.solution(board, moves);
		System.out.println(answer);
	}
}
class SolutionK1 {
    public Stack<Integer> st = new Stack<>();
    public int answer = 0;
    public int solution(int[][] board, int[] moves) {
      
        // 목적 : 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수
        // moves : 크레인 이동 동작
        // 결과를 담을 stack
        
        int n = board.length;
        
        for(int i = 0; i <moves.length; i++){
            // 크레인 동작 움직이기
            int num = moves[i];
            for(int j = 0; j <n; j++){
                //보드에서 원소 집기
                if(board[j][num-1] != 0){
                   // check함수구현
                    check(board[j][num-1]);
                  
                   // 빈 값표시
                    board[j][num-1] = 0;
                   
                   break;
                   
                }
               
            }
           
        }
       
        return answer;
    }
    
    public void check(int num){
        if(!st.isEmpty() && st.peek() == num){
            st.pop();
            answer+=2;
          
        }else{
            st.push(num);
            
        }
 
      
    }
}