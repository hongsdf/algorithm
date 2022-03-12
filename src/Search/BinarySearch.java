package Search;

// 재귀함수를 실행시 범위를 반으로 줄여가며 진행한다 
// 시간 복잡도 O(log2^N)
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {3,2,5,4,28,6,7,8,9,10};
		int target = 28;
		int n = arr.length;
		int res = solution(arr,0,n-1,target);
		if(res != -1)
		System.out.println(res+"번째 에서 찾았습니다");
		
	}

	private static int solution(int[] arr, int start, int end,int target) {
		
		if(start > end) return -1;
		
		int mid = (start + end) /2 ; //4
		
		if(arr[mid] == target) {
			return mid;
		}else if(arr[mid] > target) {
			return solution(arr, start, mid-1, target);

		}else {
			return solution(arr, mid+1, end, target);
		}
		
	}
}
