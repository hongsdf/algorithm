package que;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class queue1 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
////		4 2 2번째 로 출력하는 것 3의 인덱스 출력 : 2
////		1 2 3 4
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
////		List<Integer> list = new ArrayList<>();
//		StringTokenizer st;
////		int arr[] = new int[101];
////		Queue<Integer> q = new LinkedList<Integer>();
//		LinkedList<int[]> q = new LinkedList<int[]>();
//		
//		while(n --> 0) {
//			st = new StringTokenizer(br.readLine()," ");
//			int N = Integer.parseInt(st.nextToken() );
//			int M = Integer.parseInt(st.nextToken() );
////			System.out.println("enter");
////			int arr[] = new int[N];
//			int count = 0;
//			st = new StringTokenizer(br.readLine()," ");
//			for(int i=0; i<N; i++) {
////				new int[] { i, Integer.parseInt(st.nextToken()) }
//				// 중요 
////				q.offer(new int[]{ i, Integer.parseInt(st.nextToken())});
//				
//				
//				// *여기 이해하기
//				q.add(new int[] { i    ,   Integer.parseInt(st.nextToken())}); // int[] 배열에 ( x좌표, y좌표  ) 형식으로 들어감
////				q.offer(null);
////				System.out.println();
//			}
////			System.out.println("한줄 출력");
//			//2 번 인덱스는 3번을 가르키고 3번은 인덱스 2
//			
//			while(!q.isEmpty()) {
//				// *여기 이해하기
//				int front[] = q.poll();
//				boolean flag = true; // 가장 첫번째 원소가 가장 크다라는 뜻.
//				
//				
//				
////				for(int a: front)
////				System.out.print(a+" "); // *0 1  *1 2 *2 3 *3 4 이렇게 출력됨 : *인덱스 번호를 나타냄
////				// 
//				for(int i =0; i<q.size(); i++) {
//					// *여기 이해하기
//					if(front[1] < q.get(i)[1]) {
//						// *여기 이해하기
//						q.add(front); // 뒤에 중요도가 더 큰 것이 존재하면 앞에 있는 것들을 모두 뒤로 보내는 작업
////						System.out.println("front의 의미 :"+front);
//						// *여기 이해하기
//						flag = false; // 뒤에 더 큰 원소가 있다.라는  뜻
//					}
//				}// 여기로 넘어 오면 정렬한번 정렬이 되었다.
//				//  정렬(뒤에 더 큰 중요도가 있으면)이 되면 flag는 true로 바꾼다
//				// 그리고 내가 찾고자하는 M(인덱스 M번째 원소가 출력되는 순위(count)
//				
//				// *여기 이해하기
//				if(flag) {
//					// *여기 이해하기
//					count++;
//					// *여기 이해하기
//					if(front[0] == M) break; // 이곳은 찾았다
//				}else {              //     index
//			//       찾고자 하는 값이 아니면 다시 while문으로 돌아가 실행
//					// *여기 이해하기 
//					q.add(front); //front :  0  1  2   이런씩으로 되어있음(2차원 구조)
////					                      :  5  3  4
//				}
//			}
//			
//			System.out.println(count);
//		}
//		
//	}
//}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.StringTokenizer;
import java.util.LinkedList;
 
public class queue1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
 
		while (T-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();	// Queue로 활용 할 연결리스트
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				// {초기 위치, 중요도}
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
 
			int count = 0;	// 출력 횟수
			
			while (!q.isEmpty()) {	// 한 케이스에 대한 반복문
				
				int[] front = q.poll();	// 가장 첫 원소
				boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수
				
				// 큐에 남아있는 원소들과 중요도를 비교 
				for(int i = 0; i < q.size(); i++) {
					
					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우 
					if(front[1] < q.get(i)[1]) {
						
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						// front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
						isMax = false;
						break;
					}
				}
				
				// front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
				if(isMax == false) {
					continue;
				}
				
				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
				count++;
				if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}
 
			}
 
			sb.append(count).append('\n');
 
		}
		System.out.println(sb);
	}
}



















