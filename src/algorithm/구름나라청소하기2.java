package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Adj{
	ArrayList<Integer>[] list;
}


public class 구름나라청소하기2 {
	public static int N,K;
	public static int dp[][];
	public static int visit[];
	public static int arr[];
	
//	public static Adjency1 adj;
	public static int board[][] = new int[1004][1004];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
//		adj = new Adjency1(N+1); // 1베이스
		
		ArrayList<int[]>list = new ArrayList<int[]>();
		for(int i = 0; i <N-1; i++){
				String str1[] = br.readLine().split(" ");
				int a = Integer.parseInt(str1[0]);
				int b = Integer.parseInt(str1[1]);
				list.add(new int[] {a,b});
				list.add(new int[] {b,a});
//				
//				board[a][b] = 1;
//				board[b][a] = 1;			
		}
		arr = new int[N+1];
		String str2[] = br.readLine().split(" ");
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(str2[i-1]);
		}
		
		// 다이나믹 프로그래밍으로 구현
		dp = new int[1004][1007];
		visit = new int[1007];
		dp[0][0] = 1; // dp [curr][weight] := curr해당 지점이 weight을 담을수 있다.
		DFS(1,0); 
		for(int i = K; i>= 0; i--) {
			if(visit[i] == 1) { // i번째 지점이 통과 되면
				bw.write(i+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void DFS(int curr, int pre) { // 현재 지점과 이전 지점
		for(int i = 0; i<=K; i++) {
			if(dp[pre][i] == 1) { // 이전 지점이 i번째 무게을 채웠다면
				visit[i] = dp[curr][i] = 1; // 현재 지점도 최소 이전 지점 무게을 담을 수 있다.
				if(i + arr[curr] <= K) { // i무게 + 현재 무게를 수용할수 있다면
					visit[i+arr[curr]] = dp[curr][i+arr[curr]] = 1;
				}
				
			}
			for(int next : board[curr]) {
				if(next == pre) continue;
				DFS(next,curr);
			}
		}
	}
}
