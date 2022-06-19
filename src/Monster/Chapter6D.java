package Monster;

import java.util.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Chapter6D {
	public static void main(String[] args) {
		// 백트레킹을 이용한 모든 조합 찾기
		int n = 3;
		int arr[] = {10,20,30};
		boolean visit[] = new boolean[n];
		
		// arr 배열에서 2개씩 조합을 맞출수 있는 경우 출력
		
		int r = 2;
		
		combine(arr,visit,0,arr.length,r);
		
		
	}

	private static void combine(int[] arr, boolean[] visit, int start, int n, int r) {
		// base-case
		if(r == 0) {
			print(arr,visit,n);
			return;
		}
		// implement
		// 시작점 부터 ~  n까지 진행해 나아가며 각 인덱스를 포함시키거나, 포함시키지 않음을 순회
		for(int i = start; i < n; i+=1) {
			visit[i] = true; // 포함 시켰다.
			combine(arr,visit,i+1,n,r-1); // 3,5번째 매개변수만 동적으로 변한다. 
			// r-1을 감소한다는 것은 1개를 포함시킨다는 의미 ==> r == 0 이되면(조건의 개수를 다 찾았다) 
			visit[i] = false; // 포함 시키지 않았다.
		}
		
	}

	private static void print(int[] arr, boolean[] visit, int n) {
//		List<Integer> list = new ArrayList<>();
		for(int i = 0; i <n; i+=1) {
			if(visit[i] == true) {
				// 내림차순 정렬
//				list.add(arr[i]);
				System.out.print(arr[i]+" ");
			}
		}
//		Collections.reverse(list);
//		for(int i = 0; i <list.size(); i++) {
//			System.out.print(list.get(i) +" ");
//		}
//		System.out.println();
		
	}
}

	// 재귀 함수로 모든 조합 구하기 
	
//public class Chapter6D {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		int r = sc.nextInt();
//		char[] items = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//		int n =items.length; // 26
//		boolean visit[] = new boolean[n];
//		
//		combine(items,visit,0,n,r);
//	}
//	
//	
//	
//	private static void combine(char[] items, boolean[] visit, int depth, int n, int r) {
//		if(r == 0){
//			print(items,visit,n);
//			return;
//		}
//		
//		if(depth == n){
//			return;
//		}
//		visit[depth] = true;
//		combine(items,visit,depth+1,n,r-1);
//		
//		// 포함 하지 않은 경우
//		visit[depth] = false;
//		combine(items,visit,depth+1,n,r); 
//		
//	}
//
//
//
//	
//	private static void print(char[] items, boolean[] visit, int n) {
//		for(int i = 0; i < n; i++){
//			if(visit[i] == true){
//				System.out.print(items[i] + " ");
//			}
//		}
//		System.out.println();
//	}
//		
//	
//
//
//
//
//}
//
//
//
//
