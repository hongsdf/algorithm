package New;

import java.util.*;
/**
 * @author 전력망을 둘로 나누기
 * 원리 : 완전 탐색, 인접 행렬, 
 *
 *
 *
 */
 public class New03{
	 public static void main(String[] args) {
		 Solution03 m = new Solution03();
		 int n = 9;
		 int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
		 int answer = m.solution(9, wires);
		 System.out.println(answer);
	}
 }



class Solution03 {
    int board[][];
    int answer = 9999; //최소값
    int size;
    public int solution(int n, int[][] wires) {
    	size = n;
        // 간선 연결    
        board = new int[n+1][n+1];
        for(int [] wire:wires){
            board[wire[0]][wire[1]] = board[wire[1]][wire[0]] = 1;
        }
     
        solve(board); // 전선을 2개로 분리
        
        // 두 전력망이 가지고 있는 송전탑의 갯수  
        return answer;
    }
    public void solve(int[][] board){
        boolean visit[] = new boolean[size+1];
        // n개를 차례차례 끊어 본다.
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                if(i == j) continue;
                if(board[i][j] == 1 && board[j][i] == 1){
                    board[i][j] = 0; //연결 끊기
                    board[j][i] = 0;
                    // i번째와 연결된 모든 노드를 끊었다.
                    int ans = dfs(i,visit); // 연결된 지점 탐색
                    int result = size - ans;
                    answer = Math.min(answer,Math.abs(result-ans));
                    // 다시 복원작업 필요
                    board[i][j] = 1; 
                    board[j][i] = 1;
                    Arrays.fill(visit,false);
                } 
            }
        }
    }
    public int dfs(int target,boolean visit[]){
        Stack<Integer> st = new Stack<>();
        st.push(target);
        int cnt = 0;
        
        while(!st.isEmpty()){
            int curr = st.pop();
            if(visit[curr]) continue;
            visit[curr] = true;
            cnt++;
            
            for(int i = 1; i<=size; i++){
                if(!visit[i] && board[curr][i] == 1 && board[i][curr] == 1){
                    st.push(i);
                }
            }
        }
        return cnt;
    }
    
}