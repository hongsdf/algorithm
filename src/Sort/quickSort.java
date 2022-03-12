package Sort;

public class quickSort {
	public static void main(String[] args) {
		int arr[] = {3, 2, 1, 6, 9, 5, 4, 7, 8};
		int n = arr.length;
		quick(arr,0,n-1);
		for(int i =0; i<n-1; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void quick(int[] arr, int start, int end) {
		if(start >= end) { // 한 칸이 되면 : 재귀 함수는 범위를 줄이면 결국 start 와 end가 같게 된다 그때 가 한칸
			return;
		}
		
		int pivot = start; // 기준
		int i = start+1; // 처음 인덱스
		int j = end; // 마지막 인덱스
		int temp;
		// base-case
		
		while(i <= j) { // i가 j랑 같아지는 순간까지만 진행
			System.out.println("출력");
		
		// i는 오른쪽으로 가는 방향 기준보다 큰 값의 인데스 에서 멈춘다
		while(i <= end && arr[i] >= arr[pivot] ) { // arr[i] <= arr[pivot]
			// i <= end 이게 왜 뒤에 잇으면 안될까? if(arr[i] <= arr[pivot] && i <= end)
			i++;
		}

		// j는 왼쪽으로 가는 방향 기준보다 작은 값 인덱스에서 멈춘다
		while(arr[pivot] >= arr[j] && j > start) {
			j--;
		}
		if(i > j) {// 엇 갈리면 pivot 자리와 j 를 바꾼다
			temp = arr[j];
			arr[j] = arr[pivot];
			arr[pivot] = temp;
		}else { // 아니라면 i 랑 j를 바꾼다
			temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
	}
		// 결국 두조건중 하나를 택하게 되면 j가 변동이된다(j == 기준) j를 기준으로 두 범위를 나뉘어 재귀 호출
		quick(arr,start, j-1);
		quick(arr,j+1,end);
		
	}
}
