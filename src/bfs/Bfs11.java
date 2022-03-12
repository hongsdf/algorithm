package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// 특징 : 가까운(시작기준( 노드 )을 기준으로) 인접데이터(노드) 부터 탐색 한다.
public class Bfs11 {
	public static int Max = 100001; // 문제의 요구 에 맞는 사이즈 설정을 하고 들어간다.
	public static boolean visited[] = new boolean[Max]; //BFS/DFS탐색은 반드시 boolean[] 배열 생성 :  여기선 노드를 탐색했다는 뜻
	public static int board[][] = new int[Max][Max]; //2d 배열로 선언(간선을 서로 이어주기 위해)
	static int N; //노드 갯수
	static int E; //간선 갯수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		for(int i =0; i<E; i++) { // 간선을 연결해주는 작업
			int u = Integer.parseInt(br.readLine());
			int v = Integer.parseInt(br.readLine());
			board[u][v] = board[v][u] = 1;
		}
		bfs(0); // 시작 노드 
		
	}
	private static void bfs(int start) { //먼저온것이 먼저 나간다. queue로 구현
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll(); //현재 노드 를 꺼내서
			if(visited[curr]) continue ; //방문 하지 않으면 체크
			visited[curr] = true;
			System.out.println(curr+" "); // 현재 노드 출력
			
			for(int i =0; i<N+1; i++ ) { // 방문하지 않았고 현재노드와 연결되어있으면 q에 추가하여 실행
				if(!visited[i] && board[curr][i] != 0) {
					q.add(i);
				}
			}
			// 여기까지 오면 탐색 끝
			
		}
	}
}
