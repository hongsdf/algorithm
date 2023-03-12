package Groom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Adjancy{
	 ArrayList<ArrayList<int[]>> list;
	
	 int n;
	
	public Adjancy(int n){
		this.list = new ArrayList<ArrayList<int[]>>();
		
		for(int i = 0; i <n; i++){
			 this.list.add(new ArrayList<int[]>());
			
		}
		
		// 정렬 기준
		
		
	}
	
	// 연결 양방향
	public void addEdge(int start, int[] val){
		list.get(start).add(new int[]{val[0],val[1]});
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



public class 이상한미로2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		
		boolean visit[] = new boolean[N+1];
		int answer = 0; // 정답
		// Aj[]배열입력
		int Aj[] = new int[str1.length];
		for(int i = 0; i <str1.length; i++){ // 각 지점에 대한 표시값 Aj
			Aj[i] = Integer.parseInt(str1[i]);
		}
		int arr[] = new int[N+1];
		Adjancy1 Adjancy1 = new Adjancy1(N+1); // 1-base
		for(int i = 0; i <M; i++){
			 	String str2[] = br.readLine().split(" ");
				int start = Integer.parseInt(str2[0]) ; // 출발지
				int end =  Integer.parseInt(str2[1]); //도착지
			    int dist = Integer.parseInt(str2[2]) ; // 사이 거리
			   //인접리스트 연결
		  
			  Adjancy1.addEdge(start,new int[]{end,dist});
			  Adjancy1.addEdge(end,new int[]{start,dist});
			
						
		}
		// ?
		
		
		// 구현
		// 1번 방부터 출발 , 도착방 : N
		LinkedList<Integer> q = new LinkedList<Integer>();
		
// 		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<>(){
// 			Adjancy1.getList
			
// 			public int compare(int a, int b){
// 				return a[1] - b[1];
// 			}
// 		}); // 거리에 대한 우선순위 정렬
		// LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true; // 출발지점 체크

		boolean flag = false;
		int pre = 0; // 이전 지점
		// bfs 구현 : 최당 연결
		while(!q.isEmpty()){
			 int curr = q.poll();
			 
			 if(curr == N) break; // 도착지점에 도착
			 
			 //  거리가 짧은 것순 -> 거리에 대한 우선순위 큐
			 List<int[]> list = Adjancy1.getList(curr);
			 // 정렬
			 Collections.sort(list,new Comparator<int[]>(){
				 	public int compare(int [] a, int b[]){
						return a[1] - b[1];
					}
			 });
			if(!flag) {
				// 두번째 지점
				
					// 맞는 값이 있다면 => 연결이 된것
					// 조건 확인
					int targeting[] = list.get(0);
					int target = targeting[0];
					visit[target] = true;
					q.add(target);
					pre = curr;
					answer += Adjancy1.getDist(curr,target);// 지점 모든 연결값
					flag = true;
					
					
				
				
			}
			// 3번재 지점부터
			else {
				for(int i = 0; i <list.size(); i++){ // 연결 지점을 모두 순회
					// 맞는 값이 있다면 => 연결이 된것
					// 조건 확인
					int targeting[] = list.get(i);
					int target = targeting[0];
					
					if(!visit[target] && pre%Aj[curr-1] == target%Aj[curr-1]){ //조건에 맞은 성립
						visit[target] = true; //지점 연결 됨
						q.add(target);
						pre = curr;
						answer += Adjancy1.getDist(curr,target);// 지점 모든 연결값
						break;
					}
				}
				
			}
				
			}
		if(!visit[N]) { // 도착지점에 도달하지 못했다면
			answer = -1;
		}
		bw.write(answer+"\n");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
