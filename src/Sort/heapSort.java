package Sort;

public class heapSort {
	public static void main(String[] args) {
		int arr[] = {7,6,5,8,3};
		int n = 5;
		// 힙을 구성
//		
		// 힙 : 최대값 최소값을 찾는 과정
		for(int i =1; i<n; i++) {
			// c: 자식노드 : for(int i=1;;) 1부터인이유 arr[0]은 처음 루트이기때문에
			int c = i; // c == 1~8
			do {
				int root = (c-1)/2;
				// 뿌리 노드보다 자식노드가 크다면
				if(arr[root] < arr[c]) {
					// 스왑
					int tmp = arr[c];
					arr[c] = arr[root];
					arr[root] = tmp;
				}
				c = root;
			}while( c != 0);
			
		}
		
		
		// 크기를 줄여가며 반복적으로 힙 구성 => 끌어 올리기 ㅁ
		for(int i = n-1; i>=0; i--) {
			// 처음 0번인덱스와 끝 인덱스 교환하기
			int tmp = arr[0];
			arr[0] = arr[i]; // 즉 idx 9번과 0번 체인지
			arr[i] = tmp;
			int root = 0;
			int c = 1;
			
			
			// 힙정렬을 하여 루트와 노드들의 인덱스를 교환하는 작업
			do {
				c =  2 * root + 1; //  처음 c ==1 이다 그 이유는  : 시작노드는 0(루트) 제외하고 1번부터 확인하기 위해서인 점화식 => 점화식은 1번노드부터 각 노드에 맞는 자식노드까지 탐색하는 점화식
				// 자식중 더 큰값을 찾기
				if(c < i-1 && arr[c] < arr[c+1]) { // c < i-1 : c==1 이면 (i=4)일때 1~3노드를 본다
					
					//        7
					//      3   5        =>   3,5,6 을 확인
					//    6  8
					
//					arr[c] < arr[c+1] 이후 적용되면 c++;
					
					c++;
				}
				
				
				// c증가 되면 arr[0] < arr[2]를 확인 => 하는 이유 : 처음 0번인덱스와 i를 교환하였다. 하지만 자식노드중 다른한쪽이 더 큰경우 여기 서 바꾼다.
				
					    //		      (7)
							//      3   (5)        =>  7,5를 확인
							//    6  8
				
				// 성립이 되면 교환
				
				
				
				// 루트보다 자식이 크다면 교환
				if(c < i && arr[root] < arr[c]) { // 오른쪽(자식 노드)와 루트노드를 교환하는 단계 
					// c < i : 2 < 4   2번 노드 ~ 3
					tmp = arr[c];
					arr[c] = arr[root];
					arr[root] = tmp;
				}
				root = c;
				
			} while(c<i); // 자식노드가 i:9~0보다 작을때 까지 
			
			
		}
		for(int i =0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		
		
	}
}
