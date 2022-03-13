package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


// 핵심정리
// dfs + bfs 함수를 같이 사용한다 ==> dfs + dfs2()를 구현해도 된다(최단 연결이아니고 연결만 하는 작업이므로)
// 배열3개   원본 <--> 복사본 <---> 복사본의 복사본

public class Back14502 {
	public static int N;
	public static int M;
	// 3단 복사를 할것이다
	public static int[][] board;
	public static int[][] map; // 원복 배열 복사본
	
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		map = new int[N][M];
		
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j <M; j++) {
				map[i][j] =	board[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(board[i][j] == 0) {// 원본 배열 -- > 복사본
					map[i][j] = 1; // 배열에서 0를 하나씩 다 뒤집어가며 최대 값 찾기  
					dfs(1); // 뒤집는 작업
					map[i][j] = 0; // dfs를 확인하고 다시 뒤집기
				}
				
			}
		}
		
		System.out.println(answer);
		
		
	}


	private static void dfs(int cnt) {
		if(cnt == 3) { // cnt가 3(벽을 3개세우면 bfs() : 바이러스 퍼지는 함수 )
//			bfs(); // 배열을 하나씩 다 확인 <-dfs() <- bfs() <-- Zero()
			dfs2();
			return;
		}
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(map[i][j] == 0) { // 복사본 배열내를 확인
					map[i][j] = 1; //  순차적으로 1개씩 뒤집어 본다
					dfs(cnt+1); // cnt 증가
					map[i][j] = 0; // 다시 뒤집기
				}
			}
		}
		
		
		
	}

	private static void dfs2() {
		int [][] arr = new int[N][M];
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				arr[i][j] = map[i][j];
			}
		}
		Stack<int[]> st = new Stack<>();
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(arr[i][j] == 2) {
					st.push(new int[] {i,j});
				}
			}
		}
		while(!st.isEmpty()) {
			int curr[] = st.pop();
			int r = curr[0];
			int c = curr[1];
			for(int i = 0; i <4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
				if(arr[nr][nc] == 0) {
					arr[nr][nc] = 2;
					st.push(new int[] {nr,nc});
				}
			}
		}
		Zero(arr);
	}


	// 바이러스 퍼지는 함수
	private static void bfs() {
		int[][] copy_map = new int[N][M]; // 복사본의 복사본
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(copy_map[i][j] == 2) { // 바이러스 좌표만 큐에 담음
					q.add(new int[] {i,j});
					
				}
			}
		}
		// 바이러스 번지는 현상
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int i = 0; i <4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				if(nr < 0 || nr > N-1 || nc < 0 || nc> M-1) continue;
			//  바이러스가 들어와 0이면 번진다(visited[]이 필요없다) 
			// 	이유: 0인데만 전염되기 때문에 0이 아니면 전염되지 않기 때문
				if(copy_map[nr][nc] == 0) { 
					copy_map[nr][nc] = 2;
					q.add(new int[]{nr,nc});
				}
					
			}
		}
		Zero(copy_map); // 바이러스가 퍼지고 그때 0의 겟수를 확인하는 함수
		
	}


	private static void Zero(int[][] copy_map) {
		int cnt = 0;
		for(int i = 0 ; i <N; i++) {
			for(int j = 0; j <M; j++) {
				if(copy_map[i][j] == 0) cnt++;
			}
		}
//		System.out.println("단계별"+cnt);
		answer = Math.max(cnt,answer);
	}
}
