package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Chapter5_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) ;
			
		}
		int D[] = new int[N+1]; // 결과 배열
		Stack<Integer> stack = new Stack<>();
		// 반대로 담는다.
		// 6 9 5 7 4 에서 마지막 인덱스번호를 담는다. 5번
		stack.push(N); 
		for(int i = N-1; i>=1; i--) {
			// 4번부터 1번까지 순회하며 큰수 높이를 발견하면 갱신 인덱스 번호로 
			while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) { // i의 높이가 stack.peek()높이보다 큰 경우
				D[stack.pop()] = i;
			}
			stack.push(i);
			
		}
		for(int i = 1; i<=N; i+=1) {
			System.out.print(D[i]+" ");
		}
	}
}
