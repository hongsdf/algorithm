package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class node_bfs {
	public static int N,E,cost;
	public static int[][]board;
	public static boolean[]visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		board = new int[N+1][N+1];
		visited = new boolean[N+1];
			
		// 인접 행렬구현
		for(int i =0; i <E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u][v] = board[v][u] = Integer.parseInt(st.nextToken());
		}
		// 노드 탐색 알고리즘
		bfs(1);
		
		
	}



	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start); // 시작 노드 삽입
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(visited[curr]) continue;
			visited[curr] = true;
			System.out.print(curr+" ");
			for(int i = 1; i <=N; i++) {
				if(!visited[i] && board[curr][i] != 0) {
					q.offer(i);
				}
			}
			
		}
		
	}
}
