package Sort;

public class Merge3 {
	public static int temp[] =new int[10001];
	
	// 반 으로 잘라가며 진행하는것
	public static void main(String[] args) {
		int arry[] = new int[] {2,0,1,5,3,6,7,9};
		int n = arry.length;
		MergeSort(n,arry,0,n-1);
		for(int i = 0; i<arry.length; i++) {
			System.out.print(arry[i]);
		}
	}

	private static void MergeSort(int n, int[] arry, int start, int end) {
		// 재귀를 사용하여 구현
		if(start < end) {
			int mid = (start+end) /2;
			MergeSort(n,arry,start,mid);
			MergeSort(n,arry,mid+1,end);
			Merge(arry,start,mid,end);
			
			
		}
	}

	private static void Merge(int[] arry, int start, int mid, int end) {
		// 선형 결합 함수 
		int i = start; // [1,2]  mid = 2;
		int j = mid +1; // [3,4]    ---->[  두개의 배열(i,j포인터) => 하나의 배열로 정렬하기     ]
		int k = 0 ;
		while(i<= mid && j<=end) {
			if(arry[i] < arry[j]) {
				temp[k++] = arry[i++];
				
			}else {
				temp[k++] = arry[j++];
			}
		}
		
		while(i<= mid) {
			temp[k++] = arry[i++];
		}
		while(j<= end) {
			temp[k++] = arry[j++];
		}
		
		for(int v = start; v<=end; v++) {
			arry[v] = temp[v-start];
		}
	}
}
