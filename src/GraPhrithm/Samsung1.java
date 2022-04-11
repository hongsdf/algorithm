package GraPhrithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Samsung1 {
	public static int N,M ; // 행,열
	public static int board[][]; // 원본 배열
	public static boolean[][] visit;
//	public static int map[][]; //복사본(완전탐색을 하기위해 원본배열 손상을 막기 위해)
	public static int answer = -1;
	public static int[]dx = { -1, 1, 0, 0};
	public static int[]dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit = new boolean[N][M];
//		map = new int[N][M];
		for(int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j <N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0);
		
		System.out.println(answer);
		
	}
	private static void bfs(int cnt) {
		if(cnt == 3) {
			// 세워보고 바이러스 번지는 기능을 만들기
			virus(board);
			return;
		}
		
					for(int i = 0; i <N; i++) {
						for(int j = 0; j <M; j++) {
							if(!visit[i][j] && board[i][j] == 0) {
								visit[i][j] = true;
								board[i][j] = 1;
								bfs(cnt+1);
								board[i][j] = 0;
								visit[i][j] = false;
							}
						}
					}
		
		
	}
	
	
	
	private static void virus(int[][] board) {
		int copyboard[][] = new int[N][M];
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				copyboard[i][j] = board[i][j];
			}
		}
		
		
		Stack<int[]> st = new Stack<>();
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(copyboard[i][j] == 2) {
					st.push(new int[] {i,j});
				}
			}
		}
		while(!st.isEmpty()) {
			int curr[] = st.pop();
			int x = curr[0];
			int y = curr[1];
			for(int i = 0; i <4; i++) {
				int nr = x +dx[i];
				int nc = y +dy[i];
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
				if(copyboard[nr][nc] == 0) {
					copyboard[nr][nc] = 2;
					st.push(new int[] {nr,nc});
				}
			}
		}
		Zero(copyboard);
	
		
	}
	private static void Zero(int[][] board) {
		int count = 0;
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(board[i][j] == 0) count++; 
			}
		}
		answer = Math.max(answer, count) ;
		
	}
}