package algorithm;
import java.util.*;

public class 아이템줍기 {
	public static void main(String[] args) {
		SolutionK8 m = new SolutionK8();
		int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		int characterX = 1;
		int characterY = 3;
		int itemX = 7;
		int itemY = 8;
		m.solution(rectangle, characterX,characterY, itemX, itemY);
						
		
	}
}
class SolutionK8 {
    public int dx[] ={-1,1,0,0};
    public int dy[] = {0,0,-1,1};
    public boolean visit[][] = new boolean[51][51];
    public int answer = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int board[][] = new int[51][51];
        // 목표 : 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리
        // rectangle의 원소는 각 직사각형의 [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y] 좌표 형태 
        
        for(int [] rect :rectangle){
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];
            
            // 그림 채워넣기
            MakeintoBoard(board,x1,y1,x2,y2);
        }
        // 최단 거리 체크
        
        bfs(board,characterX,characterY,itemX ,itemY );
        
        
        return answer;
    }
    public void MakeintoBoard(int[][] board,int x1,int y1,int x2, int y2){
        for(int i = x1; i < x2; i++){            
            board[y1][i] = 1;
            board[y2][i] = 1;
        }
        for(int i = y1; i <y2; i++){
            board[i][x1] = 1;
            board[i][x2] = 1;
        }
        
    }
    public void bfs(int board[][]  ,int characterX,int characterY,int itemX ,int itemY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX,characterY});
        visit[characterX][characterY] = true;
        while(!q.isEmpty()){
               int curr[] =  q.poll();
               if(visit[curr[0]][curr[1]]) continue;
               visit[curr[0]][curr[1]] = true;
               answer++;
            
               for(int i = 0; i<4; i++){
                   int nx = curr[0] + dx[i];
                   int ny = curr[1] + dy[i];
                   
                   if(nx >= 0 && nx < board.length && ny >= 0 && ny < board.length){
                       if(!visit[nx][ny] && board[nx][ny] == 1){
                           q.add(new int[]{nx,ny});
                       }
                   }
               }
        }
    }

}