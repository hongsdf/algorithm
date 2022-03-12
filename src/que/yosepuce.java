package que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class yosepuce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," "); //buffer에 기준 주기
		LinkedList<Integer> q = new LinkedList<Integer>();
		List<Integer> lsi = new ArrayList<Integer>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
//		System.out.println(n);
//		System.out.println(m);
		for(int i=0; i<n; i++) {
			q.add(i+1);
		}// 0 1 2 3 4 5 6 
		 // 1 2 3 4 5 6 7 
		 // (1 2) 3 4 5 6 7 1 2 
//		System.out.println(q.get(3));
		// q.size() > 1인이유 : q.isEmpty()로 구현해도 된다 하지만 이렇게 구현하면 마지막 한명을 찾을수 있다.
		while(q.size() > 1) {
			for(int i =0; i < m-1;i++) { // m 인덱스에 해당 되지않으면 원형처럼 뒤로 넘긴다.
				int curr = q.poll(); // 큐에 해당 되지않는 것을 빼내
				q.add(curr); // 넘기는 작업 다시 큐에 넣는다
			}
			lsi.add(q.poll() ); // m번째 오면 제거 [3번의 인덱스 2]
			
			
		}
		System.out.print("<");
		// 이것을 수행하면 결국 하나가 남는다
		for(int a:lsi) {
			System.out.print(a+", ");
			
		}
		// 마지막 남은 원소를 여기서 출력
		System.out.print(q.poll() ) ;
		System.out.println(">");
	}
}
