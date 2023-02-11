package Groom;

import java.io.*;
import java.util.*;


class Adjency{
	ArrayList<ArrayList<Integer>> AdjencyList;
	int n;
	public Adjency(int n){
		this.AdjencyList = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <n; i++){
				this.AdjencyList.add(new ArrayList<Integer>());
		}
	}
	
	// 단방향 연결
	public void addEdge(int a, int b){
		this.AdjencyList.get(a).add(b);
		// this.AdjencyList.get(b).add(a); // 양방향
		
	}
	
	// 한행 리턴
	public ArrayList<Integer> getList(int i){
		return this.AdjencyList.get(i);
	}
	
}


public class 구름이의여행2 {
	 // 백준 : 10451번 풀기
	public static int visit[];
	public static boolean visit2[];
	public static boolean cycle[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); //섬 수
		int M = Integer.parseInt(input[1]); // 다리 수
		int K = Integer.parseInt(input[2]); // 출발섬
		int answer = 0;
		
		//N := 10000이므로 2차원 배열을 생성하면 안된다.
		//인접 리스트로 구현
		Adjency adjency = new Adjency(N+1);
		visit = new int[N+1]; // 관리 i번째까지 걸리는 최소 섬의 갯수
		visit2 = new boolean[N+1];
		// 최소 조건이므로 dfs보다 bfs로 구현
		// 탐색종료 조건 섬이 k일때
		
		
		cycle = new boolean[N+1];
		int arr[] = new int[N+1]; // 자기 자신을 가리키는 지점
		for(int i = 1; i <=N; i++){
			 arr[i] = i;
		}
		
		
		for(int i = 0; i<M; i++){
			 String command[] = br.readLine().split(" ");
			 int start = Integer.parseInt(command[0]);
			 int end = Integer.parseInt(command[1]);
			 adjency.addEdge(start,end);
			 
//			  Union(start,end,arr);
			// 1: 2,4
			// 2:
			// 3: 1
			// 4: 2,5
			// 5: 3
		}
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(K); // k지점으로 부터 가 되돌아 올수 잇는 없는지 확인 
		
		while(!q.isEmpty()){
			 int curr = q.poll();
		
			 ArrayList<Integer> list = adjency.getList(curr); // 연결된 지점
			 for(int target: list){
				 if(!visit2[target]) { // 연결된 지점을 방문했던 적이 없다면
					 visit2[target] = true; // 방문 표시
					 q.add(target); // 다음 지점 부터 탐색
					 // visit[target] = visit[curr] + 1;
				 }
				 
				 if(K == target) break;
				 
			 }
			
		}
		
		
//		// k로 되돌아올수있는 최단거리이므로 q를 구현하엿다.
//		LinkedList<Integer> q = new LinkedList<>();
//	
//		q.add(K);
//		
//		while(!q.isEmpty()) { // 모든 지점을 탐색을 하면 종료한다.
//			int curr = q.poll();
//			ArrayList<Integer> list = adjency.getList(curr);
//			for(int a : list) {
//				if(visit[a] == 0) {
//					visit[a] = visit[curr] + 1;
//					q.add(a);
//				}
//				if(a == K) break;
//					
//			}
//			
//			
//		}
	
		System.out.println(visit2[K] == true? true:false);

		// 사이클을 찾아야한다.
		
		// 그래프를 순환하다 자시자신을 발견하면 사이클

	}
//	
	
	public static boolean isSame(int arr[],int a, int b){
		a = getParent(arr,a);
		b = getParent(arr,b);
		if(a == b) return true;
		else return false;
	}
	 
	public static int getParent(int arr[],int x){
		if(arr[x] == x) return x;
		return arr[x] = getParent(arr,arr[x]);
	}
	
	public static void Union(int a, int b,int arr[]){
		a = getParent(arr,a);
		b = getParent(arr,b);
		if( a < b) arr[b] = a;
		else arr[a] = b;
		
	}
	
	
	
}