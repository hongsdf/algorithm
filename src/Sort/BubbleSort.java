package Sort;

public class BubbleSort {
	public static void bubble(int arr[]) {
		// arr : 6
		for(int i =0; i<arr.length-1; i++) {
			
			for(int j =0; j<arr.length-1  -i; j++) { // -i 는 횟수를 줄이기 위해 필요
				//  	for(int j =i; j<arr.length-1; j++) { 
			
				
				
				
				// i = 0 , j =0 ,j<5 
//				 i = 1 , j =0 j<5-1 :4
//				 i = 2 , j =0 j<5-2 :3
				 if(arr[j] > arr[j+1]) {
					 int temp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = temp;
					 
				 }
				
			}
		
		}
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		int n = 6;
		int []arr = {5,2,3,1,4,0};
		
		bubble(arr);
		
	}
	

}
