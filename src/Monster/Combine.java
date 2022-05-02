package Monster;

import java.util.PriorityQueue;

public class Combine {
	public static void main(String[] args) {
		int arr[] = {6,10,2};
		int n = arr.length;
		int r = 2;
		boolean visit[] = new boolean[n];
		int output[] = new int[r];// 저장 공간
		// 백트레킹 방법으로 조합 구현
//		for(int i = 1; i<=n; i++) {
//			// 모든 조합 찾기 1~r까지
//			System.out.println(i+"개 조합");
//			comb(arr,visit,0,n,i); // 원본배열,방문여부,시작위치,n개,i 조합수(변수)
//		}
		// 특정 r개의 조합 수 찾기
		comb(arr,visit,0,n,r); // 원본배열,방문여부,시작위치,n개,r조합수
		
	}

	private static void comb(int[] arr, boolean[] visit, int pos, int n, int r) {
		// nCr:=조합
		if(r == 0) { // r:=을 줄여가며 , 현재위치를 증가하며
			save(arr,visit,n);
			return;
		}
		// 백트래킹
		for(int i = pos; i<n; i++) {
			visit[i] = true; // 체크
			comb(arr,visit,i+1,n,r-1);
			visit[i] = false;
		}
	}

	private static void save(int[] arr,boolean visit[],int n) {
//		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) ->(a[0]-b[0]) );
		for(int i= 0; i<n; i++) {
			if(visit[i]) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		
	}
}
