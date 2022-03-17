package leetcode;

import java.util.Stack;

public class Krain2 {
	public static void main(String[] args) {
		Sol1 m = new Sol1();
		int board[][] = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int moves[] = new int[] {1,5,3,5,1,2,1,4};
		int ans = m.solution(board, moves);
		System.out.println(ans);
	}
}
class Sol1{
	public int solution(int board[][], int[] moves) {
		// 지워 지는 블럭수
		int answer = 0;
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i <moves.length; i++) {
			// 맞는 블럭위치에서 하나씩 꺼내 stack에 담기
			int idx = moves[i];
			for(int j =0; j<board.length; j++) {
				if(board[j][idx - 1] != 0) {
					if(st.isEmpty()) {
						st.push(board[j][idx-1]);
						
					}else {
						if(st.peek() == board[j][idx-1]) {
							st.pop() ;
							answer += 2; 
							
						}else {
							st.push(board[j][idx-1]);
						}
					}
					
					board[j][idx - 1] = 0; 
					break;
					
				}
				
			}
		}
		
		
		
		
		return answer;
	}
}