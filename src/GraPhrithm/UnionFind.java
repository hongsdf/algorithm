package GraPhrithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionFind {
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[6];
		for(int i = 1; i <=5; i++) {
			arr[i] = i;
		}
		int E = 3; //간선  1-2 ,2-3,4-2
		// 그래프 연결
//		for(int i = 0; i<E; i++) {
			Parent(arr,1,2);
			Parent(arr,2,3);
			Parent(arr,4,2);
			int ans = resultParent(arr,1,4);
			System.out.println(ans == 0 ? "같은 그래프" :"다른그래프");
//		}
		
		
		
	}
	// 재귀함수로 자신의 부모찾기
	public static int getParent(int arr[], int x) {
		if(arr[x] == x) return x;
		return arr[x] = getParent(arr,arr[x]);
		
	}
	// 작은 값으로 부모 합치기
	public static void Parent(int arr[], int a , int b) {
		a = getParent(arr, a);
		b = getParent(arr, b);
		if(a >= b) arr[b] = a;
		else arr[a] = b;
	}
	
	// 값은 부모를 바로 보고있는지 확인하는 메서드
	public static int resultParent(int arr[], int a, int b) {
		a = getParent(arr, a);
		b = getParent(arr,b);
		if(a == b) return 0;
		return -1;
	}
	
	
}
