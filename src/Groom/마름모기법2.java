package Groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마름모기법2 {
	public static int N;
	public static int arr[][];
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 arr = new int[N+1][N+1];
		for(int i = 1; i <=N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <=N; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		String str[] = br.readLine().split(" ") ;
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		int size = Integer.parseInt(str[2]);
		int ans = solve(x,y,size);
		System.out.println(ans);
		
	}
	private static int solve(int a, int b, int size) {
		int cnt = 0;
		// 윗 부분 탐색
		for(int i = size; i >= 0; i--) {
			for(int j = -i; j<=i; j++) {
				if(1<= a - size + i&&  a - size + i <=N &&  1<= b + j && b + j <= N) {
					if(arr[a -size + i][b+j] == 1) cnt++;
					// offset 계산 현재위치(a)- 크기(size) + size == 상대위치로 변환
				}
			}
		}
		// 아랫 부분
		for(int i = 1; i<= size; i++) {
			for(int j = -size+i; j<= size-i; j++) {
				if(1 <= a +i && a +i <= N && 1<= b+j && b + j <=N  ) {
					if(arr[a +i][b+j] == 1) cnt++;
				}
			}
		}
		// 마름모 탐색
		
		
		return cnt;
	}
}
