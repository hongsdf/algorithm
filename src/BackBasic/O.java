package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class O {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 1,000,000
		// 수열문제 := 배열선언
		int arr[] = new int[n+1]; // 1,000,000
		// 빈도수 배열
		int temp[] = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			temp[arr[i]]++;
		}
		
		
		// 결과 배열
		int D[] = new int[n+1];
		
		// 방법1 : 시간초과 10만 x 10만
//		for(int i = 0; i<n; i++) {
//			// arr[0] ~ arr[n-1]
//			for(int j = i+1; j<n; j++) {
//				if(arr[i] < arr[j]) {
//					D[i] = arr[j];
//					break;
//				}
//			}
//		}
//		
//		for(int i = 0; i<n; i++) {
//			if(D[i] == 0) {
//				System.out.print(-1 + " ");
//			}else {
//				System.out.print(D[i]+" ");
//			}
//		}
		
		// 방법2
		// stack 사용 이유 : 
		// 1. 뒤집기
		// 2. 앞->뒤로 진행하며 조건을 계속 적용할때
		// 3. 에디터
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		
		
		// 배열 순환
		for(int i = 2; i<=n; i++) {
			
			while(!stack.isEmpty() && temp[arr[stack.peek()]] < temp[arr[i]]) {
				D[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			D[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++) {
			sb.append(D[i]+" ");
		}
		System.out.println(sb.toString());
		
		
		
	}
}
