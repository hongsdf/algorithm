package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복 조합 문제 
public class N_M4 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N개 중
		int M = Integer.parseInt(st.nextToken()); // M개를 만든다
		int arr[] = new int[M]; // r개를 선택공간

		dfs(arr,1,0,N,M); // 시작위치, 깊이 := 선택 개수 
		
	}
	private static void dfs(int arr[],int pos, int depth, int n, int r) {
		if(depth == r) {
		   print(arr,r);
		   return;
		}
		for(int i = pos; i <=n; i++) {
			arr[depth] = i;
			dfs(arr,i,depth+1,n,r);
		}
		
	}
	private static void print(int[] arr, int r) {
		for(int i = 0; i <r; i++) {
			System.out.print(arr[i]+" ");
//			sb.append(arr[i]).append(" ");
		}
//		sb.append('\n');
		System.out.println();
		
	}
	
	

	
}
