package Sort;

public class Select {
	public static int ans = 98765321;
	public static void main(String[] args) {
		int arr[] = {5,3,11,2,9};
		int n = arr.length;
		solution2(arr, n , 0, 4);
		
		System.out.println(ans);
	}

//	private static void solution(int[] arr, int n, int begin, int end) {
//		if(begin > end) {
//			return;
//		}
//		
//		ans = Math.min(ans, arr[begin]);
//		
//		solution(arr,n,begin+1,end);
//	}
	
	private static void solution2(int[] arr, int n, int begin, int end) {
		if(begin > end) {
			return;
		}
		
		ans = Math.min(ans, arr[end]);
		
		solution2(arr,n,begin,end-1);
	}
}
