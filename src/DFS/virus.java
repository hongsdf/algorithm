package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class virus {
	public static int N,E;
	public static int arr[][];
	public static boolean[] visited;
	public static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		cnt = 0;
		for(int i =0; i <E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u][v] = arr[v][u] = 1;
		}
		dfs(1);
		System.out.println(cnt -1);
	}
	private static void dfs(int node) {
		if(visited[node]) return;
		
		visited[node] = true;
		cnt++; 
		
		for(int i =0; i <N+1; i++) { // arr[node].length  : 이것을 넣어야 한다
			if(!visited[i] && arr[node][i] !=0) {
				dfs(i);
			}
		}

		
	}
}
