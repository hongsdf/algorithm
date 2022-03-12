package djk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class djk3{
	public static int N,E;
	public static int[][] board;
	public static int distance[];
	public static int INF = 987654321;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1];
		distance = new int[N+1];
		
		// board초기화 자기자신과의 cost는 0, 자신외 다른 노드는 최대치로 초기화
		for(int i =0; i<N; i++) {
			for(int j =0; j <N; j++) {
				if(i==j) board[i][j] = 0;
				else board[i][j] = INF;
			}
		}
		// 6 9
//		0 1 50
//		0 2 30
//		1 3 30
//		1 4 70
//		2 3 20
//		2 4 40
//		3 4 10
//		3 5 80
//		4 5 30
//		
		
		// 초기화된 board[][] 배열에서 연결해 주는 부분에만 cost비용 
		// 연결되지 않는 부분은 여전히 INF
		for(int i =0; i <E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			board[u][v] = board[v][u] = cost;
		}
		dijkstar(0);
		for(int i =0;i<N; i++) {
			System.out.print(distance[i]+" ");
		}
	}



	private static void dijkstar(int start) {
		// [0] : cost, [1] : 노드 index
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) ->( a[0] - b[0]));// 람다식 표현 : cost가 짧은 것이 우선순위로 디큐
		q.offer(new int[] {0,start}); // start가 0,1,2.. 이든 자기자신에 대해 cost : 0
		for (int i =0 ; i <N; i++ ) {
			distance[i] = INF; // 출발지점으로 모든지점을 연결하엿을때 담은 배열 초기화
		}
		//[0,start] 의미 : start가 0이라면 start지점에서 자기자신 거리는 0 
		boolean visited[] = new boolean[N+1];
		distance[start] = 0; // 시작 점은 0으로 초기화
		 
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int a = curr[1]; // curr[1] 이 의미 : 
			// 출발지점에 들어온 index 디큐
			
			if(visited[a]) continue;
			
			visited[a] = true; // 방문 여부 체크
			
			for(int j =0; j <N; j++) {
				// distance[j] :이제 출발지점에서 각 지점까지 거리를 구할건데
				// j를 돌려 하나씩 구한다 
				// distance[a] + board[a][j] : 이때 출발지점 a를 거쳐 이어진 것이 더 작으면 갱신한다
				// distance[a] + board[a][j]
				if(distance[j] > distance[a] + board[a][j]) {
					distance[j] = distance[a] + board[a][j];
					q.offer(new int[] {distance[j], j } );
					// q에 쌓이는 것은 해당 노드의 인점 노드만 수행된다
					// 이유 : distance[2] == INF다
					
					// 먼저 1지점 
					// distance[1] == INF > distance[a] :출발 지점을 거쳐 + board[a][1] 이 연결되어있다면
					// 큐에 인큐
					// 연결되어 있지 않으면
					// distance[1] == INF > distance[a] + board[a][1] == INF 다
					// 그러므로 INF > distance[a] + INF 갱신이 안된다
					
				}
				
			}
		}
		
		
	}
}
