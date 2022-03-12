package recursive1;

public class MergeSort2 {
	public static void main(String[] args) {
		int arr[] = {-1,7,3,20,1,0,0,19,1,-3};
//		Mergesort(arr,0,arr.length-1);
		Mergesort(arr,1,arr.length-1);

		for(int a:arr) {
			System.out.print(a+" ");
			
		}
		
	}

	public static void Mergesort(int[] arr, int start, int end) {
		// if 조건 배열이 계속 작아진다 한 칸으로 한칸이면 start = 0 , end  = 0 이 되므로 if문이 성립하지 않음
		// 이때가 recursive가 끝남
		if(start < end) {
			int mid = (start + end) /2;
			Mergesort(arr,start,mid); // 왼쪽 분할이 가장 작은 단위까지 해결하고 밑에 잇는 것을 실행
			Mergesort(arr,mid+1,end); // 오른쪽 분할 +1을 하지않으면 StackOverflowError발생 : mid가 겹치기 때문에,
			// 중간지점으로 가르기 때문에 
			
			// 결국 한 조각 까지 나뉘어짐
			
			// 선형 비교 (각 원소끼리 하나씩 비교 하는 라운드)
			merge(arr,start,mid,end);
			
			
		}
		
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		// 임시 배열 
//		int temp[] = new int[arr.length+1];
		int temp[] = new int[end - start +1];
		int i = start;
//		int j = end;
		int j = mid+1; // mid+1 인이유 : 
		// +1을 하지않으면 mid가 한번더 들어간다.
		int k = 0; // 임시저장소 인덱스
		while(i <= mid && j<=end) { // &&조건이기 때문에 하나만 틀려도 실행 되지않는다
			// 두개의 조건을 적은이유는 : 왼쪽,오른쪽 배열에서 정렬을 하면 결국 하나의 배열이 먼저 끝난다.
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}else {
				temp[k++] = arr[j++];
//				j++;
//				k++;
			}
			
		}
		// 여기까지 진행이 됬으면 한쪽 배열이 정렬이 끝나있는 상태 하지만 왼쪽,오른쪽 중 하나는 남아 있는 상태 이므로 계속 진행 해야 한다.
		// 왼쪽 배열이 남아있다면 이것이 실행
		while(i<=mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		// 오른쪽 배열이 남아 있다면 이것이 실행
		while(j<=end) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		
		// 임시 배열 --> 원본 배열에 합치는 과정
		for(int v = start; v<=end; v++) {
			arr[v] = temp[v-start];
//			arr[v] = temp[v] 가 아닌이유 : 만약 원본 배열중 1~9 번까지 만 정렬 하고 싶은 경우
//			0번 인덱스와 10번이후 인덱스는 건들지 말아야한다.
//		    그러면 원본[1]값은 temp(임시저장 공간)인 0번째 부터 넣어야 한다
							
		}
		
		
		
	}
	
	
}
