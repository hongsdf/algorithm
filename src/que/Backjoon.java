package que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 중요도가 높은 순서대로 출력하시오
public class Backjoon {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 0 1 2 3
		// 4 2 3 1

		// int n = 4;
//		int m = 3 궁금한 인덱스 int m = 2; int m = 0;
		// return 4; return 2; return 1;

		// q에 저장 되는 형식은 int []

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			LinkedList<int[]> q = new LinkedList<int[]>();
//			LinkedList<List<Integer>> q = new LinkedList<>() ;
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
//				q.add(j, Integer.parseInt(br.readLine())); 잘못된 표현
				q.add(new int[] { j, Integer.parseInt(st.nextToken()) });
				// list 로 지정 했을때
//				q.add(Arrays.asList(Integer.parseInt(br.readLine())));
			}

//			int count = 0;
//			while (!q.isEmpty()) {	// 한 케이스에 대한 반복문
//				System.out.println("======= 여기 시작 =======");
//				int[] front = q.poll();	// 가장 첫 원소
//				boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수
//				
//				// 큐에 남아있는 원소들과 중요도를 비교 
//				for(int i = 0; i < q.size(); i++) {
//					
//					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우 
//					if(front[1] < q.get(i)[1]) {
//						System.out.println("[i] :"+ i);
//						System.out.println("front[1] : "+front[1]);
//						System.out.println("q 값"+q.get(i)[1]);
//						
//						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
//						q.offer(front); // 아 뒤에 원소가 더 크다
//						for(int u = 0; u<q.size(); u++) {
//							System.out.print(q.get(u)[1]+" ");
//						}
//						System.out.println();
//						// i 이전 원소들은 뒤로 보낸다
//						for(int j = 0; j < i; j++) {
//							q.offer(q.poll());
//						}
//						System.out.println("변경후");
//						for(int u = 0; u<q.size(); u++) {
//							System.out.print(q.get(u)[1]+" ");
//						}
//						System.out.println();
//						// front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
//						isMax = false;
//						break;
//					}
//				}
//				if(isMax == false) {
//					System.out.println("contuinu 실행");
//					continue;
//				}
//				
//				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
//				count++;
//				if(front[0] == m) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
//					// fornt[0] == m의 값은 여기 
////					나머지는 다 쳐 냈다. 
//					break;
//				}
			int cnt = 0;
			while (!q.isEmpty()) {
				int temp[] = q.poll();
				boolean flag = true;

				for (int i = 0; i < q.size(); i++) {
					if (temp[1] < q.get(i)[1]) {
						q.offer(temp); // temp 는 뺏던 temp 0 : 이런 구조
//						                                 2

						// 1 1 9 1 1 1
						// 1 < 1
						// 1 9 1 1 1
						// 1 < 9 i :1
						// 1 9 1 1 1 1
						// 9 1 1 1 1 1
						// 9 < 1 i :2
						// 1 1 1 1 1

						// 1 < 1 i :3
						// 1 1 1 1
						// 1 1 1 i :4
						// 1 1 i : 5

						// [1] 1 9 1 1 1 cnt :1
						// 1 9 1 1 1 [1]
						// 9 1 1 1 [1] 1
						// 1 1 1 [1] 1 cnt :2
						// 1 1 [1] 1 1 cnt :3
						// 1 [1] 1 1 1 cnt :4
						// [1] 1 1 1 1 cnt :5
						// 결국 괄호 같은 1이여도 [1] 찾기 

						// 중복 값이 포함 되어있을때 넘기는 방법
						// 값이 각각 차이가 나면 실행 안됨

						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						flag = false;
						break;
					}
					
				}
				if (flag == false) {
					continue;
				}
				cnt++;
				// temp[0] : 결국 temp[0]에 놓인 값은 가장 큰 수
				if (temp[0] == m) { // 찾던 인덱스 위치 == 입력한 인덱스
					// temp[0] : 인덱스를 나타내고
					// temp[1] : 값을 나타낸다
//					System.out.println("찾던 인덱스"+temp[0]); //temp[0] : 찾던 인덱스 위치를 나타냄
//					System.out.println("찾던 값"+temp[1]);
					break;
				}

			}
			System.out.println(cnt);

		}
	}
}
