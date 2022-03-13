package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상,하,좌,우 이동하는 방법말고 

// 새로운 이동 방식 적용
// 킹을 잡는 최소 횟수

public class Knight {
	static class knight {
		int x, y, dist;

		public knight(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	// 체스판
	public static int R;
	public static int C;

	public static char[][] chess;
	public static boolean[][] visited;

	private static final char KNIGHT_START = 'S'; // 시작 위치
	private static final char KNIGHT_BLOCK = 'X'; // 못가는 지역
	private static final char KNIGHT_END = 'E'; // 킹위치

	public static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chess = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine(); // SXOOO 1행
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j); // SXOOO에서 움직이는 포인터 S,X ,O, O, O
				chess[i][j] = c;
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (chess[i][j] == KNIGHT_START) {
					bfs(i, j);

				}
			}
		}

	}

	private static void bfs(int r, int c) {
		Queue<knight> q = new LinkedList<>();
		int dist = 1;
		q.add(new knight(r, c, dist));
		while (!q.isEmpty()) {
			knight curr = q.poll();
			int row = curr.x; //현재말의 좌표
			int col = curr.x; //현재말의 좌표
			dist = curr.dist; // 현재말이 이동한 횟수(처음 들어오면 1,
			// q에 쌓였던게 디큐되면 그시점이 dist +1

			// 현재 좌표 방문여부 체크
			if(visited[row][col]) continue;
			visited[row][col] = true;

//			 
			for (int i = 0; i < 8; i++) {
				int nr = row + dx[i];
				int nc = col + dy[i];

				// 범위 체크, 벽확인
				if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || chess[nr][nc] == KNIGHT_BLOCK) continue;
				// 방문여부 확인, 벽 확인

				// 왕을 잡은 경우
				if (chess[nr][nc] == KNIGHT_END) {
					System.out.println(dist);
					return;
				}
				
				if(!visited[nr][nc]) { 
					q.add(new knight(nr, nc, dist+1)); // 새로운 좌표를 추가

				}

			}

		}
		// 발견하지 못하면
		System.out.println(-1);

	}
}
