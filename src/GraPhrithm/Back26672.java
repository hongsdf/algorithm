package GraPhrithm;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



// 단지 번호 붙히기
public class Back26672 {
	public static int N;
	public static int housecnt[];
	public static int board[][];
	public static boolean visited[][];
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		for(int i=0;i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				board[i][j] = s.charAt(j)-'0';
				// board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int countrycnt = 0;
		int color = 0;
		housecnt = new int[N*N];
		for(int i=0;i<N; i++) {
			for(int j=0;j<N; j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					countrycnt++;
					color++;
					bfs(i,j,countrycnt,color);
				}
			}
		} 
		Arrays.sort(housecnt);
		System.out.println(countrycnt); // 단지 갯수
		for(int i=0;i<housecnt.length; i++) {
			if(housecnt[i] !=0 ) System.out.println(housecnt[i]);
		}
		
	}
	private static void bfs(int r, int c,int countrycnt,int color) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		housecnt[countrycnt]++;
		visited[r][c] = true;
		board[r][c] = color;
		
		while(!q.isEmpty()) {
			 int curr[] = q.poll();
			 int R = curr[0];
			 int C = curr[1];

			 
			 for(int i = 0; i < 4; i++) {
				 int nr = R +dx[i];
				 int nc = C +dy[i];
				 
				 if(nr < 0 || nr > N-1 || nc < 0 || nc > N -1) continue;
				 if(!visited[nr][nc] && board[nr][nc] == 1) {
					 visited[nr][nc] = true;
					 q.add(new int[] {nr,nc}) ;
					 housecnt[countrycnt]++;
					 board[nr][nc] = color;
				 }
			 }
			 
			 
		}
		
		
		
	}
}
