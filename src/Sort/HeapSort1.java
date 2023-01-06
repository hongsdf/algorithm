package Sort;

// heap : 완전이진트리를 기반으로한 최대값,최소값을 찾는 방법
// heapify : heap을 만들기 위한 알고리즘
public class HeapSort1 {
	public static int arr[] = {7,9,10,11,5,1,2,3,7};
	// public static int arr[] = {7,6,5,8,3,5,9,1,6};
	public static int n = 9;
	public static void main(String[] args) {
	
		heapsort();
  		heapify(); 
		// heapify 알로리즘 구현
		
		
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%d ",arr[i]);
		}
	}


	private static void heapsort() {
		
		for(int i = 1; i <n; i++) {
			int child = i;
			// 부모 찾기 
			
			// 재귀 함수로 구현
			solve(child);
			
			
//			do {
//				int root = (child - 1)/2;
//				if(arr[root] < arr[child]) {
//					int temp = arr[root];
//					arr[root] = arr[child];
//					arr[child] = temp;
//				}
//				child = root;
//				
//			}while(child != 0);
		}
		
	}

	private static void solve(int child) {
		if(child == 0) {
			return;
		}
		
		int root = (child - 1)/2;
		if(arr[root] < arr[child]) {
			int temp = arr[root];
			arr[root] = arr[child];
			arr[child] = temp;
		}
		child = root;
		solve(child);
	}
	private static void heapify() {
		for(int i = n-1; i >=0; i--) {
			// 가장 큰 값을 맨뒤로 보내는 기능
			int temp = arr[0]; // root 노드와 마지막 원소를 바꾼다.
			arr[0] = arr[i];
			arr[i] = temp;
			
			
			int root = 0;
			int child = 1; // 기본값
			
			
			do {
				// 자식중 더 큰값 찾기
				child = 2 * root+1;
				if(child < i-1 && arr[child] < arr[child+1]  ) {
					child = child+1;
				}
				
				
				if(child < i && arr[root] < arr[child]) {
					temp = arr[root]; // root 노드와 마지막 원소를 바꾼다.
					arr[root] = arr[child];
					arr[child] = temp;
					
				}
				root = child;
				
			}while(child < i);
		}
			
		
		
	}
}
