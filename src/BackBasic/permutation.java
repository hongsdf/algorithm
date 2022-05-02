package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class permutation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // N개 중
		int M = Integer.parseInt(st.nextToken()); // M개를 만든다
		int arr[] = new int[N+1];
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		boolean visit[] = new boolean[N];
		int[] output = new int[M]; // r := 개를 담을 수 있는 공간
		// 순서가 있는 조합
		permute(arr,0,visit,N,M,output);
	}

	private static void permute(int arr[],int pos,boolean visit[],int n, int m,int[] output) {
		if(pos == m) {
			print(output,m); // 저장공간 출력
			return;
		}
		// 백트레킹 방법
		for(int i = 0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				output[pos] = arr[i]; // 저장공간
				permute(arr,pos+1,visit,n,m,output);
				visit[i] = false;
			}
		}
		
	}

	private static void print(int[] output, int m) {
		for(int i = 0; i<m; i++ ) {
			System.out.print(output[i]+" ");
		}
		System.out.println();
		
	}
}
