package Sort;

public class Heap {
	public static void main(String[] args) {
		int arr[] = {10, 26, 5, 37, 1, 61, 11, 59, 15, 48, 19};
		int n = arr.length;
		for(int i=1; i<n; i++) { // 1 2 3 4 5 6
			int c= i;
			do {
				int root = (c-1)/2; // 각 노드의 자식 찾기 // 0번의 자식은 1,2 [ 1번의자식 3,4 ] [2번의 자식은 5,6
				if(arr[root] < arr[c]) { // 자식 노드 의 값이 더 크면 arr[root] < arr[c] 교환
					int tmp = arr[c];
					arr[c] = arr[root];
					arr[root] = tmp;
				}
				c = root; // 1번 노드 3,4자식노드를 탐색하고 부모노드 0번까지 탐색
				
			}while(c != 0);
		}
		
		for(int i= n-1; i>=0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			int root = 0;
			int c = 1;
			
			do {
				c = root * 2 +1;
				
				if( c<i-1 && arr[c] < arr[c+1]) { // 더큰 자식노드의 라인을 살피기 (1번 노드이면 3,4) , (2번노드 이면 5,6)
					c++;
				}
				if(c<i && arr[root] < arr[c]) { 
					tmp = arr[c];
					arr[c] = arr[root];
					arr[root] = tmp;
				}
				root = c; //  자식 노드가 부모노드가 된다 (즉 2번 자식,5,6) => 5,6을 탐색할시 2번이 루트이다.
				
			}while(c<i);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(int a:arr)
		System.out.print(a+" ");
		
	}
}
