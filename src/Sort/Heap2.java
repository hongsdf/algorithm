package Sort;

public class Heap2 {
	public static int arr[] = {7,9,10,11,5,1,2,3,7};
	//public static int arr[] = {7,6,5,8,3,5,9,1,6};
	public static int n = 9;
	public static void main(String[] args) {
		heapsort();
		//heapify();
		for(int i = n-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify2(0,i);	
		}
		for(int n :arr) {
			System.out.printf("%d ",n);
		}
	}
	private static void heapify2(int root,int i) {
		
		int child = 2 * root +1;
		if(child >= i) {
			return;
		}

		if(child < i-1 &&arr[child] < arr[child+1]) {
			child = child+1;
		}
		
		if(child < i && arr[child] > arr[root]) {
			int temp = arr[child];
			arr[child] = arr[root];
			arr[root] = temp;
		}
		root = child;
		heapify2(root,i);
		
		
	}
	private static void heapify() {
		// root <--> 맨 아래 인덱스 swap
		// 다시 heapsort 수행
		for(int i = n-1; i >=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			int root = 0;
			int c = 1;
			// 자식과 부모를 비교 0까지 올라감
			do {
				c = (2 * root) +1;
				
				// 2개의 자식중 큰값이으로 swap
				if(c < i-1 && arr[c] < arr[c+1]) {
					c++;
				}
				if(c < i && arr[c] > arr[root] ) {
					temp = arr[c];
					arr[c] = arr[root];
					arr[root] = temp;
				}
				root = c;
				
				
			}while(c < i);
		}
		
	}
	private static void heapsort() {
		// 완전 이진 트리 구조로 최대힙, 최소힙을 구성한다.
		// 인덱스 들어 온 순서대로 최대힙을 만든다.
		// 부모와 자식간 비교하기
		// 부모는 0인덱스
		
		for(int i =1;i<n; i++) {
			// 자신의 부모 찾기  0까지 찾는다.
			int root = 0;
			int c = i;
			do {
				root = (c-1)/2;
				if(arr[root] < arr[c]) {
					int temp = arr[root];
					arr[root] = arr[c];
					arr[c] = temp;
				}
				c = root;
			}while(c != 0);
		}
		
	}
}
