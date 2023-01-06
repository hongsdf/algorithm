package Groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마름모기법{
	public static int N;
	public static int arr[][];
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 arr = new int[N+1][N+1];
//		for(int i = 1; i <=N; i++) {
//			StringTokenizer token = new StringTokenizer(br.readLine()," ");
//			for(int j = 1; j <=N; j++) {
//				arr[i][j] = Integer.parseInt(token.nextToken());
//			}
//		}
		String str[] = br.readLine().split(" ") ;
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		int size = Integer.parseInt(str[2]);
		solve(x,y,size);
		for(int i = 1; i <=N; i++) {
			for(int j = 1; j <=N; j++) {
				System.out.printf("%d",arr[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void solve(int x, int y, int r) {
		// 마름모 부분 채우기는 윗부분
		// 1-base 시작
		for(int i = r; i >= 0; i--) {
			for(int j = -i; j <=i; j++) {
				if(x - r + i >= 1 && x - r +i <= N && y + j >=0 && y + j<=N) {
					arr[x - r + i][y + j] = 1;
				}
			}
		}
		
		
		
		// 아랫부분
		for(int i = 1; i<=r; i++) {
			for(int j = -r+i; j <=r-i  ; j++) {
				if(x+i >= 1 && x + i <= N &&  y+j >=1 && y+j <=N) {
					arr[x+i][y+j] = 1;
				}
			}
		}
		
		
		
	}
}