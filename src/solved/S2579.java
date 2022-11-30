package solved;
import java.io.*;

public class S2579{
    public static int arr[]; // 계단 배열 정보입력
    public static int dp[]; // 누적 계단수 정보
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine());
		arr = new int[N+1];// N == 1이면 크기가 2개가 된다.
		dp = new int[N+1];
		for(int i = 1; i <=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        // 초기화 계단수 - 1개까지 초기화하는 것이 좋다
        dp[0] = 0;
        dp[1] = arr[1];
        // N이 1일때 예외처리 
        if(N == 1){
            System.out.println(dp[N]);
            return;
        }
         dp[2] = arr[1] + arr[2]; // 1예외처리를 해주지 않으면 dp[2]째 값은 없다.
         
        br.close();
        BottonFind(N);
        System.out.println(dp[N]);
        
        //int answer = find(N);
        //System.out.println(answer);
       }
    // TOP-DOWN 구현
        public static int find(int n){
            if(n <= 0 ){
                return 0;
            }
            if(dp[n] == 0){
                dp[n] = Math.max(find(n-2),find(n-3) +arr[n-1]) +arr[n];
            }
            return dp[n];
        }
    // Bottom-up 구현
    public static void BottonFind(int n){
        for(int i = 3; i <=n; i++){
            dp[i] = Math.max(dp[i-2]+ arr[i], dp[i-3] + arr[i-1]+arr[i]);
        }
    }
   
}