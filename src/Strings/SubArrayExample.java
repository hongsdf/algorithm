package Strings;

public class SubArrayExample {
	public static void main(String[] args) {
		int arr [] = new int[] {1,2,3,4,5};
		int n = arr.length;
		for(int i  = 0 ; i < n; i++) {
			for(int j = 0; j <n-i ; j++) {
				int start = j; int end = i+j;
				System.out.print("(");
				for(int k = start; k <= end; k++) {
					if(k == end) {
						System.out.print(arr[k]);
					}else {
						System.out.print(arr[k]+",");						
					}
				}
				System.out.print(")");
			}
			System.out.println();
		}
		
		//1  5개   1,2,3,4,5        
		//2  4개	  1,2 2,3 3,4 4,5
		//3  3개	  1,2,3 2,3,4 3,4,5
		//4  2개	  1,2,3,4 2,3,4,5
		//5  1개	  1,2,3,4,5
		
		
		// 뒤집기
		for(int i = 0; i <n; i++) {
			for(int j = 0; j <= i ; j++) { // 그룹수 
				int start = j; int end = n-i+j; // 출발점이 움직인다 변수 사용해야함
				System.out.print("(");	
				for(int k = start; k<end; k++) { //  i = 1 0 ~ 4, 1 ~ 5  i = 2 0 ~ 3, 1~4, 2~5
					if(k == end-1) {
						System.out.print(arr[k]);
					}else {
						System.out.print(arr[k]+",");
					}
				}
				System.out.print(")");	
			}
			System.out.println();
		}
		
		
		
	}
}
