package Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class permute_comb {
	public static List<String> list = new ArrayList<>();
	public static int output[];
	// [6,10,2] : =조합, 순열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n =Integer.parseInt(st.nextToken());
		int r =Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean visit[] = new boolean[n];
		output = new int[r];
		// 조합
		comb(arr,visit,0,n,r);
		Collections.sort(list);
		for(String a :list) {
			System.out.println(a);
		}
		// 순열
		
		permute(arr,visit,0,n,r); // 원본배열, 방문여부,시작위치,n,r
		
		
	}
	// 순열
	private static void permute(int[] arr, boolean[] visit, int pos, int n, int r) {
		if(pos == r) { // r개를 선택하였을때
			print2(output,r);
			return;
		}
		for(int i = 0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				output[pos] = arr[i];
				permute(arr,visit,pos+1,n,r);
				visit[i] = false;
			}
		}
		
	}

	private static void print2(int[] output, int r) {
		for(int i = 0; i <r; i++) {
			System.out.print(output[i]+" ");
		}
		System.out.println();
		
	}
	// 조합
	private static void comb(int[] arr, boolean[] visit, int pos, int n, int r) {
		if(r == 0) {
			print(arr,visit,n);
			return;
		}
		for(int i = pos; i<n; i++) {
			visit[i] = true;
			comb(arr,visit,i+1,n,r-1); // i := i-1, r := r+1로 돌아온다
			visit[i] = false;
		}
		
	}

	private static void print(int[] arr, boolean[] visit, int n) {
		// 정렬
		String temp = "";
		for(int i = 0; i <n; i++) {
			if(visit[i]) {
//				System.out.print(arr[i]);
				temp += String.valueOf(arr[i]);
			}
		}
//		System.out.println();
		list.add(temp);
		
	}
	
	
}
