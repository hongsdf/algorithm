package DFS;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFS_st {
	public static int N,E;
	public static int size =10;
	public static int arr[][] = new int[size][size];
	
	
	
	
	public static void dfs(int node) {
		boolean visited[] = new boolean[10];
		
		Stack<Integer> st = new Stack<>();
		st.push(node);
		
		while(!st.isEmpty()) {
			int curr = st.pop();
			if(visited[curr]) continue;
			//         0 1   
			// 0 2 4 3 1
			visited[curr] = true;
			System.out.print(curr);
			for(int i =0; i <N; i++) {
				if(!visited[i] && arr[curr][i] != 0) {
					st.push(i); // 돌아가는 것이 아님
				}
			}
			
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		for(int i=0; i<E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u][v] = arr[v][u] = 1;
		}
		dfs(0);
		
		
		
		
		
		
		
		sc.close();
	}
	

}
