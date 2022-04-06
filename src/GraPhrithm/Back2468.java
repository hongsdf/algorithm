package GraPhrithm;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2468 {
	public static int N;
	public static int board[][];
	public static int copy_board[][];
	public static int max;
	public static boolean visit[][];
	public static int dx[]= {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static int maxnum;
	public static int minnum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = -1;
		board = new int[N][N];
		
		maxnum = 0;
		minnum = 1000;
		
		for(int i = 0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				// 입력값중 최대값과 최소값 선정 
				if(maxnum < board[i][j]) maxnum = board[i][j];
//				if(minnum > board[i][j]) minnum = board[i][j];
			}
		}
		
		
		
		for(int h = 0 ; h < maxnum + 1 ; h++) {
			visit = new boolean[N][N]; // *위치 중요 브루트 포스 : 모든 높이가 초기화 될때마다 visit도 초기화 필요*
			int cnt = 0; // 영역크기
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(board[i][j] > h && !visit[i][j]) { // visit을 조건에 넣은 이유?  순회하고 나면 이어진 것을 연결한다. 그리고 다시 시도하면 값을 바꾼것이 아니기 때문에 다시 순회하므로 중복이 생긴다.
						// 연결(이어지는 구역까지만)
						cnt += bfs(i,j,h); //  하나로 연결된지역은 결국 크기 1
					}
				}
			}
			
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}

//	private static void check(int h,int [][] copy_board) {
//		for(int i = 0; i<N ; i++) {
//			for(int j = 0; j<N; j++) {
//				if(copy_board[i][j] <= h) {
//					copy_board[i][j] = -1;
//				}
//			}
//		}
//		int area = 0;
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				if(copy_board[i][j] > h ) {
//					area++; // 지금 구한것은 살아남아있는 지점 갯수를 구한것 생각 : 가벽을 쳤을때 이어지는 단지 크기
//					bfs(i,j);
//				
//				}
//			}
//		}
//		max = Math.max(area, max);
//		
//		
//		
//	}

	private static int bfs(int i, int j, int height) {
//		boolean visit[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			int row = curr[0];
			int col = curr[1];
			for(int p=0;p<4; p++) {
				int nr = row + dx[p];
				int nc = col + dy[p];
				
				if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
				
				if(!visit[nr][nc] && board[nr][nc] > height) {
					q.add(new int[] {nr,nc});
					visit[nr][nc] = true;
					
				}
			}
		}
		
		return 1; // 하나의 연결된 지역
		
		
		
		
	}
}
