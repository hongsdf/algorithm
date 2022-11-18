package Groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Adj{
	ArrayList<ArrayList<Integer>> adj;
	int n;
	Adj(int n){
		this.adj = new ArrayList<ArrayList<Integer>>();
		this.n = n;
		
		for(int i = 1; i <=n; i++) {
			this.adj.add(new ArrayList<Integer>());
		}
	}
	
	// 인접리시트 연결 
	public void addEdge(int n1, int n2) {
		this.adj.get(n1).add(n2);
		this.adj.get(n2).add(n1);
	}
	
	// 인접리스트 반환
	public ArrayList<Integer> getList(int i){
		return this.adj.get(i) ;
	}
}
public class Groom_cycle {
	
	static Adj m ; //인접리스트 
	static int visit[]; // 방문여부체크
	static int finded = -1;
	static List<Integer> cycle = new ArrayList<Integer>(); // 결과 순환 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		m = new Adj(N+1); // 0 0 0 0
		visit = new int[N+1];
		for(int i = 0; i<N+1; i++) {
			visit[i] = -1; // 초기화
		}
		
		for(int i = 0; i <N; i++) {
			String str[] = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			m.addEdge(a, b);
		}
		int start = 1;
		dfs(start,start);
		
		Collections.sort(cycle);
		for(int num : cycle) {
			System.out.print(num +" ");
		}
		
	}

	private static void dfs(int x,int pre) {
		if(visit[x] == 1) { // 방문했던 적이 있다면
			finded = x; // 이전 노드를 x로 갱신

			if(!cycle.contains(x)) {
				cycle.add(x);	
			}
			return;				
		}
		visit[x] = 1; //방문 표시
		
		// 시작점부터 연결된 탱크 탐색
		ArrayList<Integer> array = m.getList(x); // 해당 물탱크와 연결된 리스트 가져와서
		for(int i = 0; i <array.size(); i++) { // 해당 물탱크와 연결된 탱크 탐색
			int number = array.get(i);
			if(number == pre) { // 이전노드와 같다면 스킵
				continue;
			}
			
			dfs(number, x); // 방문한적 없고, 인접한 물탱크 재귀실행
		
			
			if(finded == -2) {
				return; // -2값이면 종료
			}
			
			if(finded == x) { // 방문했던 지점이라면 탐색정지 
				finded = -2; // 방문표시 
				return;
			}
			// 새롭게 발견한 순환사이클이라면
			if(finded >= 0) {
				for(int num : m.getList(x)) {
					cycle.add(num);
					return;
					}
	
				}
			}
			
	}
}
		
		
		
		
	

	

