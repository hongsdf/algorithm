package Sort;

public class heap1 {
	public static void main(String[] args) {
		int arr[] = {10, 26, 5, 37, 1, 61, 11, 59, 15, 48, 19};
		int n = arr.length;
		for(int i=1; i<n;i++) { // 0   1 ~ 9  10
			int childnode = i;
			do { // heaf 과정 : 최대값/최소값을 찾아 루트로 끌어올리기
				// childnode 1번이라면  1번의 부모 찾기
				int root = (childnode-1)/2;
				// childnode 노드가 더 크다면 root와 교환
				if(arr[root] > arr[childnode]) {
					int tmp = arr[childnode];
					arr[childnode] = arr[root];
					arr[root] = tmp;
				}
				childnode = root;
				
			}while(childnode !=0);
			
		}
		
		
		// 이제 루트와 끝점하고 교환하는 작업
		for(int i =n-1; i >=0; i--) {
			// arr[0] : root
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			
			int root = 0; // root: 0
			int c =1; // 자식은 1번노드 부터
			
			do {
				c = 2 * root +1; // 2 * : 자식 노드가 2개씩 이므로 지정, 삼진트리이면 3*root +1
				// 한 노드의 자식노드 2개중 큰 값 찾기
				if(c < i-1 && arr[c] > arr[c+1]) {
					// 왼쪽 노드가 arr[c]가 크면 이 조건 절은 실행 하지 않음
					// 오른쪽 노드가 크면 이제 2번 자식 노드를 찾기 5,6중
					// 즉 자식중 큰 노드로 진행
					c++;
				}
				//
				// 큰 자식 노드와 root와 교환 heaf 과정
				if( c <i && arr[root] > arr[c]) {
					tmp = arr[c];
					arr[c] = arr[root];
					arr[root] = tmp;
				}
				// 자식이 루트가 되어 자식의 노드의 자식 노드들까지 탐색을 진행 0->1 || 2 ->3,4 || 5,6
				// 손자 노드 까지 탐색
				root = c;	
			}while(c < i); //c < 9(1~8) // c < 8 (1~7) .... c < 2 ( 1 ~ 2)
			// 각 노드 1~9 , 1~8, 1~7 ... 1~2
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		
	}
}
