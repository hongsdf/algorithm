package GraPhrithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backMIRROR {
	public static int N;
	public static int M;
	public static int board[][];
	public static boolean visit[][];
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j)-'0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					bfs(i, j); // ½ÃÀÛÁ¡
				}
			}
		}
		System.out.println(board[N - 1][M - 1]);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int curr[] = q.poll();
			int x = curr[0];
			int y = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];

				if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1)
					continue;
				if (!visit[nr][nc] && board[nr][nc] == 1) {
					visit[nr][nc] = true;
					q.add(new int[] { nr, nc });
					board[nr][nc] = board[x][y] + 1;
				}

			}
		}

	}

}
