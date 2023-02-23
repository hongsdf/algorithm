package sk;
import java.util.*;

public class Test3 {
	public static void main(String[] args) {
		Solution3 m = new Solution3();
//		"00011", "01111", "21001", "11001", "01111"}, {"00011", "00011", "11111", "12101", "11111"
//		"1111", "1121", "1001", "1111"], ["0000", "0000", "0000", "0002"], ["0000", "0100", "0000", "0002"], ["0000", "0010", "0121", "0010"
		String[][] boards = {{"1111", "1121", "1001", "1111"}, {"0000", "0000", "0000", "0002"},{"0000", "0100", "0000", "0002"}, {"0000", "0010", "0121", "0010"}};
		int[] answer = m.solution(boards);
		for(int a :answer) {
			System.out.println(a);
		}
	}
}

class Solution3 {
    public int dx[] ={-1,1,0,0};
    public int dy[] ={0,0,-1,1};
   
    public int[] solution(String[][] boards) {
    	int size = boards.length;
        int answer[] = new int[size];

        // 상하 좌 우 중하나의 방향으로만 이동
        // 이동할수 없다면 현재 위치에 꽃을 심고 이동하지 않는다.
        // 현재 위치에 꽃을 심고 이동
        // 방향으로 이동할수 없다면 2번과정 반복(정한 방향으로 이동)
        // 현재 위치에서 좌가 막히면 한번더 좌로 이동(방향 변경 x)
        // 이미 꽃이 심어진 칸으로 이동 불가

        // 목적 : 맵의 모든길에 꽃을 심을수 있는지 알아보기
        int z = 0;
        for(String str[] : boards){
            int cnt = 0;
            // 맵으로 만들기
            int n = str.length;
            int map[][] = new int[n][n];
            boolean visit[][] = new boolean[n][n];
            for(int i = 0; i <n;i++){
                char c[] = str[i].toCharArray();
                for(int j = 0; j < n; j++){
                    map[i][j] = c[j]-'0';
                    if((c[j]-'0') == 1) cnt++; // 바꿔야하는 꽃의수
                }
            }
            // 로직 구현
            boolean flag = false;
            for(int i = 0; i <n; i++){
                for(int j = 0; j <n; j++){
                    if(map[i][j] == 2){
                        bfs(i,j,visit,map);
                        
                    }
                }
            }
            flag = check(map,cnt);
            if(flag) {
            	answer[z] = 1;
            }else {
            	answer[z] = 0;
            }
            z++;
            

        }

        // 로직구현
        
        return answer;
    }
    public void bfs(int x, int y,boolean visit[][],int map[][]){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int [] curr = q.poll();
            if(visit[curr[0]][curr[1]]) continue;
            visit[curr[0]][curr[1]] = true;
           

            for(int i = 0; i <4; i++){
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if(nx >= 0  && nx < visit.length && ny >=0 && ny < visit.length){
                    if(!visit[nx][ny] && map[nx][ny] == 1 && map[nx][ny] == 2){
                        q.add(new int[]{nx,ny});
                        map[nx][ny] = 2;
                        break;
                        
                    }
                }
                
            }

        }
    }

    public boolean check(int map[][], int cnt){
        int count = 0;
        for(int i = 0; i <map.length; i++){
            for(int j = 0; j <map.length; j++){
                if(map[i][j] == 2){
                    count++;
                }
            }
        }
        if(count == cnt) return true;
        return false;
    }


}