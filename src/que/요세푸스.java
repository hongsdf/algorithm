package que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 요세푸스 {
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); //사람수
		int K = Integer.parseInt(str[1]); // k번째 
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <=N; i++) {
			q.add(i); //사람 주입
		}
		
		// 로직구현 k전번째 까지 뒤로 주입
		// 사람이 모두 제거 될때까지
		while(!q.isEmpty() ) {
			for(int i = 0; i < K-1; i++) {
				q.add(q.poll());
			}
			int x = q.poll();
			list.add(x);
		}
		System.out.print("<");
		for(int i = 0; i<list.size(); i++) {
			if(i == list.size()-1) {
				System.out.print(list.get(i));
				
			}else {
				System.out.print(list.get(i)+", ");
				
			}
		}
		System.out.print(">");
	}
}
