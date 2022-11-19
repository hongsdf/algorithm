package Groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Cycle2 {
	static int N; // 전체노드,간선갯수
	static int arr[][];
	static Adj adj; 
	static int visit[]; //방문체크
	static List<Integer> cycle_List = new ArrayList<Integer>(); //사이클 리스트
	static int find = -1; // 방금전 방문여부  find변수는 공급탱크와 방문여부를 확인하기 위한 변수
	
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visit = new int[N+1];
		adj = new Adj(N+1);
		
		
		for(int i = 0; i<N; i++) {
			String str[] = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			arr[a][b] = arr[b][a] = 1;
			adj.addEdge(a, b);
		}
		// 시작물탱크 -2
//		visit[1] = -2;
//		stack.push(1);
		dfs(1,1); // 출발지점, 이전지점
		Collections.sort(cycle_List);
		System.out.println(cycle_List.size());
		for(int num: cycle_List) {
			System.out.print(num+" ");
		}
		
	}
	private static void dfs(int u, int tar) {
		if(visit[u] == 1) { // 해당지점 u 을 방문한적이 있다면
			find = u; // 이전지점을 u로 바꿔놓는다.
			if(!cycle_List.contains(u)) {
				cycle_List.add(u);
			}
			return; // base-case : 이전에 방문했던 곳이라면 
		}
		
		visit[u] = 1; // 방문체크
		
		//u와 연결된지점 탐색
		
		ArrayList<Integer> adjList = adj.getList(u);
		for(int i = 0; i <adjList.size(); i++) {
			int x = adjList.get(i);
			if(x == tar) {
				continue;
			}
			dfs(x,u);
			if(find == -2) { //공급 지점이면
				return;
			}
			if(find == u) { // 현재지점의 다음지점이 이전지점이라면
				find = -2;
				return;
			}
			if(find >= 0) {
				if(!cycle_List.contains(u)) {
					cycle_List.add(u);
				}
				return;
			}
		}
		
		
		
//		for(int i = 1; i<=N; i++) {
//			if(arr[u][i] == 1 && arr[i][u] == 1) { // 현재 지점과 연결된 지점이면
//				if(i == tar) { 
//					continue;
//				}
//				dfs(i,u);
//				if(find == -2) { //공급 지점이면
//					return;
//				}
//				if(find == u) { // 현재지점의 다음지점이 이전지점이라면
//					find = -2;
//					return;
//				}
//				if(find >= 0) {
//					if(!cycle_List.contains(u)) {
//						cycle_List.add(u);
//					}
//					return;
//				}
//			}
//		}
		
	}
}
