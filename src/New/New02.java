package New;
import java.util.*;

/**
 * 
 * @author 카카오 탐색문제
 * BFS,DFS 사용
 * 
 */

public class New02{
	public static void main(String[] args) {
		Solution02 M = new Solution02();
		int m = 6;
		int n = 4;
		int [][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int answer[] = M.solution(m, n, picture);
		for(int ans:answer) {
			System.out.print(ans+" ");
		}
	}
}


class Pointer{
    int x;
    int y;
    Pointer(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution02 {
    int dx[] = {-1,1,0,0}; // 상,하
    int dy[] = {0,0,-1,1}; // 좌,우
    boolean visit[][];
    int numberOfArea = 0; // 지역 수
    int maxSizeOfOneArea = 0; //최대 영역
    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n]; // 방문 배열 초기화
        
        // 로직
        solve(picture,m,n);
        
        
        
        // 정답 처리 부분
        int[] answer = new int[2];
        answer[0] = numberOfArea; //그림에 몇 개의 영역이 있는지
        answer[1] = maxSizeOfOneArea; // 가장 큰 영역은 몇 칸으로 이루어져 있는지
        return answer;
    }
    public void solve(int[][] picture,int m,int n){
        for(int i = 0; i <m; i++){
            for(int j = 0; j <n; j++){
                if(!visit[i][j] && picture[i][j] != 0){
                    numberOfArea++; //지역 증가
                    int Areasize = dfs(i,j,picture,m,n); // 해당 공간 사이즈 
                    if(Areasize > maxSizeOfOneArea) maxSizeOfOneArea = Areasize;
                }
            }
        }
    }
    public int dfs(int i, int j,int [][] picture,int m, int n){
        Stack<Pointer> st = new Stack<>();
        st.push(new Pointer(i,j));
        int cnt = 0;
        while(!st.isEmpty()){
            Pointer curr = st.pop();
            if(visit[curr.x][curr.y]) continue;
            visit[curr.x][curr.y] = true;
            cnt++;
            
            for(int a = 0; a <4; a++){
                int Nx = curr.x + dx[a];
                int Ny = curr.y + dy[a];
                if(Nx >= 0 && Nx  < m && Ny >=0 && Ny < n){
                    if(!visit[Nx][Ny] && picture[Nx][Ny] == picture[i][j]){
                        st.push(new Pointer(Nx,Ny));
                    }
                }
            }
       
       }
		return cnt;
    }
}
