package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			// 입력층 
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			LinkedList<int []> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i<N; i++) {
				q.add(new int[] {i,Integer.parseInt(st.nextToken())});
			}
			int cnt = 0;
			while(!q.isEmpty()) {
				int curr[] = q.poll();
				boolean flag  = true; // 꺼낸 수가 가장 큰 수
				
				// 모든 원소가 모든 원소랑 비교
				// 2중 for문
				for(int i = 0; i <q.size(); i++) {
					
					// 특정 조건 꺼낸 수가 가장 큰수 아닐때 실행 될것이다. 
					if(curr[1] < q.get(i)[1]) {
						q.add(curr); // 가장 큰수가 아니므로 뒤에 인큐
						
						// 꺼낸수 와 가장 큰수 사이의 값들을 다시 뒤에 인큐
						for(int j = 0; j<i; j++) {
							q.add(q.poll()); // 0 ~ i값 사이의 
						}
						
						flag = false; // 가장 큰수가 이니었다
						break; // 한 원소가 비교가 끝남
						
						
						
					}
					
				}
				
				if(!flag) continue; //그럼 다시 while문으로 돌아가서 다른원소를 찾아봐 야함
				
				// 여기까지 넘어 왓다면 큐는 정렬이 되어 있을 것이다 (중요도)
				
				cnt++;
				
				// 넣었다 뺐다하면 q가 비어있지 않게 됨 무한루프 그래서 과정에서 break를 걸어줘야됨
				// 시점은 가장 큰수가 맨 앞에 놓이게 되면 break;
				
				
				if(curr[0] == M) {
					break;
				}
				
			}
			
			System.out.println(cnt);
			
		}
	}
}
