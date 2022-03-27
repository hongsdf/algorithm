package backjun;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14502_2 {
	public static int N,M ; // 행,열
	public static int board[][]; // 원본 배열
	public static int map[][]; //복사본(완전탐색을 하기위해 원본배열 손상을 막기 위해)
	public static int answer = -1;
	public static int[]dx = { -1, 1, 0, 0};
	public static int[]dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		map = new int[N][M];
		for(int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j <N;j++) {
				map[i][j] = board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i <M; i++) {
			for(int j = 0; j <N;j++) {
				if(board[i][j] == 0) {
					map[i][j] = 1;
					// 연구소 벽하나 설치
					dfs(1); // 하나 설치 된 상태에서 시작
					map[i][j] = 0; // 다시 돌려놔야 한다(완전 탐색이므로)
				}
			}
		}
			
		System.out.println(answer);
		
	}
	public static void dfs(int cnt) {
		
		// base -case
		if(cnt == 3) {
			// virus갯수 세기
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1; //기둥 세우기
					dfs(cnt+1); // recursive 
					map[i][j] = 0;
				}
			}
		}
		
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		// 복사본 배열의 손상을 막아야한다. 복사본도 실험이기 때문에 아니면 다시 돌려놔야한다
		int copymap[][] = new int[N][M];
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		for(int i = 0; i <N; i++) {
			for(int j =0; j <M; j++) {
				if(copymap[i][j] == 2) { // 바이러스 있는 위치
					q.add(new int[] { i ,j});
				}
			}
		}
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			for(int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
				if(copymap[nr][nc] == 0) {
					copymap[nr][nc] = 2;
					q.add(new int[] { nr,nc });
				}
			}
		}
		
		zero(copymap);
		
	}
	public static void zero(int[][] arr) {
		int cnt = 0;
		for(int i = 0; i <N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					cnt++;
				}
			}
		} 
		answer = Math.max(cnt,answer);
	}
	
}
