package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// Two Pointer
		int FirstPointer = 0; int SecondPointer = 0;
		// FristPointer := 두 포인터 사이값이 sum이상일 경우 [SecondPointer,FirstPointer] 사이 길이 출력 폐구간 길이 
		// SecondPointer := 첫번째 포인터 부터 ~ 두번째 포인터 사이 값이 < S 보다 작으면 두번째 포인터만 이동
		int sum = 0;// 구간 합
		int ans = Integer.MAX_VALUE;
		while(true) {
			if(sum >= S) { // 첫번째 포인터가 움직이는 경우:= 구간 합이 S 이상 일 경우
				// 길이 
				sum -= arr[FirstPointer++]; // sum이 S보다 작아질때 까지  FirstPointer 이동
				ans = Math.min(ans, SecondPointer - FirstPointer+1 ); // SecondPointer - FirstPointer+1 := 페구간 길이
				
				
				
				
			}else if(SecondPointer == N) { // 두번째 포인터가 끝까지 도달 했을 경우
				break; // 배열안의 모든 순회
			}else { // S보다 sum이 작은경우
				sum += arr[SecondPointer++];
			}
			
			
		}

		if(ans == Integer.MAX_VALUE) { // 불가능한 경우
			System.out.println(0);
		}else { // 최소 길이 출력
			System.out.println(ans);
		}
		
		
	}
}
