package que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 회전하는큐 {
	static List<Integer> list = new ArrayList<>();
	static LinkedList<Integer> q = new LinkedList<>();
	static int cnt = 0; //정답 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		// 큐 주입
		for(int i = 1; i<=N; i++) {
			q.add(i);
		}
		
		// 찾을 원소 주입
		String str1[] = br.readLine().split(" ");
		for(int i = 0; i <M; i++) {
			list.add(Integer.parseInt(str1[i]));
		}
		solve();
		System.out.println(cnt);
	}

	private static void solve() {
		for(int i = 0; i<list.size(); i++) {
			int num = list.get(i);
			for(int j = 0; j<q.size(); j++) {
				if(num == q.get(j)) {
					int k = j;
					// 앞에서 부터 찾을지
					int frontcount = 0;
					int backcount = 0;
					for(int front = 0; front <k ; front++) {
						frontcount++;
					}
					// 뒤에서 부터 찾을지
					for(int back = q.size()-1; back > k ; back--) {
						backcount++;
					}
					
					if(frontcount <= backcount) {
						while(frontcount --> 0) {
							q.add(q.poll()); // 방법2
							cnt++;
						}
					}else {
						cnt += backcount + 1;
						while(frontcount --> 0) {
							q.add(q.poll()); // 방법2
							
						}
					}
					
					
					// 찾으려는 수가 맨앞에 있다.
					q.poll(); //찾은 수 제거
					break;
				}
				
			}
		}
		
	}	
}
