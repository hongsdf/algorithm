package djk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pri_dijkstra {
	public static int N,E,goal;
	public static int board[][];
	public static int di[];
	public static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		di = new int[N];
		for(int i=0; i <N; i++) {
			for(int j =0; j<N; j++) {
				if(i ==j ) board[i][j] = 0;
				else board[i][j] = INF;
			}
		}
		
		// 간선 정보 삽입 필요한 부분만 board[][]를 재정의 한다
		for(int i =0; i <E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			board[u][v] = board[v][u] = cost;
			
		}
		// 출발지점부터 goal까지 연결비용찾기
		dijkstra(0,goal);
		
//		for(int i=0; i <N; i++) {
//			System.out.print(di[i] + " ");
//		}
		System.out.println(di[goal]);
	}

	private static void dijkstra(int start,int goal) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[N];
		PriorityQueue<int []> q = new PriorityQueue<int[]>((a,b) -> (a[1] - b[1]));
		// 우선순위 큐 정렬 생성
	    //[0] : cost비용
		// d[i] 초기화
		for(int i=0; i <N; i++) {
			di[i] = INF;
		}
		q.add(new int[] {start,0});
		di[start] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); // q에 여러개가 인큐 되엇을때 curr[0 == cost]가 작은 순서가 먼저 디큐된다.
			// 최단거리연결방법은 : 최소비용들로만 연결하면 된다라는 정의
			int idx = curr[0];
			// 목표지점을 찾으면 바로 종료
			if(idx == goal) return;
			if(visited[idx]) continue;
			
			visited[idx] = true;
			
			for(int j =0; j <N; j++) {
				if(di[j] > di[idx] + board[idx][j]) {    
					di[j] = di[idx] + board[idx][j];
					q.add(new int[] {j,di[j]}); // 찾은지점의 연결노드 
				}
			}
			
		}
	}
}
