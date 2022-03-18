package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//네트워크 열결 문제 : 모든 컴퓨터를 최소 비용으로 연결
class Computer{
	int node[] = new int[2]; // 두대의 컴퓨터 번호
	int cost; // 연결 비용
	
	Computer(int a,int b, int cost) {
		this.node[0] = a;
		this.node[1] = b;
		this.cost = cost;
	}
	
}


public class Back1922 {
	public static int N; // 컴퓨터 수
	public static int M; // 간선 수
	public static int [] array; // 현재 컴퓨터 정보
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		PriorityQueue<Computer> q = new PriorityQueue<Computer>((a,b) -> (a.cost-b.cost));
		for(int i= 0 ; i < M; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			// 최소 신장트리는 거리가 짧은 순서대로 진행하여야 한다.
			q.add(new Computer(u,v,cost));
		}
		//현재 컴퓨터 마다 초기화
		array = new int[N+1];
		for(int i =1; i<=N; i++) {
			array[i] = i;
		}
		int sum = 0;
		while(!q.isEmpty()) {
			Computer curr = q.poll();
			int com1 = curr.node[0];
			int com2 = curr.node[1];
			int cost = curr.cost;
			// 현재 연결이 되어있지 않고 (싸이클 형성 x) :  여러개의 값이 들어와도 if문을 수행하면 연결되어서 중복 제거됨
			if(!Connect(array,com1,com2)) {
				// 컴퓨터를 연결한다
				union(array,com1,com2); 
				sum += cost;
			}
			
			
		}
		System.out.println(sum);
		
		
	}
	private static void union(int[] array, int com1, int com2) {
		com1 = getParent(array,com1);
		com2 = getParent(array,com2);
		if(com1 < com2) array[com2] = com1;
		else array[com1] = com2;
		
	}
	// 사이클이 형성 되지 않는 것을 판단 하려면 같은 부모를 가리키고 있어야 한다
	private static boolean Connect(int[] array, int com1, int com2) {
		com1 = getParent(array,com1);
		com2 = getParent(array,com2);
		if(com1 == com2) return true; // 같은 부모이면 이미 연결되어 있다.
		else {
			return false; // 연결이 되었지 않다.
		}
	}
	private static int getParent(int[] array, int x) {
		if(array[x] == x) return x;
		return array[x] = getParent(array, array[x] );
	}
}
