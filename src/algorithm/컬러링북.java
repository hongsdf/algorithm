package algorithm;
import java.util.*;

public class 컬러링북 {
	public static void main(String[] args) {
		SolutionK10 m = new SolutionK10();
		int m1 = 6;
		int n = 4;
		int picture[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] answer = m.solution(m1, n, picture);
		for(int ans :answer) {
			System.out.print(ans + " ");
		}
	}
}

class SolutionK10 {
    public int dx[] = {-1,1,0,0};
    public int dy[] = {0,0,-1,1};
    public boolean visit[][];
    public int cnt = 0;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        visit = new boolean[m][n];
        // 로직 구현
        // 탐색
        for(int i = 0; i <m; i++){
            for(int j = 0; j <n; j++){
                if(!visit[i][j] && picture[i][j] != 0){
                	int current = picture[i][j];
                    numberOfArea++;
                    cnt = 0;
                    bfs(i,j,numberOfArea,m,n , picture, current);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,cnt);
                }
            }
        }
        
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public void bfs(int x, int y , int numberOfArea,int m ,int n, int picture[][], int current){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        
        while(!q.isEmpty()){
            int curr[] = q.poll();
            if(visit[curr[0]][curr[1]]) continue;
            visit[curr[0]][curr[1]] = true;
            cnt++;
            
            for(int i = 0; i <4; i++){
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(!visit[nx][ny] && picture[nx][ny] != 0 &&picture[nx][ny] == current){
                        q.add(new int[]{nx,ny});
                   
                        
                    }
                }
            }
            
        }
    }
}