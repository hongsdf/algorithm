package recursive1;

// 분할 정복 -> 큰 문제를 작은 문제들로 해결
public class MergeSort {
	public static void main(String[] args) {
		int arry[] = new int[] {-5,20,2,3,10,0};
		MergeSort(arry,0,arry.length-1);
		for(int a:arry) {
			System.out.print(a+" ");
		}
	}
	
	
	
	public static void MergeSort(int arr[], int s, int e) {
		if(s < e) {
			int m = (s+e) /2;
			// 분할 작업
			MergeSort(arr,s,m); // 왼쪽 
			MergeSort(arr,m+1,e); // 오른쪽 +1 이유: 왼쪽배열이 더 작기 때문 +  중간지점이 겹치기 때문에
			// 선형 정렬
			Merge(arr,s,m,e);
		}
		
	}



	public static void Merge(int[] arr, int start, int mid, int end) {
		// 임시 배열 : temp 원본데이터의 손상을 주지 않기위해 완성 되고 원본에 다시 넣는다
		int temp[] = new int[end-start+1];
		// int temp[] = new int[arr.lenght];
		
		// 가장 작은 단계 한칸 -> 점점 올라가는 단계로 진행할것이다
		int i = start;
		int j = mid+1;
		int k =0;
		
		
		// 두 하위 왼쪽,오른쪽 배열에 각각 포인터를 두고 정렬하기위해서 temp 에 채워넣기
		//   왼쪽 배열  && 오른쪽 배열  (&& 조건인 이유 merge 정렬중 한 배열은 남게 된다.
		while(i<=mid && j<=end) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}else {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		// 남은 하위 배열에서 임시저장공간 마저 채우기
		while( i<= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		
		while(j<= end) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		// 임시 공간을 원본으로 옮기기
		for(int v =start; v<=end; v++) {
			arr[v] = temp[v-start]; // temp[v-start] : 인 이유 
			// -5 0 2 3 10 20 배열에서 1번인덱스부터 4번사이까지만 정렬하고 싶은 경우
			// 0 2 3 10 배열을 temp[0]은 0일것이다 하지만 원본 데이터는 arr[1] = temp[0]이 들어가야 하므로
			// temp[i-start] :  arr[1] = temp[1-1] 인 것이다.
			// arr[3] = temp[(0) :  3 - 3]
			// arr[4] = temp[(1) :  4 - 3]
			
			// 복습 필요
		}
		
	}
}
