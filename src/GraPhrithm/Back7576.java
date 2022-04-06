package GraPhrithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// day
class Pointer{
	int node[] = new int[2];
	int day;
	
	Pointer(int x, int y, int day) {
		this.node[0] = x;
		this.node[1] = y;
		this.day = day;
	}
	
	
	
	
	
}


public class Back7576 {
	
	public static int N,M;
	public static int board[][];
	public static boolean visited[][];
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		bfs(); 
		
		
		
	}

	private static void bfs() {
		int day = 0;
		Queue<Pointer> q = new LinkedList<Pointer>();
		for(int i = 0; i < M ; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 1) q.add(new Pointer(i,j,day));
			}
		}
		
		while(!q.isEmpty()) {
			Pointer curr = q.poll();
			day = curr.day;
			
			for(int i = 0; i < 4; i++ ) {
				int nr = curr.node[0] + dx[i];
				int nc = curr.node[1] + dy[i];
				
				if(nr < 0 || nr > M-1 || nc < 0 || nc > N-1) continue;
				if(board[nr][nc] == 0) {
					board[nr][nc] = 1;
					q.add(new Pointer(nr,nc,day + 1)) ;
					
				}
			}
		}
		boolean flag = check(board);
		System.out.println(flag? day: -1);
		
	}

	private static boolean check(int[][] board) {
		for(int i = 0; i <M; i++) {
			for(int j = 0; j<N; j++) {
				if(board[i][j] == 0) return false;
			}
		}
		
		return true;
	}

	
}
