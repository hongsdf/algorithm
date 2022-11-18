package GraPhrithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS_recursive {
	static int arr[][];
	static Stack<Integer> stack = new Stack<>();
	static int visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visit = new int[N+1];
		
		for(int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		
		dfs(V,N);
	}

	private static void dfs(int start,int N) {
		// 목적 : 시작점과 연결된 모든노드를 탐색한다.
		
		// base-case: 모든 지점을 방문하면 종료
		if(visit[start] == 1) return;
		visit[start] = 1;
		System.out.println(start);
		for(int i = 1; i<=N; i++) {
			if(visit[i] != 1 && arr[start][i] == 1 && arr[i][start] == 1) {
				dfs(i,N);
			}
		}
		
		
	}
}
