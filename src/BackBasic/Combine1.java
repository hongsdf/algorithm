package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// nCr
public class Combine1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // N개 중
		int M = Integer.parseInt(st.nextToken()); // r개를 만든다
		boolean[] visit = new boolean[N];
		int arr[] = new int[N];
		for(int i = 0; i <N; i++) {
			arr[i] = i+1;
		}
		comb(arr,0,visit,N,M);
		
	}

	private static void comb(int arr[],int pos,boolean[] visit, int n, int r) {
		if(r == 0) {
			print(arr,visit,n);
			return;
		}
		for(int i = pos; i<n; i++) { // 한 방향으로 이동:= 중복이 발생하지 않는다.
			visit[i] = true;
			comb(arr,i+1,visit,n,r-1);
			visit[i] = false;
		}
		
	}

	private static void print(int[] arr, boolean[] visit, int n) {
		for(int i = 0; i < n; i++) {
			if(visit[i]) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		
	}
}
