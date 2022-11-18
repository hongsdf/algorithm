package GraPhrithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// 강한 결합요소




public class SCC {
	static int d[]; // 각 노드별 부모노드를 인지할 지점
	static Stack<Integer> st; // dfs 스택생성
	static int v; // 노드 갯수
	static Adj m ; // 인접리스트 생성
	static Adj result = new Adj(5); //결과 인접
	static int index = 0; //인덱스 번호
	
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v =	Integer.parseInt(br.readLine()) ;
		visit = new boolean[v+1];
		d = new int[v+1];
		st = new Stack<Integer>();
		m = new Adj(v+1);
		// Adj m = new Adj(v+1);
		for(int i = 0; i <v; i++) {
			String str[] = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			m.addEdge(a, b);
		}
//		m.addEdge(1, 2);
//		m.addEdge(2, 3);
//		m.addEdge(3, 1);
//		m.addEdge(4, 2);
//		m.addEdge(4, 5);
//		m.addEdge(5, 7);
//		m.addEdge(6, 5);
//		m.addEdge(7, 6);
//		m.addEdge(8, 5);
//		m.addEdge(8, 9);
//		m.addEdge(9, 10);
//		m.addEdge(10, 11);
//		m.addEdge(11, 3);
//		m.addEdge(11, 8);
		for(int i = 1; i <=v; i++) {
			if(d[i] == 0) dfs(i); // dfs 지점 갯수마다 실행
		}
		
		// 결과 반환
		System.out.println("전체 사이즈 ");
		System.out.printf("%d\n",result.sizeList());
		for(int i = 0; i <result.sizeList(); i++) {
			ArrayList<Integer> arrlist = result.getList(i);
			if(arrlist.size() == 0) continue;
			System.out.print((i+1)+"번째");
			for(int j = 0; j < arrlist.size(); j++) {
				if(j == arrlist.size()-1) {
					System.out.print(arrlist.get(j));					
				}else {
					System.out.print(arrlist.get(j)+",");
				}
			}
			System.out.println();
			
		}
	}

	private static int dfs(int i) {
		// dfs수행하면 return 부모값
		d[i] = i; // 자신번호 주입
		st.push(i); // 스택 삽입
		
		int parent = d[i]; // 자기 자신을 부모로 지정
		ArrayList<Integer> arr = m.getList(i);
		for(int a = 0; a <arr.size(); a++) {
			int y = arr.get(a);
			// 자신의 번호를 주입된것이 없으면
			if(d[y] == 0) parent = Math.min(parent,dfs(y));
			else if(!visit[y]) parent = Math.min(parent, d[y] );
			
		}
		if(parent == d[i]) { //부모노드가 자기 자신인 경우 종료
			List<Integer> list = new ArrayList<>();
			while(true) {
				int curr = st.pop();
				list.add(curr);
				visit[curr] = true;
				if(curr == i) break; // 만약 부모가 자신이라면 종료
				
				
			}
			Collections.sort(list);
			for(int num : list ) {
				result.getList(index).add(num);
				
			}
			index++;
			
			
		}
		
		return parent;
	}
}
