package algorithm;

public class TwoPointer {
	public static void main(String[] args) {
		int arr[] = {5,5,5,5,5};
		int M = 6;
		int answer = solve(arr,M);
		System.out.println(answer);
	}
	// 투 포인터 구현 : 완점탐색인 경우는 총 O(n ^ 2) - 시간복잡도
	// 모든 경우를 탐색할수있다.
	// 하지만 시간복잡도가 높다
	
	// 투포인터의 경우도 모든 경우를 탐색할수 있다.
	// 시간 복잡도는 O(n)이 걸린다.
	// 그이유는? 한 반복문안에 start, end 포인터를 하나씩 움직인다. 2N의 시간복잡도 라고 생각한다.
	// 1.처음 sum = arr[start] : start,end가 같은 지점을 가리킴
	// 2. sum == m 카운트 증가
	// 3. sum < m  end지점 증가++ => sum += arr[end]
	// 4. sum >= m start지점증가 => sum -= arr[start]
	// 5. start == 마지막 지점 && end == 마지막 지점 일때 종료
	
	// 2->3->4 를 종료 시점을 만나기 전까지 계속 수행한다.
	
	
	private static int solve(int[] arr, int m) {
		// 두개의 포인터를 생성
		int start = 0;
		int end = 0;
		int sum = arr[0]; // 초기값 start와 end가 같은지점을 가리킴 0번째 인덱스
		int cnt = 0;
		while(true) { // O(2N)
			// 탈출조건 : start,end지점이 마지막 지점에서 겹쳤다.
			if(sum == m) cnt++; // 1. sum == m이 랑 같다면 cnt증가
			if(start == arr.length-1 && end == arr.length-1) break; // 탈출조건 start , end가 마지막 지점인경우
			
			// sum < m 보다 작으면 end++;
			if(sum < m) {
				end++;
				sum += arr[end];
			}else if(sum >= m) {
				// sum > m start++;
				sum -= arr[start];
				start++;

			}
		}
		// 만약 포인터 사이의 값들을 더했을때 m의 값이면 cnt++;
		return cnt;
	}
}
