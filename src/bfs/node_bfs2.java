package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class node_bfs2 {
	public static int N,E,cost;
	public static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 인접 리스트 구현방법
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		// 노드 갯수만큼의 행이 필요함
		for(int i = 1 ; i <= N; i++) {
			arr[i] = new ArrayList<Integer>(); // 배열의 한칸씩을 ArrayList로 구현
		}
		// 0  new ArrayList<>()
		// 1  new ArrayList<>()
		// 2  new ArrayList<>()
		
		
		for(int i = 0 ; i <E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			// 양방향 그래프
			arr[u].add(v); // u노드에 v노드를 연결
			arr[v].add(u);
		}

		Queue<Integer> q = new LinkedList<>();  // BFS를 위한 큐
		boolean[] visited = new boolean[N+1]; // 방문체크
		// 필요요소 ArrayList는 각 행별로 정보가 들어가 있다.
		int[] dist = new int[N+1];  // 거리정보
		// dist초기화
		Arrays.fill(dist,0);
		q.add(1); // q에 시작노드를 담는다
		visited[1] = true;
		dist[1] = 0; // 거리정보를 담는 배열 dist에 시작노드를 0으로 초기화 (왜냐면 자기자신과의 거리는 0)
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr+" ");
			for(int next : arr[curr]) {
				if(visited[next]) continue;
				q.add(next); // 연결된 노드를 담는다
				visited[next] = true;
				dist[next] = dist[curr] +1;
			}
					// 현재 노드와 연결된 노드들이 있다면(간선 정보에서 알수 있습니다)
		}
	}
     

   

     
}
