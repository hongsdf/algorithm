package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs01 {

	public static int N;
	public static int M;
	public static int START;
//	public static int Max = 10;
	
//	public static int board[][] = new int[Max][Max];
	public static int board[][];
	public static boolean visited[];
	public static Queue<Integer> q = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		START = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1] ;
		visited = new boolean[N+1];
		
		for(int i=0; i <M; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 board[u][v] = board[v][u] = 1;
			 
		}
		bfs(START);
		System.out.println(sb);
		
//		5 5 1
//		1 4
//		1 2
//		2 3
//		2 4
//		3 4
		
	}

	private static void bfs(int START) {
//		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(START); // 1
		
		while(!q.isEmpty()) { //      
			 int curr = q.poll(); 
			 
			 if(visited[curr]) continue;
			 visited[curr] = true;  // 1 2 4 3
//			 System.out.println(curr+" ");  // 1 2 4 3
			 
			 
			 sb.append(curr+"\n");
			 
			 for(int i =1; i<N+1; i++) {
				 
				 
				
				 if(!visited[i] && board[curr][i] != 0) { 
					 
					 q.add(i); 
					
				 }
				 // 여기 안에다 같이 할수 있을까?
				
				  
			 }
			 
			
	
		}
		// 반복문이 두번 된다
		for(int i =1; i <N+1; i++) {
			if(!visited[i]) {
				 sb.append(0+"\n");
			}
		}
		
	}
}
