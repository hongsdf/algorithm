package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

/* 스택 수열 문제
 	 1 ~ N까지 수를 스택에 담는다
 	 비교대상 배열에서 stack에 숫자와 일치하면 pop()
  	 배열 인덱스 한칸 전진
  	 다음 배열의 수와 일치하면 pop()아니면 찾을때 까지 push()
  
 
 
 
 */
public class Back1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		// 배열 생성
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solve(arr);
		
		

	}

	private static void solve(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int idx = 0; // 1이 안되는 이유 처음  num : 1이면 바로 else문으로 갔을때 st은 비어있다
		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			if (num > idx) { // 해당 원소보다 작을때까지 +
				while (num > idx) { // 해당원소 직전까지 1 ~ num-1까지 입려받기
					stack.push(++idx); // 이 표현에 익숙해 지자
					sb.append("+\n");
				}
				stack.pop(); // num == idx가 같아지면 pop
				sb.append("-\n");
			} else { // idx 가 num보다 클때
				if (stack.peek() != num) {
					System.out.println("NO");
					return;
				} else {
					stack.pop();
					sb.append("-\n");
				}
			}
		}
		System.out.println(sb.toString());
		
	}
}
