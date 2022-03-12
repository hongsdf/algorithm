package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;



public class REdfs {
	public static int Max = 10;
	public static int N;
	public static int E;
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
		dfs(0);
	}

	private static void dfs(int node) {
//		LinkedList<Integer> q = new LinkedList<>();
//		q.add(node);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(node);
		
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			
			if(visited[curr]) continue;
			
			visited[curr] = true;
			System.out.print(curr + " ");
			
			for(int i =0; i <N; i++) {
				if(!visited[i] && board[curr][i] !=0 ) {
					// 두개가 다른 결과
					dfs(i); // 재귀로 구현하는 방법 
//					stack.push(i); // output : 0 2 6 5 1 4 3 
				}
			}
//			0 1 0 2 1 3 1 4 2 5 2 6
			
		}
		
	}
}
