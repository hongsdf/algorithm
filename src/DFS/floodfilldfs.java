package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class floodfilldfs {
	public static class pointer{
		int row;
		int col;
		
		
		pointer(int row, int col){
			this.row = row;
			this.col = col;
			
		}
	}
	
	public static int color;
	public static int n;
	public static int[][] board;
	public static int[] dx = {-1,1,0,0}; // 상,하
	public static int[] dy = {0,0,-1,1}; // 좌,우
	public static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		color = Integer.parseInt(st.nextToken());
		size = n+1; // size 선정은 : 문제에서 제시된 만큼 + 1
		board = new int[size][size];
		for(int i =0; i <n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j <n;  j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,color);
		
		for(int i =0; i <n; i++) {
			for(int j =0; j <n;  j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	private static void dfs(int r, int c, int color) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[size][size];
		Stack<pointer> st = new Stack<pointer>();
		st.push(new pointer(r,c));
		
		while(!st.isEmpty()) {
			pointer curr = st.pop();
			
			if(visited[curr.row][curr.col]) continue;
			
			visited[curr.row][curr.col] = true;
			board[curr.row][curr.col] = color;
			
			for(int i =0; i <4; i++) {
				int nr = curr.row + dx[i];
				int nc = curr.col + dy[i];
				
				if(nr < 0 || nr  > n-1 ||
					nc < 0 || nc > n -1) continue;
				
				
				if(board[nr][nc] == color) continue;
				
				st.push(new pointer(nr,nc));
			}
			
		}
		
	}
}
