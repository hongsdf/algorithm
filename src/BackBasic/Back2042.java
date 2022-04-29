package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 수
		int M = Integer.parseInt(st.nextToken()); // M은 수의 변경이 일어나는 횟수
		int K = Integer.parseInt(st.nextToken()); // K는 구간의 합을 구하는 횟수이다.
		int arr[] = new int[N];
		for(int i = 0; i<N; i++) {
			// 0 ~n-1
			arr[i] = Integer.parseInt(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			if(a == 1) {
				arr[b-1] = c; 
			}else if(a == 2) {
				// 구간 합을 구함
				for(int j = b-1; j<= c-1; j++) {
					sum += arr[j];
				}
				sb.append(sum).append('\n');
			}
		}
		System.out.println(sb.toString());
		
		
		
	}
}
