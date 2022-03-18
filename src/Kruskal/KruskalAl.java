package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 사용예제: 각 도시의 모든 지점을 연결하기 위한 최소 비용,거리
// 크루스칼 알고리즘은 union find 를 기반으로 구현 한다.
// 주의점 사이클이 형성되지않은 것만 선에서 연결한다.
// 거리가 짧은 순서대로 연결을 한다.
class Edge{
	int node[] = new int[2];
	int cost ;
	
	public Edge(int a, int b, int cost) {
		this.node[0] = a;
		this.node[1] = b;
		this.cost = cost;
	}
}


public class KruskalAl {
	public static int N ; // 노드수
	public static int E; // 간선 갯수
	public static int [][]board; // 인접 행렬
	
	public static int []array; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 N = Integer.parseInt(st.nextToken()); 
		 E = Integer.parseInt(st.nextToken()) ;
		 // 비용이 정렬
		PriorityQueue<Edge> q = new PriorityQueue<Edge>((a,b) ->(a.cost - b.cost));
		 
		for(int i = 0; i <E; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int u = Integer.parseInt(st.nextToken()); 
			 int v = Integer.parseInt(st.nextToken()) ;
			 int distance = Integer.parseInt(st.nextToken()) ;
			 q.add(new Edge(v,u,distance));
		}
		array = new int[N+1] ;
		// array 초기화
		for(int i =1; i<=N; i++) {
			array[i] = i;
		}
		int sum = 0;
		while(!q.isEmpty()) {
			Edge curr = q.poll();
			int start = curr.node[0];
			int end = curr.node[1];
			int cost = curr.cost;
			if(!SameFind(array,start,end)) { //같은 부모가 아니여야지만 연결(사이클 형성이 되지 않는 경우만 실행 )
				union(array,start,end);
				sum += cost;
			}
		}
		System.out.println(sum);
		
		
	}
	// 합치기
	private static void union(int[] array, int a, int b) {
		a = getParent(array, a);
		b = getParent(array, b);
		if(a < b) array[b] = a;
		else array[a] = b;
		
	}
	private static boolean SameFind(int[] array, int a, int b) {
		a = getParent( array, a);
		b = getParent( array, b);
		if(a == b) return true;
		else {
			return false ;
		}
	}
	// 부모 찾기
	private static int getParent(int[] array, int a) {
		if(array[a] == a) return a;
		return array[a] = getParent(array,array[a]);
	}
	
	
	
}
