package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class dfsre {
	public static int Max = 10;
	public static int board[][] = new int[Max][Max];
	public static boolean visited[] = new boolean[Max];
	static int N;
	static int E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()) ;
		E = Integer.parseInt(br.readLine()) ;
		for(int i =0; i <E; i++) {
			int u = Integer.parseInt(br.readLine());
			int v = Integer.parseInt(br.readLine());
			
			board[u][v] = board[v][u] = 1;
			
		}
		dfs(1);
	}
	private static void dfs(int start) {
		Stack<Integer> st = new Stack<>();
		st.push(start);
		
		while(!st.isEmpty()) {
			int curr = st.pop();
			if(visited[curr]) continue;
			visited[curr] = true;
			System.out.print(curr+" ");
			
			
			for(int i =0; i <N+1; i++) {
				if(!visited[i] && board[curr][i] != 0) {
					dfs(i);
				}
			}
		}
		
		
	}
}
