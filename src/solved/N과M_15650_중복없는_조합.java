package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M_15650_중복없는_조합 {
		// {1,2} == > {2,1} 은 같은 결과이다.
	
	
	
	public static boolean visit[];
	public static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		visit = new boolean[N+1];
		arr = new int[N+1]; // 배열
		for(int i = 1; i <=N; i++) {
			arr[i] = i;
		}
		String temp = "";
		// 조합을 찾는 구현(중복없이 - 같은 지점을 탐색 x)
		for(int i = 1; i<=N; i++) {

			visit[i] = true;
			temp += i;
			dfs(i,1,temp,M);
			visit[i] = false;
			temp = temp.substring(0,temp.length()-1);
			
		}
		
	}
	private static void dfs(int start ,int depth, String temp, int M) {
		
		
		
		// 탈출조건
		if(depth == M) {
			char c[] = temp.toCharArray();
			for(char a : c ) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		// 구현
		for(int i = start; i <= arr.length-1; i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp += i;
				dfs(i,depth+1,temp,M);
				temp = temp.substring(0,temp.length()-1);
				visit[i] = false;
			}
		}
		
		
	}
}
