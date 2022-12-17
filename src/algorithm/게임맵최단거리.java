package algorithm;

import java.util.LinkedList;

public class 게임맵최단거리 {
	public static void main(String[] args) {
		SolutionB1 m = new SolutionB1();
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}} ;
		m.solution(maps);
	}
}

class point{
    int x;
    int y;
    point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class SolutionB1 {
    public int[] dx ={-1,1,0,0};
    public int[] dy ={0,0,-1,1};
    public boolean visit[][];
    
    public LinkedList<point> q = new LinkedList<>();;
    public int solution(int[][] maps) {
        // 목적: 상대 팀 진영을 먼저 파괴하면 이기는 게임
        
        
        //  구현층
        //  bfs를 구현하여 최단 거리로 구한다.
        // 단 최단 거리를 다 연결하고 나서 N,M지점이 아닐 경우 -1를 리턴한다.
        // 1,1부터 시작 1-BASE 시작 이라고 하지만 그림에서만 1-Base일뿐 실제로는 0 Base 이다. 결국 마지막 지점은 N-1,M-1이다.
        
        // n,m을 찾기
        int n = maps.length; // 가로 
        int m = maps[0].length; // 세로
        visit = new boolean[n][m];
        // 구현 층
    
        bfs(n,m,maps);
        
        
        int answer = maps[n-1][m-1]== 1? -1: maps[n-1][m-1]; 
        return answer;
    }
    public void bfs(int N, int M,int maps[][]){
        q.add(new point(0,0));  // 시작점 1,1
        // 2,1 ==> 구현 2-1,1-1 
        while(!q.isEmpty()){
            point curr = q.poll();
            if(visit[curr.x][curr.y]) continue;
            visit[curr.x][curr.y] = true;
            // 도착지점 체크 
            if(visit[N-1][M-1] == true){
                break; // 도달 했다.
            }
            
            for(int i = 0; i <4; i++){
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];
            if(nx >= 0 && nx <= N-1 && ny >= 0 && ny <= M-1){
                if(!visit[nx][ny] && maps[nx][ny] != 0){
                    q.add(new point(nx,ny)); // 갈 수 있는 길
                    maps[nx][ny] = maps[curr.x][curr.y]+1;
                }     
            }
           
        }
            
        }
        
        
        
        // 출발지점부터 상하좌우 이동
        
       
        
        
    }
    
    
}