package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;



public class 문제5D레이저타워건설하기 {
	public static int dx[] = {-1,1,0,0,-1,-1,1,1};
	public static int dy[] = {0,0,-1,1,-1,1,-1,1};
	public static int answer = 0;
	
	public static void main(String args[]) throws IOException{
		// 목적 : 레이저 타워가 최대한 보호할 수 있는 특수 시설의 갯수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T -->0){
			int N = Integer.parseInt(br.readLine());
			int board[][] = new int[N+1][N+1];
//			boolean visit[][] = new boolean[N+1][N+1];
			for(int i = 1; i <=N; i++){
				String str[] = br.readLine().split(" ");
				for(int j = 1; j<=N; j++){
					board[i][j] = Integer.parseInt(str[j-1]);
				}
			}
			
			// 로직
			// N 300 * 300 * 10 = N(900000) := N (T * N*N)
			for(int i = 1; i <=N; i++){
				for(int j = 1; j<=N; j++){
						boolean visit[][] = new boolean[N+1][N+1];
						int cnt = bfs(i,j,N,board,visit);
						answer = Math.max(cnt,answer);
				}
			}
			bw.write(answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	public static int bfs(int a, int b,int N,int board[][],boolean visit[][]){
		int ans = 0;
//		Queue<int[]> q = new LinkedList<>();
//		q.add(new int[]{a,b});
		if(board[a][b] == 1) ans+=1;
		
//		while(!q.isEmpty()){
//			int curr[] = q.poll();
//			int x = curr[0];
//			int y = curr[1];
//			if(visit[x][y]) continue;
//			visit[x][y] = true;
			// 8방향
			for(int i = 0; i <8; i++){
				for(int j = 1; j <=N; j++){
					int nx = a + j * dx[i];
					int ny = b + j * dy[i];
					if(nx >= 1 && nx <= N && ny >=1 && ny <=N){
						if(!visit[nx][ny]){
							if(board[nx][ny] == 1){ // 특수시설 타워라면
								ans+=1;
							}
//							q.add(new int[]{nx,ny});
						}
					}
				}
			}
//		}
		return ans;
		
	}
}


