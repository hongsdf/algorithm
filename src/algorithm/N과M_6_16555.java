package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
중복되는 수열을 여러 번 출력하면 안되며 순서가 있다. */


public class N과M_6_16555 {
	public static boolean visit[]; // 노드 방문 체크
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		visit = new boolean[N];
		String str1[] = br.readLine().split(" ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(str1[i]);
		}
		List<Integer> list = new ArrayList<Integer>(); // 결과 배열
		// 구현
		Arrays.sort(arr);
		int start = 0;
		
		dfs(0,start,N,M,list);	
	
		
		System.out.println(sb.toString());// 결과 출력
	}

	private static void dfs(int depth,int start, int N, int M,List<Integer> list) {  // 결과 배열) {
		// 목적 : 뿌리깊이 까지 탐색을 했다면 종료
		if(depth == M) {
			for(int num : list) {
				sb.append(num+" ");
			}
			sb.append('\n');
			
			return;
		}
		// 구현
		for(int i = start; i <N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				list.add(arr[i]);
				dfs(depth+1,i,N,M,list);
				visit[i] = false;
				list.remove(list.size()-1); // 마지막 원소 제거
			}
		}
		
		
	}
}

