package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bfs2 {
	public static int Max = 100001;
	public static int N,E;
	public static int board[][] = new int[Max][Max];
	public static boolean visited[] = new boolean[Max];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for(int i =0; i <E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int v = Integer.parseInt(st.nextToken());
		    int u = Integer.parseInt(st.nextToken());
		    board[v][u] = board[u][v] = 1;
		}
		bfs(0);
		
//		N,E
		
				
	}

	private static void bfs(int node) {
		// 시작 노드와 가까운 지점 부터 탐색
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(node);
		
	
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(visited[curr]) continue;
			
			visited[curr] = true;
			System.out.print(curr + " ");
			
			for(int i =0; i <N; i++) {
				if(!visited[i] && board[curr][i] != 0 ) {
					q.add(i);
				}
			}
			// 0 1 2 3 4 5 6
		}
		
	}
}
