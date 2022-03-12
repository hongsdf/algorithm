package djk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//출발지점부터 goal까지 연결비용찾기 
// 시간 복잡도 o(n * logn)
// 출발노드에서 다른 모든 노드를 연결할때 최단거리연결

// 다익스트라는 1차원배열을 이용 d[]
// d[] 는 출발 노드를 기준으로 다른 노드들과의 연결값을 먼저 초기화 한다
// 그리고 d[]를 선형탐색을 하며 가장 작은 값을 선택하며 중간지점으로 하나씩 선택하며 
// d[i] > d[중간지점] + arr[중간지점][i]
// (출발지점 -> 도착지점) > ((출발지점 -> 중간지점) + (중간지점 -> 도착지점))
 


public class pri_dijkstra3 {
	public static int N;
	public static int E;
	public static int arr[][];
	public static int d[];
	public static boolean visited[];
	public static int INF;
	public static int goal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 노드 갯수
		E = Integer.parseInt(st.nextToken()); // 간선 갯수
		goal = Integer.parseInt(st.nextToken()); // 목표지점

		arr = new int[N + 1][N + 1];
		d = new int[N + 1];
		visited = new boolean[N + 1];
		INF = 1000000;

		// arr 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					arr[i][j] = 0;
				else
					arr[i][j] = INF;
			}
		}
		// 간선수만큼 연결
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[v][u] = arr[u][v] = cost;

		}
		dijkstra(1, goal);
 
		// 출발지점부터 목표지점까지 최단 거리연결
		System.out.println(d[goal]);
		
	}

	private static void dijkstra(int start, int goal) {
		// <int[]>((a,b)) : int[] 배열에서 값 두개 int[] a, int[] b를 비교
		// 즉 a : int[] a , b : int b[]
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
		// 우선순위 장점
		// 동시에 여러수가 들어오면 우선순위기준에 따라 재배열한다(같은 레벨일때)
		// 인접배열을 사용한다 int[]
	
		
		for (int i = 1; i <= N; i++) {
			d[i] = INF;
		}
		q.add(new int[] { start, 0 });
		d[start] = 0; //출발 지점 자기자신과의 거리 초기화
		
		
		while (!q.isEmpty()) {
			int curr[] = q.poll();
			int idx = curr[0]; // 해당 지점
			// 목표지점을 찾으면 종료
			if (goal == idx)
				return; 
			
			
			if (visited[idx])
				continue;

			visited[idx] = true;

			for (int i = 1; i <= N; i++) {
				
					if (d[i] > d[idx] + arr[idx][i]) {
						
						// INF > INF + 3,4,5..
						
						d[i] = d[idx] + arr[idx][i];
						q.add(new int[] {i,d[i]}); //  출발지점보다 다음으로 작은 값
					}
				
			}

		}

	}
}
