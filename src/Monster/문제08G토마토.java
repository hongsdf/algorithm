package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;

public class 문제08G토마토 {
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); // 가로
		int M = Integer.parseInt(str[1]); // 세로
		int board[][] = new int[M][N];
		
		int cnt = 0;
		int oneArea = 0;
		for(int i = 0; i <M; i++){
			String input[] = br.readLine().split(" ");
			for(int j = 0; j<N; j++){
				if(Integer.parseInt(input[j]) == 0) cnt+=1; // 익혀야하는 수
				else if(Integer.parseInt(input[j]) == 1) oneArea+=1;
				board[i][j] = Integer.parseInt(input[j]);
			}
		}
		if(oneArea == M*N ){ // 토마토가 모두 익어잇는 경우
			System.out.println(0);
			return;
		}
		
		int answer = -1;
		
		Queue<Pointer> q = new LinkedList<>();
		// 로직구현
		for(int i = 0; i <M; i++){
			for(int j = 0; j <N; j++){
				if(board[i][j] == 1){
					q.add(new Pointer(i,j,1));
				}
			}
		}
		while(!q.isEmpty()){
			Pointer curr = q.poll();
			int a = curr.x;
			int b = curr.y;
			int days = curr.day;
			// 4방향 접근
			for(int i = 0; i <4; i++){
				int nx = a + dx[i];
				int ny = b + dy[i];
				if(nx >= 0 && nx < M && ny >=0 && ny < N){
					if(board[nx][ny] == 0){
						q.add(new Pointer(nx,ny,days+1));
						board[nx][ny] = days+1;
						answer = Math.max(answer,days+1);
						cnt--; // 토마토 익음
					}
				}
			}
		}
		if(cnt != 0){ // 남은 토마토가 있는 경우
			System.out.println(-1);
			return;
		}
		
		System.out.println(answer-1);
		
		
		
		
	}

}
class Pointer{
	int x;
	int y;
	int day;
	
	Pointer(int x, int y, int day){
		this.x = x;
		this.y = y;
		this.day = day;
	}
}