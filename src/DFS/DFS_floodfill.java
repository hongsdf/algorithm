package DFS;

import java.util.Scanner;
import java.util.Stack;

public class DFS_floodfill {
	public static int N;
	public static int size = 10; // 크기 지정
	public static int board[][] = new int [size][size];
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	// 2차원 자료를 넣기 위해 pointer 객체 생성
	public static class Pointer {
		Pointer(int row,int col) {
		this.Row = row;
		this.Col = col;
	}
	int Row, Col;
	
	
	
	public static void dfs(int row,int col, int color) {
		// dfs 방문여부 표시생성 
		boolean visited[][] = new boolean[size][size]; //크기는 board와 동일하게
		Stack<Pointer> st = new Stack<>();
		// new Pointer
		st.push(new Pointer(row,col));
		
		while(!st.isEmpty()) {
			Pointer curr = st.pop();
			if(visited[curr.Row][curr.Col]) continue;
			
			visited[curr.Row][curr.Col] = true;
			board[curr.Row][curr.Col] = color;
			
			// 4방향 움직임
			for(int i=0; i<4; i++) {
				int nr = curr.Row+dx[i];
				int nc = curr.Col+dy[i];
				if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
				if(board[nr][nc] == 1) continue;
				st.push(new Pointer(nr,nc));
				
			}
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		int color = sc.nextInt();
		dfs(row,col,color);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	}
}
