package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solvedac_24060알고리즘수업병합정렬1 {
	public static int answer[]; // 결과 배열
	public static int arr[]; // 임시변수
	public static int K;
	public static int cnt = 0;
	public static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		arr = new int[n];
		answer = new int[n]; // 정렬될 결과 배열
		String str1[] = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str1[i]);
		}
		
		MergeSort(0,n-1);
		System.out.println(cnt < K? -1:result);
		
		
		
	}

	private static void MergeSort(int start, int end) {
		// 재귀함수로 구현 : 분할 정복 -> 귀납법
		
		if(start >= end) {
			return;
		}
		
		int mid = (start+end)/2;
		MergeSort(start,mid);
		MergeSort(mid+1,end);
		MergeaddSort(start,mid,end);
		
		
		
	}

	private static void MergeaddSort(int start, int mid, int end) {
		//int temp[] = new int[end - start +1];
		
		int i = start;
		int j = mid+1;
		int k = start;
		
		while(i <= mid && j <= end) {
			if(arr[i] >= arr[j]) {
				answer[k++] = arr[j++]; 
			}else {
				answer[k++] = arr[i++];
				
			}
		}
		
		
		// 나머지 남겨 있는
		while(i <= mid) {
			answer[k++] = arr[i++];
		}
		
		while(j <= end) {
			answer[k++] = arr[j++];
		}
		
		// 임시 배열을 원본배열로 덮어쓰여야한다. 이래야 분할되어 정렬된 영역끼리 처리가 가능하다.
		for(int a = start; a <= end; a++) {
			cnt++;
			arr[a] = answer[a];
			if(cnt == K) {
				result = answer[a];
			}
		}
	}
}
