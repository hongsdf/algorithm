package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M_15650_중복있는_순열 {
	public static StringBuilder sb = new StringBuilder();
	public static int [] arr;
	public static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N+1]; // 배열
		for(int i = 1; i <=N; i++) {
			arr[i] = i;
		}
		dfs(0,"");
		System.out.println(sb.toString());
	}
	private static void dfs(int depth, String temp) {
		// 탈출 조건
		if(depth == M) {
			char c[] = temp.toCharArray();
			for(char a : c) {
				// System.out.print(a + " ");
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		// 구현
		for(int i = 1; i <= arr.length-1; i++) {
			temp += i;
			dfs(depth+1,temp);
			temp = temp.substring(0,temp.length()-1);
		}
		
		
	}
}
