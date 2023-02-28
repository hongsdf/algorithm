package Groom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/*
 * 
 * 
 * 다익스트라 한 지점에서 모든 지점까지의 최단 거리
 * 1. 방문하지 않는 지점중 거리값이 가장 작은 정점 방문
 * 2. 반문한 정점에 연결된 정점중, 아직 방문하지 않은 정점의 거리값을 갱신한다.
 * 다익스트라 시간복잡도 V소모, 총 V^2 을 반복
 * 우선순위큐을 이용한 힙 구조 사용
 * 
 */
class Adjancyies{
	 ArrayList<ArrayList<int[]>> list;
	
	 int n;
	
	public Adjancyies(int n){
		this.list = new ArrayList<ArrayList<int[]>>();
		
		for(int i = 0; i <n; i++){
			 this.list.add(new ArrayList<int[]>());
			
		}
		
		// 정렬 기준
		
		
	}
	
	// 연결 양방향
	public void addEdge(int a, int b, int dist){
		list.get(a).add(new int[]{b,dist});
		list.get(b).add(new int[]{a,dist});
	}
	
	// 리스트 하나를 가지고 오는 메서드
	public ArrayList<int[]> getList(int i){
		return this.list.get(i);
	}
	
	// 거리값만 가져오는 메서드
	public int getDist(int x,int y){
		ArrayList<int[]> list = this.list.get(x);
		// y 지점 찾기
		for(int i = 0; i<list.size(); i++){
			 int curr []= list.get(i);
			 if(curr[0] == y) {
				 return curr[1]; //거리 반환
			 }
		}
		return 0;
	}
	
	// 정렬
	
}


public class 이상한미로3 {
	public static int board[][] = new int[11][11];
	public static final int INF = 999999999;
	public static int d[];
	public static int N,M;
	public static boolean visit[];
	public static int Aj[];
	public static Adjancyies adj;
	public static int answer =-1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");
		 N = Integer.parseInt(str[0]);
		 M = Integer.parseInt(str[1]);
		String str1[] = br.readLine().split(" ");
		visit = new boolean[N+1];
		// board 초기화 과정
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j <=N; j++) {
				if(i == j) {
					board[i][j] = 0;
				}else {
					board[i][j] = INF;
				}
			}
		}
		d = new int[N+1];
		Aj = new int[str1.length+1];
		adj = new Adjancyies(N+1);
		for(int i = 1; i <=str1.length; i++){ // 각 지점에 대한 표시값 Aj
			Aj[i] = Integer.parseInt(str1[i-1]);
		}
		
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <M; i++) {
//			st = new StringTokenizer(br.readLine()," ");
			String str2[] = br.readLine().split(" ");
			int u = Integer.parseInt(str2[0]);
			int v = Integer.parseInt(str2[1]);
			int dist = Integer.parseInt(str2[2]);
//			board[u][v] = dist; // 두 지점을 연결 
//			board[v][u] = dist; // 두 지점을 연결
			adj.addEdge(u, v, dist);
			
			
		}
		// 다익스트라 실행
		dijk(1);
//		Arrays.sort(Aj);
//		int answer = 0;
//		answer = Aj[Aj.length-1];
		bw.write(answer +"\n");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	private static void dijk(int start) {
//		int pre = 0;
		// 다익스트라 생성
		// 1.priorityQueue<int[] q> ->  거리순으로 정렬 := 거리가 짧은것 부터 연결
		PriorityQueue<ArrayList<Integer>>q = new PriorityQueue<>();
		// 2.결과를 담을 배열을 최대값으로 초기화
		for (int i = 1; i <= N; i++) {
			d[i] = INF;
		}
		// 3.출발지점
////		Map<Integer,int[]> map = new HashMap<>();
//		map.put(board[1][0],new int[] {1,0});
		q.add(new ArrayList<>(Arrays.asList(board[1][0],1,0)));
//		d[start] = 0;
		
		while(!q.isEmpty()) {
			ArrayList<Integer> list = (ArrayList<Integer>) q.poll();
			int cd = 0; 
			int curr = 0; 
			int pre = 0;
			for(int i = 0; i <list.size(); i++) {
				if(i == 0) cd = list.get(0);
				else if(i == 1) curr = list.get(1);
				else pre = list.get(2);
				
			}

			if(cd > board[curr][pre]) continue; // 만약 그 지점을 방문했다면
			
			if(curr == N) {
				answer = cd;
				break;
			}
			
			int next = 0; int nd = 0;
			ArrayList<int[]> list2 = adj.getList(curr);
			for(int cur[] : list2) {
				next = cur[0];
				nd = cur[1];
				if(cd + nd >= board[next][curr % Aj[next]]) continue;
				if(curr != 1 && pre % Aj[curr] != next % Aj[curr]) {
					continue;
				}
				board[next][curr % Aj[next]] = cd + nd;
				q.add(new ArrayList<>(Arrays.asList(board[next][curr % Aj[next]],next,curr%Aj[next])));
				
			}
			
			
		}
	}

}
