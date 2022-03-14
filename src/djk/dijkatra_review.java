package djk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkatra_review {
	public static int N, E, start; // 노드 갯수, 간선갯수, 시작노드
	public static int board[][]; // 인접행렬 표기
	public static int d[]; // 출발 지점에서 모든 지점까지의 한번의 거리(다익스트라 핵심)
	public static boolean visited[]; // 노드 방문여부 체크
	public static int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];
		d = new int[N + 1];
		visited = new boolean[N + 1];
		// board 배열 초기화 최대값으로(최솟값을 찾기 위해)
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					board[i][j] = 0;
				else
					board[i][j] = INF;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken()); // u에서
			int v = Integer.parseInt(st.nextToken()); // v로
			int cost = Integer.parseInt(st.nextToken());
			// 단방향 그래프
			board[u][v] = cost;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		dijk(start); // 다익스트라실행

		for (int i = 1; i <= N; i++) {
			if (d[i] == INF)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		}

	}

	public static void dijk(int start) {
		// 동시에 q에 인큐가 되었다면 간선크기로 정렬한다
		// [0] : 노드번호 , [1] :간선크기
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1])); // [0] :노드 번호, [1] : 간선크기, 간선크기별로
		// d[] 배열 초기화 : 처음에는 모두 최대값으로 초기화하고 시작한다 명심
		for (int i = 1; i <= N; i++) {
			d[i] = INF;
		}
		q.offer(new int[] { start, 0 }); 
		d[start] = 0;  // 시작지점과 자기자신과의 거리 0

		while (!q.isEmpty()) {
			int curr[] = q.poll();
			int idx = curr[0];
			if (visited[idx]) continue;
			visited[idx] = true;
			for (int i = 1; i <= N; i++) { // 모든 지점이 연결되어있으면 갱신이 된다.
				// d[] : 시작지점에서 특정지점까지 바로 이동한 거리
				// d[i] : 시작노드에서 i지점까지 바로 이동한 거리
				// d[idx]:시작노드에서 중간지점(idx)까지 이동 + board[idx][i] : 중간지점에서 도착지점까지 거리
				if (d[i] > d[idx] + board[idx][i]) {
					d[i] = d[idx] + board[idx][i];
					q.offer(new int[] {i, d[i] });
				} 
			}
		}
	}
}
