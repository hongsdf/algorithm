package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 4개의 연속된 밟을수 없다.
 * 요점
 * 계단수 문제에서 초기화시 4개 까지 초기화 하는 것이 좋다
 * dp[1],dp[2],dp[3],dp[4]
 * 
 * 두번째 
 * 마지막 지점은 밟아야하므로 이전의 경우를 계산한다
 * 살펴볼 요점은 n-2지점, n-3,n-4지점이렇게 존재한다.
 * n-1을 살펴본다면 n-1 + arr[n] + arr[n-2] 이렇게 연속3개 조합일것이다.
 * 하지만 n-4에서 바라보는 조합이랑 같다 dp[n-4] == dp[n-1]
 * 
 * n-2 조합 = dp[n-2]지점까지 완성되어있고 마지막 arr[N]을 더한다
 * n-3 조합 = dp[n-3] + arr[n-1] + arr[n] 더한다
 * n-4 조합 = dp[n-4] + arr[n-2] + arr[n-1] + arr[n]
 * 
 * 이중 값이 큰것으로 선택
 * 연속된 조합 x개까지라면 보통 경우가 x-1가지를 살펴볼것이다.
 * ex) x== 5라면
 * Math.max(1가지 경우,2가지 경우,3가지 경우,4가지 경우 )
 * 
 */
public class S2579_2 {
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		for(int i = 1; i <=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = arr[1] + arr[2] + arr[3];
		dp[4] = Math.max(arr[1]+arr[3]+arr[4], arr[1]+arr[2]+arr[4]);
		
		
		
		
//		for(int i = 4; i<=N; i++) {
//			dp[i] =  Math.max(dp[i-3] + arr[i-1] + arr[i], Math.max(dp[i-4]+arr[i-2]+arr[i-1]+arr[i], dp[i-2]+ arr[i]));
//		}
//		
//		System.out.println(dp[N]);
		
		  
		int answer = Top_Down(N);
		System.out.println(answer);
	}
	private static int Top_Down(int N) {
		// TODO Auto-generated method stub
		if(N <= 0) return 0;
		if(dp[N] == 0) {
			dp[N] =  Math.max(Top_Down(N-4)+arr[N-2]+arr[N-1]+arr[N],   Math.max(Top_Down(N-3) + arr[N-1] + arr[N], Top_Down(N-2)+arr[N]));
		}
		return dp[N];
	}
}
