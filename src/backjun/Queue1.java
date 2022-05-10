package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			LinkedList <int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i <N; i++) {
				q.add(new int[] {i,Integer.parseInt(st.nextToken())});
			}
			int cnt = 0;
			while(!q.isEmpty()) {
				int curr[] = q.poll();
				boolean flag = true; // 이 수가 가장 큰수이다.
				for(int i = 0; i <q.size(); i++) {
					if(curr[1] < q.get(i)[1]) {
						q.add(curr);
						for(int j = 0; j<i; j++) {
							q.add(q.get(j));
						}
						flag = false; // 가장 큰수가 아니다.
						break; // 가장 큰수를 맨 앞으로옮겨야한다.
					}
					
				}
				
				if(flag == false) { // 가장 큰수가 아니므로 다시 찾아라
					continue;
				}
				cnt++; // 가장큰수라면 찾았다
				
				//가장 큰수가 내가 찾는 값이 맞을까?
				if(curr[0] == M) {
					break;
				}
				
				
				
			}
			System.out.println(cnt);
			
		
			
		}
		
		
	}
}
