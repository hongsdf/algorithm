package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back102 {
	public static int arr[] = new int[10000001];
									  
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
//		String s = st.nextToken();
//		System.out.println(s);
		int i =0;
		while(st.hasMoreTokens()) {
			arr[i] = Integer.parseInt(st.nextToken());
			i++;
		}
//		for(int v =0; v <N; v++) {
//			System.out.print(arr[v]+" ");
//		}
		Merge(arr,0,N-1);
		for(int v =0; v <N;v++) {
			System.out.print(arr[v]+" ");
		}
	}

	private static void Merge(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start < end) {
		int mid = (start + end) /2 ; 
		Merge(arr,start,mid);
		Merge(arr,mid+1,end);
		MergeSort(arr,start,mid,end);
		}
		
	}

	private static void MergeSort(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int temp[] = new int[end -start +1];
		int i = start;
		int j = mid +1;
		int k = 0; // temp[] 에 채우기 위한 인덱스
		
		while(i <= mid && j <=end) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			}else {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		while(i <= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while(j <= end) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		// 원본으로 옮기는 작업
		for(int v=start; v<= end; v++) {
			// 0  1  2
			arr[v] = temp[v-start];
			// arr[0] = temp [0-0]
			// arr[1] = temp[0-1];  --> arr[1] = temp[1-0]
			// arr[2] = temp[0-2];  --> arr[2] = temp[2-0]
		}
		
	}
}
