package GraPhrithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4
public class DFS_BFS {
	static Adj adj;
	static Queue<Integer> q = new LinkedList<>();//넓이 우선 탐색BFS
	static Stack<Integer> st = new Stack<>();//깊이 우선 탐색DFS
	static int visit[];
	// 방법2 인접행렬
	static int arr[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str [] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); //노드 갯수
		int M = Integer.parseInt(str[1]); //간선 갯수
		int start = Integer.parseInt(str[2]); // 탐색을 시작할 번호
		adj = new Adj(N+1); // 인접리스트 생성 base-start: 1
		visit = new int[N+1];
		
		arr = new int[N+1][N+1] ;
		
		
		for(int i = 0; i <M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// adj.addEdge(a, b);
			
			arr[a][b] = arr[b][a] = 1; //양방향 연결
			
			
		}
		
		st.push(start);
		dfs(N);
		for(int i = 1; i <N+1; i++) {
			visit[i] = 0;
		}
		System.out.println();
		q.add(start);
		bfs(N);
//		4 5 1
//		1 2
//		1 3
//		1 4
//		2 4
//		3 4
		
	}
	private static void bfs(int N) {
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(visit[curr] == 1) continue; //방문했던 지점이라면
			visit[curr] = 1;
			System.out.print(curr+" ");
			
			
			for(int i = 1; i <= N; i++ ) {
				if(visit[i] != 1 && arr[curr][i] == 1 && arr[i][curr] == 1) {
					q.add(i);
				}
			}
			
		}
		
	}
/*
	private static void dfs() {
		while(!st.isEmpty()) {
		int curr = st.pop();
		if(visit[curr] == 1) continue;
		visit[curr] = 1;
		System.out.print(curr+" ");
		
		ArrayList<Integer> arr = adj.getList(curr); // 연결리스트와 연결된 행 가져오기
		for(int i = 0; i <arr.size(); i++) {
			int num = arr.get(i);
			st.push(num);
		}
		
		}
		
	}
	*/

	private static void dfs(int N) { // N:전체 사이즈
		while(!st.isEmpty()) {
			int curr = st.pop();
			if(visit[curr] == 1) continue; //방문했던 지점이면
			visit[curr] = 1; // 방문체크
			System.out.print(curr + " ");
			for(int i = N; i>=1; i--) {
				if(visit[i] != 1 && arr[curr][i] == 1 && arr[i][curr] == 1) { // 방문하지 않았고, 현재지점이랑 연결되어 있는 지점이라면
					st.push(i);
				}
			}
		}
		
	}
	
	// 작은 번호순으로 dfs구현
	
}
