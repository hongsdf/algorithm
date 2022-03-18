package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class village{
	int node[] = new int[2]; // 두마을 의 정보를 담는 배열
	int cost; // 연결 거리
	
	village(int a, int b, int cost) {
		this.node[0] = a; // 출발 마을
		this.node[1] = b; // 도착 마을
		this.cost = cost; // 마을 간 거리
	}
	
}


public class back1647 {
	public static int N; // 마을 수
	public static int M; // 마을 간 거리 수
	
	public static int array[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 거리가 가까운 순서로 정렬
		PriorityQueue<village> q = new PriorityQueue<village>((a,b)->(a.cost - b.cost));
		
		for(int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			q.add(new village(u,v,cost));
		}
		// 마을 초기화 
		array = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = i;
		}
		int sum = 0;
		int max = -1; // 마을 간선간의 최대 거리를 찾기
		// 두 마을로 분리를 하기위해선 최소 연결망에서 *하나의 길만 끊어도* 두개의 마을로 분리된다 
		// 그러면 최대 간선크기를 끊어서 두개의 마을로 만드는 것이 가장 최소 비용이 된다 
		// 이유? :분
		// 최소 연결망으로 마을을 연결했으면 모든 마을이 최소 비용으로 연결 되어있을 것이다.
		// 거기서 최대 간선을 하나만 자르면 2개의 마을로 분리가 될뿐이지 *분리 안에서는 아직도 연결이 유지가 되어있다.*
		while(!q.isEmpty()) {
			village curr = q.poll();
			int v = curr.node[0];
			int u = curr.node[1] ;
			int cost = curr.cost;
			// 두마을이 연결이 되어있지 않으면 
			if(!Connect(array,v,u)) {
				// 연결한다
				 union(array,u,v);
				  sum += cost;
				  max = Math.max(max, cost); // 최대 간선크기 찾기
			}
		}
		System.out.println(sum - max);
		
	}
	private static void union(int[] array, int u, int v) {
		u = getParent(array,u);
		v = getParent(array,v);
		if(u < v) array[v] = u;
		else array[u] = v;
		
	}
	private static boolean Connect(int[] array, int v, int u) {
		v = getParent(array,v);
		u = getParent(array,u);
		if(v == u) return true; //연결o
		return false; // 연결 x
	}
	private static int getParent(int[] array, int v) {
		if(array[v] == v ) return v;
		return array[v] = getParent(array, array[v]);
	}
}
