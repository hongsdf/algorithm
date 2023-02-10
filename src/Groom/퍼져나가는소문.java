package Groom;

import java.io.*;
public class 퍼져나가는소문 {
	public static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
	 	arr = new int[N+1];
		int answer = 1;
		for(int i = 1; i <=N; i++){
			arr[i] = i;
		}
		for(int i = 0; i <K; i++){
			String str[] = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			// 구현
			Union(start,end);
			
			// 1번 친구 소문
			
		}
		for(int i = 2; i<arr.length; i++){
			boolean flag = Same(1,i);
			if(flag) answer+=1;
		}
		System.out.println(answer);
	}
	private static boolean Same(int i, int j) {
		int v1 = getParent(i);
		int v2 = getParent(j);
		if(v1 == v2) return true;
		
		return false;
	}
	// 그래프 연결  1 <- 3 <-5
	public static void Union(int start, int end){
		int a = getParent(start);
		int b = getParent(end);
		if(a >= b){
			arr[a] = b; 
		} 
		else arr[b] = a;
		
	}
	// 자신의 부모 찾기
	public static int getParent(int x){
		if(arr[x] == x) return x;
		return arr[x] = getParent(arr[x]);
	}
	
	
	
}