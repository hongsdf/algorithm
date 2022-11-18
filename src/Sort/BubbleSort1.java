package Sort;

// 하나의 번호로 모든 수랑 비교 O(n2) 복잡도
public class BubbleSort1 {
	public static void main(String[] args) {
		int arr[] = new int[] {1,10,5,8,7,6,4,3,2,9};
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] < arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
		}
		for(int num :arr) {
			System.out.print(num +" ");			
		}
	}
}
