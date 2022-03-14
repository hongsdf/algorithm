package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class node_re {
	public static int N,E;
	public static int board[][];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i <E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u][v] = board[v][u] = 1;
			
		}
		dfs(1);
		
		
	}

	private static void dfs(int start) {
		visited[start] = true; 
		System.out.print(start+" ");
		for(int i = 1; i <=N; i++) {
			if(!visited[i] && board[start][i] !=0) {
				dfs(i);
			}
		}
		
	}
}
