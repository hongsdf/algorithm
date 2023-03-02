package imf;
import java.util.*;

public class 전력망둘로나누기 {
	public static void main(String[] args) {
		Solution m = new Solution();
		int n = 9; // 9
		// [1,2],[2,3],[3,4]
		// {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		 int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//		int [][] wires = {{1,2},{2,3},{3,4}};
//		int [][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
		int answer = m.solution(n, wires);
		System.out.println(answer);
	}
}

class Solution {
     int answer = 999;
    public int solution(int n, int[][] wires) {
       
        int board[][] = new int[n+1][n+1];
        // 간선연결
       
        for(int [] edge : wires){
            int u = edge[0];
            int v = edge[1];
            
            board[u][v] = 1;
            board[v][u] = 1;
        }
        /*
         *  풀이방법
         *  2n^3 으로 풀이
         *  2차 반복문을 수행하면서 연결된 하나의 간선을 끊는다.
         *  1번하고 연결된 간선 2,3이 있다면 2,3을 각각 끊고 bfs을 돌려 섬의 위치를 island,island2를 체크 => 복원
         *  
         * 
         */
        for(int i = 1; i <= n; i++){
            dfs(i,board,n); // 간선을 끊는다.  
        }
        
        return answer;
    }
    public void dfs(int i, int[][] board,int n){
        int island = 0; int island2 = 0;        
        for(int a = 1; a<=n; a++){
            // i와 관련된 모든 간선제거
            if(a == i) continue;
            if(board[i][a] == 1) {
            	board[i][a] = 0;
            	board[a][i] = 0;
            	island = i;
            	island2 = a;
            	int cnt1 = bfs(island,n,board);
            	int cnt2 = bfs(island2,n,board);
            	answer = Math.min(answer,Math.abs(cnt1-cnt2));
            	board[island][island2] = 1; // 복원
            	board[island2][island] = 1; // 복원
//            	break;
            }
        }
    }
    public int bfs(int island,int n,int board[][]){
        int cnt = 0;
        boolean visit[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(island);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(visit[curr]) continue;
            visit[curr] = true;
            cnt++;
            
            for(int i = 1; i <=n; i++){
                if(!visit[i] && board[curr][i] == 1 && board[i][curr] == 1){
                    q.add(i);
                }
            }
            
        }
        return cnt;
    }
}