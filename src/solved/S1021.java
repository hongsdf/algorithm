package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1021 {
	static int[] arr;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int count = 0; // 방법2,방법3에 대해서만 count를 증가한다.
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		// 큐 생성
		q = new LinkedList<Integer>();
		for(int i = 1; i<=N; i++) {
			q.add(i);
		}
		
		String str[] = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		//solve();
		
	}
	
//	private static void solve() {
//		// 방법 1 :  앞에 있는 원소를 꺼낸다.
//		
//		for(int i = 0; i < arr.length; i++) {
//			if(q.peek() == arr[i]) {
//				q.poll();
//				arr[i] = 0; // 찾았다 제거
//			}else {
//				// 맨 앞의 수가 아니라면
//				// 비교를 해야한다 : 해당 인덱스 위치가 중앙을 기준으로 왼쪽이,오른쪽중 가까운 정도
//				
//				int front = front();
//				int back = Back();
//				// 큐의 앞에서 부터 찾는방법
//				if(front <= back) {
//					// 방법2
//					for(int j = 0; j <front; j++) {
//						int num = q.poll();
//						q.add(num); //다시 뒤에서 연결
//					}
//				}else {
//					for(int j = 0; j <back; j++) {
//						int num = q.poll();
//						
//						q.add(num); //다시 뒤에서 연결
//					}
//				}
//				// 큐의 뒤에서 부터 찾는방법
//				
//			}
//		}
//		// 방법 2:  앞의 있는 원소를 맨뒤로 보낸다
//		
//		// 방법 3: 맨 뒤의 원소를 맨 앞으로 가져온다.
//		
//	}
}
