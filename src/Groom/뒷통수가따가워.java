package Groom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 뒷통수가따가워 {
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			String str[] = br.readLine().split(" ");
			for(int i = 0; i <N; i++){
				arr[i] = Integer.parseInt(str[i]);
			}
			
			int d[] = new int[N];
			Stack<Integer> st = new Stack<>();
			
			// 로직에 대한 이해
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i <N; i+=1) {
				bw.write(st.size()+" "); // 사이즈랑 높이랑 다르게 처리하였다.
//				sb.append(st.size()+" ");
				while(!st.isEmpty() && st.peek() <= arr[i]) {
					st.pop();
					
				}
				st.push(arr[i]);
			}
			bw.flush();
			bw.close();
			br.close();
		}
	
}
