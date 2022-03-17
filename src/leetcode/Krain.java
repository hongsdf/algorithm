package leetcode;
import java.util.*;

public class Krain {
	public static void main(String[] args) {
		Solution3 m = new Solution3();
		int board[][] = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int moves[] = new int[] {1,5,3,5,1,2,1,4};
		int ans = m.solution(board, moves);
		System.out.println( ans *2);
	}
}
class Solution3 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; 
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < moves.length; i++){
            int pos = moves[i];
            for(int j = 0; j<board.length; j++ ){
                if(board[j][pos-1] !=0) {
                    if(st.isEmpty()){
                       st.push(board[j][pos-1]);
//                       System.out.println(board[j][pos-1]);
            
                    }else{
                     
                    	if(st.peek() == board[j][pos-1]){
                           st.pop();
                           answer++;
                       }else {
                    	   st.push(board[j][pos-1]);
                       }
                    	
                    }
                    board[j][pos-1] = 0;
                    break;
                    
                }
            }
        }
       
        return answer;
    }
}