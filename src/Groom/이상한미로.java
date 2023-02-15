package Groom;

import java.io.*;
import java.util.PriorityQueue;
public class 이상한미로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 최단 경로를 찾는 문제
		// 조건이 존재
		// i->j->k로 이동시 
		// i%Aj == k%Aj가 같아야 이동할수 있다.
		// N의 크기가 100,000이다 => 인접 리스트로 구현해야 겠다.
		// w : 시간을 의미 10 ^ 9을 봐서는 long타입으로 반환
		
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		String str1[] = br.readLine().split(" ");
		// Aj[]배열입력
		int Aj[] = new int[str1.length];
		for(int i = 0; i <str.length; i++){ // 각 지점에 대한 표시값 Aj
			Aj[i] = Integer.parseInt(str[i]);
		}
		Adj adj = new Adj(N+1); // 1-base
		for(int i = 0; i <M; i++){
			 String str2[] = br.readLine().split(" ");
				int start = Integer.parseInt(str2[0]); // 출발지
				int end = Integer.parseInt(str2[1]); //도착지
			    int dist = Integer.parseInt(str2[2]); // 사이 거리
			   //인접리스트 연결
			   adj.get(start).add(new int[]{end,dist});  // 1 : [2,5] 
		}
		// 구현
		// 1번 방부터 출발 , 도착방 : N
		PriorityQueue<Adj> pq = new LinkedList<Adj>((a,b) -> a.dist-b.dist); // 거리에 대한 우선순위 정렬
		// LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		
		// bfs 구현 : 최당 연결
		while(!q,isEmpty()){
				int curr = q.poll();
			 //  거리가 짧은 것순 -> 거리에 대한 우선순위 큐
			 List<int[]> list = adj.get(curr).getList();
			for(int i = 0; i <list.size(); i++){ // 연결 지점을 모두 순회
				 // 맞는 값이 있다면 => 연결이 된것
				 // 조건 확인
				 if(curr%Aj[curr] == list.get(i)%Aj[list.get(i)]){ //조건에 맞은 성립
					 
				 }
			}
			
		}
		
		
	}
}