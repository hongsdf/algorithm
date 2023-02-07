package Monster;

import java.util.*;
import java.io.*;

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class 레이저타워{
	public static int dx[] = {-1,1,0,0,-1,-1,1,1};
	public static int dy[] = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0){
			String str[] = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int K = Integer.parseInt(str[1]);
		
			int board[][] = new int[N+1][N+1];
			
			int answer = 0;
			for(int i = 1; i <=N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 1; j <=N; j++){
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			List<Point> list = new ArrayList<>();
			for(int i = 0; i < K; i++){
				String str1[] = br.readLine().split(" ");
				list.add(new Point(Integer.parseInt(str1[0]),Integer.parseInt(str1[1])));
			}
			// 로직 구현
			// 목적 : 가장 많은 특수 시설을 레이저 타워로 보호
			for(Point curr : list){
				int cnt = check(board,curr);
				answer = Math.max(answer,cnt);
				
			}
			System.out.println(answer);
			
		}
		
		
	}
	public static int check(int board[][], Point curr){
			int cnt = 0;
			int x = curr.x;
			int y = curr.y;
			
			if(board[x][y] == 1) cnt+=1; // 처음 좌표
			// 8방향
			for(int i = 0; i <8; i++){
				for(int j=1; j<=board.length-1; j++){
						int nx = x + (j * dx[i]);
						int ny = y + (j * dy[i]);
				if(nx >= 1 && nx <= board.length-1 && ny >= 1 && ny <= board.length-1){
					if(board[nx][ny] == 1){
						cnt+=1;
					}
				}	
			}	
			
			
		}
		return cnt;
	}
}