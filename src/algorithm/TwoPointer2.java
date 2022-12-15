package algorithm;

public class TwoPointer2 {
	public static void main(String[] args) {
		int arr[] = {5,5,5,5,5};
		int M = 6;
		int answer = solve(arr,M);
		System.out.println(answer);
	}

	private static int solve(int[] arr, int m) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;
		for(int i = 0; i <arr.length; i++) {
			
			while(sum < m && end < arr.length) {
				sum += arr[end];
				end++;
			}
			if(sum == m) {
				answer++;
			}
			sum -= arr[i];
			
		}
		
		return answer;
	}
	

}
