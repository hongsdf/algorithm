package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/* 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.
	Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
 	그러한 수가 없는 경우에 오등큰수는 -1이다.
 *  1 1 2 3 4 2 1 -> -1 -1 1 2 2 1 -1
 *  
 *  n = 100000이므로 O(n^2)이상 안됨
 *  
 * */
public class NGF {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) ;
		int arr[] = new int[N];
		int ans[] = new int[N];
		int result[] = new int[100001] ;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			result[arr[i]]++;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i = 1; i <N; i++) {
			/* 해당 횟수를비교한다 어차피  result[arr[]] < result[[[]]] : 되어 있어도 결국 result을 비교하는 것을 인지 하고 시작하자 */
			// result[arr[stack.peek()]] < result[arr[i]] 등장횟수를 비교하여 등장횟수보다 크면 지점을 갱신해주는 원리
			while(!stack.isEmpty() && result[arr[stack.peek()]] < result[arr[i]] ) {
				ans[stack.pop()] = arr[i]; // 갱신이 되면 해당 idx의 원소값를 저장한다.
			}
			stack.push(i); // 
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i <ans.length; i++) {
			if(ans[i] == 0) ans[i] = -1;
			bw.write(ans[i]+" ");
		}
		
		bw.flush();
	}
}
