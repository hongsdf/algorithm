package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class to {
	
	 static class pointer{
		int x;
		int y;
		int day;
		pointer(int x, int y, int day){
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	
	public static int M,N;
	public static int board[][];
	public static boolean visit[][];
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 열
		N = sc.nextInt(); // 행
		board = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		bfs();
	
		
		
		 
	}
	private static void bfs() {
		// 익은 토마토가 여러개 이면 출발점이 여러개이다. := 여기서는 출발점 여러개를 동시 출발하는 구현이 핵심
		// 토마토 문제에 대해선 visit[][]활용하지 않았다 := 새로운 지점을 값 자체를 변경하기 때문에 board[nr][[nc] = 1;
		// visit을 활용할때 := 같은 구역을 연결할때 보통 사용한다.
		Queue<pointer> q = new LinkedList<pointer>();
		int day = 0;
		// 출발점을 모두 q에 담는다
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<M; j++) {
				if(board[i][j] == 1) {
					q.add(new pointer(i,j,day));
				}
			}
		}
		
		while(!q.isEmpty()) {
			pointer curr = q.poll();
			int Row = curr.x;
			int Col = curr.y;
			day = curr.day;
			// 인접한 토마토 탐색
			for(int i = 0; i<4; i++) {
				int nr = Row+dx[i];
				int nc = Col+dy[i];
				// 범위 제한
				if(nr < 0 || nr> N-1 || nc <0 || nc > M-1) continue;
				if(board[nr][nc] == 0) {
					board[nr][nc] = 1; //익었다 표시
					q.add(new pointer(nr,nc,day+1));
				}
			}
			
		}
		//토마토가 다 있었는지 체크
		boolean flag = check();
		if(flag) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}
		
		
	}
	private static boolean check() {
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<M; j++) {
				if(board[i][j] == 0) { //익지않은 토마토가 존재한다면
					return false;
				}
			}
		}
		return true;
	}

	
	
}
