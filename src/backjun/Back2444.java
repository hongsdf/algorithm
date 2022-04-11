package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Back2444 {
	public static int Max = 10;
	public static int board[][] = new int[Max][Max];
	public static int N;
	public static int M;
	public static int START;
    public static boolean visited[];
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		START = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][N+1];
        visited = new boolean[N+1];
        
		for(int i=0; i <M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 board[u][v] = board[v][u] = 1;
			 
		}
		bfs(START);
		
        for(int i = 1; i <= N; i++ ){
            if(!visited[i]){
                System.out.println(0);
            }
        }
		
	}
	private static void bfs(int Start) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(Start);
		visited[Start] = true;
        
		while(!q.isEmpty()) {
			int curr = q.poll();
            
            System.out.println(curr);
            
            for(int i = 1; i<=N; i++){
               if(!visited[i] && board[curr][i] == 1){
                   q.add(i);
                   visited[i] = true;
                  
               }
            }
  
        }
   
	}
}