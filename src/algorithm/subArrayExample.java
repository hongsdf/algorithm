package algorithm;

public class subArrayExample {
	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4,5};
		int n = arr.length;
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j <=i; j++) {
				int start = j;
				int end = n+j-i;
				System.out.print("(");
				for(int k = start; k < end ;k++) {
					if(k == end -1) {
						System.out.print(arr[k]);
					}else {
						System.out.print(arr[k]+",");						
					}
				}
				System.out.print(")");
				if(j != i) {
					System.out.print(",");					
				}
			}
			System.out.println();
		}
	}
}
