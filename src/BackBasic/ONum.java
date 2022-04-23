package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*배열원소안에서 자신보다 오른쪽에 위치한 큰수중 가장 왼쪽수 찾기
 	[3,5,2,7] -> [5,7,7-1]
 */

// n = 1,000,000 이면 O(N^2) 으로 풀면 안됨

/* 얻은 교훈 
 	1.한쪽방향으로 배열안에서 원소를 비교할때 :  스택을 생각해 볼 수 있다. 0 ---> 3, 1---->3, 2---->3
 	2. 비교 할때 원소의 값을 비교할수도 잇지만 , 배열의 인덱스를 활용하여 저장 할수 있다. ans[st.peek()]
 	3. 문제 에서는 기준보다 작은 값은 st push하고, 큰 값이 발견되면 st.peek() 하며 값을 교체한다. 이때 해당 값의 인덱스를 저장한다.
 	
 
 */

public class ONum { // O(N^2)
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int result[] = new int[arr.length]; // 정답 배열
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i <N; i++) {
				arr[i] = Integer.parseInt( st.nextToken() );
			}
			// [3,5,2,7]
			// 스택을 사용 생각해볼때 방향이 한쪽일때도 생각 가능
			// 자신보다 작은 값의 인덱스는 전부 push()
			// 비교할때 <--- 자신보다 작은 값의 인덱스를 갱신
			Stack<Integer> stack = new Stack<>();
			stack.push(0);
			for(int i = 1; i<N; i++) {
				
				// 3 (idx 0), 5
				// 5
				while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
					result[stack.peek()] = arr[i];
					// 자신 보다 큰수를 발견시 기준 교체
					stack.pop();
				}
				// 교체를 하게 되면 5의 값을 직접 넣는 것이 아니라 5의 idx ==1 를 넣는다
				stack.push(i);
			}
			// 7에 해당하는 idx 3을 넣는다.
			while(!stack.isEmpty()) {
				result[stack.pop()] = -1;
			}
			BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
			for(int ans : result ) {
				bw.write(ans+" ");
			}
			bw.flush();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*오큰수 문제는 값대신 idx를 대신하여 해결한다.*/
//			stack.push(0); // arr[]배열의 첫번째 요소를 가리키는 idx
//			
//		   
//			
//			for(int i = 1; i < N; i++) {
//				if(stack.isEmpty()) {
//					stack.push(i);
//				}
//				//   5 2 7 경우 입장에서 2가 오큰수가 아니다 그러므로 2를 다시 쌓는다. 아직 5위치 오큰수는 구하지 못한 상태
//				//  계속진행 마지막까지 진행하며 5위치도 찾는다.
//				// 원리:
//				// 자신보다 작은 값의 인덱스를 stack에 쌓는다.
//				// 자신보다 큰 값의 인덱스가 결과에 반영
//				while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) { // stack의 top에 잇는 요소보다 크면 
//					// 지우는 idx번호에 값을 넣고 top을 지운다.
//					result[stack.peek()] = arr[i];
//					stack.pop();
//				}
//				stack.push(i);
//				
//			}
			                                                                                    
		
		
		
		
		
		
		
		
		
		
		
		
//		int arr[] = new int[] {9,5,4,8};
//		int result[] = new int[arr.length];
//		for(int i = 0; i<arr.length; i++) {
//			boolean flag = false;
//			for(int j = i+1; j<arr.length; j++) {
//					if(arr[i] < arr[j]) {
//						result[i] = arr[j];
//						flag = true;
//						break;
//					}
//					
//				
//			}
//		}
//		// 마지막 원소이든 큰수를 찾지 못하면 남은 원소를 -1로
//		for(int i = 0; i <result.length; i++) {
//			if(result[i] == 0) {
//				result[i] = -1;
//			}
//		}
	}
}
