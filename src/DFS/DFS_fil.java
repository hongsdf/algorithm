package DFS;
 
import java.util.Scanner;
import java.util.Stack;

public class DFS_fil {
	public static int N;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static class Point{
		Point(int r, int c){
			this.row = r;
			this.col = c;
			
		}
		int row;  int col;
	}
	public static void dfs(int r, int c, int color) {
		// ���� ���纻 boolean�迭
		boolean visited[][] = new boolean[N][N];
		Stack<Point> st = new Stack<>();
		// point primitiveŸ���� �ƴϹǷ� new point
		st.push(new Point(r,c));
		
		while(!st.isEmpty()) {
			Point curr = st.pop();
			// 
			if(visited[curr.row][curr.col]) continue;
			else {
				visited[curr.row][curr.col] = true;
			}
//			System.out.print(curr+" ");
			for(int i =0; i <4; i++) {
				int nr = curr.row + dx[i];
				int nc = curr.col + dy[i];
				// ���� ����
				if(nr < 0 || nr > N-1 || nc <0 || nc>N-1) continue;
				// ���ο� point �湮���� üũ
				if(visited[nr][nc]) continue;
				st.push(new Point(nr,nc));
			}
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int board[][] = new int[N][N];
		for(int i =0; i <N; i++) {
			for(int j =0; j <N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int row = sc.nextInt();
		int col = sc.nextInt();
		int color = sc.nextInt();
		dfs(row,col,color);
		
		
		
		
	}
	

}
